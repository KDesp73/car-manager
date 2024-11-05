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
	private int personId;

	public Employee(int id, float salary, int personId, String fname, String lname, String email, int birthYear, Gender gender) {
		super(personId, fname, lname, email, birthYear, gender);
		this.id = id;
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
		//TODO
	}

	@Override
	public void update(Object... values) {
		//TODO
	}

	@Override
	public void delete() {
		//TODO
	}

}
