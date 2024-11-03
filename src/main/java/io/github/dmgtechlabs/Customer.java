package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Customer extends Person implements Dao {

	private String uuid;
	<<<<<<< HEAD
	private int id;

	public Customer(int customerId, String email, int id, String fname, String lname, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		this.id = customerId;
		 == == == =
	private int personId;

	public Customer(int customerId, String email, int id, String fname, String lname, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		this.personId = personId;
		 >>> >>> > 3ab3323 // TODO: generate uuid
	}

	public String getUuid() {
		return uuid;
	}

	public int getPersonId() {
		 << << << < HEAD
		return id;
		 == == == =
		return personId;
		 >>> >>> > 3ab3323
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
