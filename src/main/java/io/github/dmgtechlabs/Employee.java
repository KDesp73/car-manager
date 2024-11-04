package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.connections.PostgresConnection;

/**
 *
 * @author kdesp73
 */
public class Employee extends Person implements Dao {

	private int id;
	private float salary;

	public Employee(int employeeId, float salary, int id, String fname, String lname, String email, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		this.id = employeeId;
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public int getEmployeeId() {
		return id;
	}

	@Override
	public void insert() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.INSERT_EMPLOYEE, id, salary);
		db.close();
	}

	@Override
	public void update(Object... values) {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.UPDATE_EMPLOYEE, Utils.appendFront(id, values));
		db.close();
	}

	@Override
	public void delete() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.DELETE_EMPLOYEE, this.id);
		db.close();
	}

}
