package io.github.dmgtechlabs;

import io.github.dmgtechlabs.exceptions.InvalidEmailException;

/**
 *
 * @author kdesp73
 */
public class Person implements Dao {

	public static enum Gender {
		MALE, FEMALE, OTHER
	};

	private String fname;
	private String lname;
	private int birthYear;
	private Gender gender;
	private Email email;

	public Person(String fname, String lname, String email, int birthYear, Gender gender) {
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

	public static Gender int2Gender(int gender) {
		for (Gender g : Gender.values()) {
			if (gender == g.ordinal()) {
				return g;
			}
		}
		return null;
	}

	@Override
	public void insert() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String toString() {
		return "Person{" + "fname=" + fname + ", lname=" + lname + ", birthYear=" + birthYear + ", gender=" + gender + ", email=" + email + '}';
	}

}
