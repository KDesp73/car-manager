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
public class Employee extends Person implements Dao, UIObject {

	private int id;
	private float salary;
	private int personId;

	public Employee(float salary, String fname, String lname, int birthYear, Gender gender, String email) {
		super(fname, lname, birthYear, gender, email);
		this.salary = salary;
	}

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

	public Employee(
		int id,
		float salary,
		int personId,
		String fname,
		String lname,
		String email,
		int birthYear,
		Gender gender
	) {
		super(personId, fname, lname, birthYear, gender, email);
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
			salary, super.getFname(), super.getLname(), super.getBirthYear(), super.getGender().ordinal(), super.getEmail()
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

	public static List<Employee> selectAll() {
		List<Employee> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Functions.SELECT_ALL_EMPLOYEES + "__"); // TODO: replace method in postgres
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Employee e = new Employee(
					rs.getInt("id"),
					rs.getFloat("salary"),
					rs.getInt("employee_person_fk"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getString("email"),
					rs.getInt("birth_year"),
					int2Gender(rs.getInt("gender"))
				);
				result.add(e);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all employees", SQLogger.SQLOperation.SELECT, null);
		} catch (SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
		}

		return result;
	}

	@Override
	public String UIString() {
		return this.getFname() + " " + this.getLname() + " " + this.getBirthYear() + " " + this.getGender() + " " + this.getEmail() + " " + salary;
	}
	
	public static String[] listToArray(List<Employee> list) {
		String[] result = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			result[i] = list.get(i).UIString();
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", salary=" + salary + ", personId=" + personId + '}' + super.toString();
	}

	@Override
	public String toHTML() {
		Person person = (Person) this;
		
		StringBuilder sb = new StringBuilder();		
		sb.append(Utils.HTML.header(1, "Info"));
		sb.append(Utils.HTML.ul(
			"First name: " + person.getFname(),
			"Last name: " + person.getLname(),
			"Birth Year: " + person.getBirthYear(),
			"Gender: " + person.getGender().name(),
			"Email: " + person.getEmail(),
			"Salary: " + this.salary + "$"
		));		
		return sb.toString();
	}

	@Override
	public Object[] objArray() {
		return new Object[]{
			this.salary,
			this.getName(),
			this.getBirthYear(),
			this.getGender(),
			this.getEmail()
		};
	}
}
