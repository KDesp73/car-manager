package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Employee extends Person implements Dao {

	private float salary;

	public Employee(float salary, String fname, String lname, String email, int birthYear, Gender gender) {
		super(fname, lname, email, birthYear, gender);
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	@Override
	public void insert(Object obj) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update(Object obj) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete(Object obj) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
