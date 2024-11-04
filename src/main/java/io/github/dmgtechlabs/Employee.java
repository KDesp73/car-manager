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
		try(PostgresConnection db = Database.connection()) {
			db.callProcedure(Functions.INSERT_EMPLOYEE, id, salary);
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.INSERT, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Insert Employee failed", ex);
			return false;
		}
	}

	@Override
	public boolean update(Object... values) {
		try(PostgresConnection db = Database.connection()){
			db.callProcedure(Functions.UPDATE_EMPLOYEE, Utils.appendFront(id, values));
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.UPDATE, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Update Employee failed", ex);
			return false;
		}
	}

	@Override
	public boolean delete() {
		try(PostgresConnection db = Database.connection()){
			db.callProcedure(Functions.DELETE_EMPLOYEE, this.id);
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL).logSQL(null, SQLogger.SQLOperation.DELETE, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Delete Employee failed", ex);
			return false;
		}
	}

}
