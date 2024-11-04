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
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.INSERT, 
			Functions.INSERT_PERSON,
			fname, lname, birthYear, gender, email, id
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.UPDATE, 
			Functions.UPDATE_PERSON,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.DELETE, 
			Functions.DELETE_PERSON,
			this.id
		);
	}

	@Override
	public String toString() {
		return "Person{" + "fname=" + fname + ", lname=" + lname + ", birthYear=" + birthYear + ", gender=" + gender + ", email=" + email + '}';
	}

}
