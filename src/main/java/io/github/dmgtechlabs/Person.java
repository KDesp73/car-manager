package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Person {

	public static enum Gender {
		MALE, FEMALE, OTHER
	};

	private String fname;
	private String lname;
	private int birthYear;
	private Gender gender;
	private String email; // FIXME: Email class

	public Person(String fname, String lname, String email, int birthYear, Gender gender) {
		this.fname = fname;
		this.lname = lname;
		this.birthYear = birthYear;
		this.gender = gender;
		this.email = email;
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
		return email;
	}

	public Gender int2Gender(int gender) {
		for (Gender g : Gender.values()) {
			if (gender == g.ordinal()) {
				return g;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Person{" + "fname=" + fname + ", lname=" + lname + ", birthYear=" + birthYear + ", gender=" + gender + ", email=" + email + '}';
	}

}
