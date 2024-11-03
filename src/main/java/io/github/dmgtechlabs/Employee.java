package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Employee extends Person implements Dao {

	<<<<<<< HEAD
	private int id;
	=======
	private int employeeId;
	>>>>>>> 3ab3323
	private float salary;

	public Employee(int employeeId, float salary, int id, String fname, String lname, String email, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		 << << << < HEAD this.id = employeeId;
		 == == ==
			= this.employeeId = employeeId;
		 >>> >>> > 3ab3323
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public int getEmployeeId() {
		 << << << < HEAD
		return id;
		 == == == =
		return employeeId;
		 >>> >>> > 3ab3323
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
