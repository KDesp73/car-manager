package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	// name = fname + " " + lname
	public Employee(int id, String name, String email) {
		super(name, email);
		this.id = id;
	}
	
	public Employee(int id, int personId, float salary, String fname, String lname, int birthYear, Gender gender, String email) {
		super(personId, fname, lname, birthYear, gender, email);
		this.id = id;
		this.salary = salary;
	}
	
	public Employee(int id, int personId, float salary) {
		super(personId);
		this.id = id;
		this.salary = salary;
	}
	
	public Employee(int id) {
		this.id = id;
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
			id, super.getId(), salary
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
			this.id, super.getId()
		);
	}
	
	public static List<Employee> selectAll() {
		PostgresConnection db = Database.connection();

		ResultSet rs = db.callFunction(Functions.SELECT_ALL_EMPLOYEES);

		List<Employee> result = new ArrayList<>();
		try {
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getInt(2), rs.getFloat(3));
				result.add(e);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all employees", SQLogger.SQLOperation.SELECT, null);
		} catch (SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
		}

		db.close();

		return result;
	}
	
}
