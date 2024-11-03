package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Customer extends Person implements Dao {

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

	@Override
	public void insert() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update(Object... values) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
