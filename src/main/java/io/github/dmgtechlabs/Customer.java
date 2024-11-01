package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Customer extends Person {

	private String uuid;

	public Customer(String email, String fname, String lname, int birthYear, Gender gender) {
		super(fname, lname, email, birthYear, gender);
		// TODO: generate uuid
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return "Customer{" + "uuid=" + uuid + '}';
	}

}
