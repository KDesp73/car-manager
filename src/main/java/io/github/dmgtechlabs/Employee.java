package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Employee extends Person {

	private float salary;

	public Employee(float salary, String fname, String lname, String email, int birthYear, Gender gender) {
		super(fname, lname, email, birthYear, gender);
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

}
