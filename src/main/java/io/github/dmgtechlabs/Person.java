package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import io.github.dmgtechlabs.exceptions.InvalidEmailException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	private String birthYear;
	private Gender gender;
	private Email email;

	public Person() {}
	public Person(String name, String email) {
		this.fname = name.split(" ")[0];
		this.lname = name.split(" ")[1];
		this.email = new Email(email);
		
		if (!this.email.validate()) {
			throw new InvalidEmailException("'" + email + "' is not valid");
		}
	}
	public Person(int personId) {
		id = personId;
	}

	public Person(int id, String fname, String lname, String birthYear, Gender gender, String email) {
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

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getBirthYear() {
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

	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.INSERT,
			Functions.INSERT_PERSON,
			id, fname, lname, birthYear, gender.ordinal(), email.address
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

//	public static List<Person> selectAll() {
//		PostgresConnection db = Database.connection();
//
//		ResultSet rs = db.callFunction(Functions.SELECT_ALL_CUSTOMERS);
//
//		List<Person> result = new ArrayList<>();
//		try {
//			if (rs.isClosed()) {
//				return null;
//			}
//
//			while (rs.next()) {
//				Person p = new Person(rs.getInt(6), rs.getString(1), rs.getString(2), rs.getString(3), int2Gender(rs.getInt(1)), rs.getString(1));
//				result.add(p);
//			}
//			rs.close();
//			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all persons", SQLogger.SQLOperation.SELECT, null);
//		} catch (SQLException ex) {
//			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
//		}
//
//		db.close();
//
//		return result;
//	}

	@Override
	public String toString() {
		return "Person{" + "fname=" + fname + ", lname=" + lname + ", birthYear=" + birthYear + ", gender=" + gender + ", email=" + email + '}';
	}

}
