package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

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
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.INSERT, 
			Functions.INSERT_EMPLOYEE,
			id, salary
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.UPDATE, 
			Functions.UPDATE_EMPLOYEE,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.DELETE, 
			Functions.DELETE_EMPLOYEE,
			this.id
		);
	}

}
