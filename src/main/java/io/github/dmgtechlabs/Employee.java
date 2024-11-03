package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Employee extends Person implements Dao {

	private int employeeId;
	private float salary;

	public Employee(int employeeId, float salary, int id, String fname, String lname, String email, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		this.employeeId = employeeId;
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public int getEmployeeId() {
		return employeeId;
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

}
