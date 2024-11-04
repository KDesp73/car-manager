package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import io.github.dmgtechlabs.exceptions.InvalidEmailException;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

/**
 *
 * @author kdesp73
 */
public class Person implements Dao {

	public static enum Gender {
		MALE, FEMALE, OTHER
	};

	private int id;
	private String fname;
	private String lname;
	private int birthYear;
	private Gender gender;
	private Email email;

	public Person(int id, String fname, String lname, String email, int birthYear, Gender gender) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.birthYear = birthYear;
		this.gender = gender;
		this.email = new Email(email);

		if (!this.email.validate()) {
			throw new InvalidEmailException("'" + email + "' is not valid");
		}
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public Gender getGender() {
		return gender;
	}

	public String getEmail() {
		return email.address;
	}

	public int getId() {
		return id;
	}

	public static Gender int2Gender(int gender) {
		for (Gender g : Gender.values()) {
			if (gender == g.ordinal()) {
				return g;
			}
		}
		return null;
	}

	@Override
	public boolean insert() {
		try(PostgresConnection db = Database.connection()) {
			db.callProcedure(Functions.INSERT_PERSON, fname, lname, birthYear, gender, email, id);
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.INSERT, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Insert Person failed", ex);
			return false;
		}
	}

	@Override
	public boolean update(Object... values) {
		try(PostgresConnection db = Database.connection()){
			db.callProcedure(Functions.UPDATE_PERSON, Utils.appendFront(id, values));
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.UPDATE, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Update Person failed", ex);
			return false;
		}
	}

	@Override
	public boolean delete() {
		try(PostgresConnection db = Database.connection()){
			db.callProcedure(Functions.DELETE_PERSON, this.id);
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.DELETE, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Delete Person failed", ex);
			return false;
		}
	}

	@Override
	public String toString() {
		return "Person{" + "fname=" + fname + ", lname=" + lname + ", birthYear=" + birthYear + ", gender=" + gender + ", email=" + email + '}';
	}

}
