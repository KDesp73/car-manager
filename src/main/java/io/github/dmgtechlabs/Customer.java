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
public class Customer extends Person implements Dao, UIObject {

	private int id;
	private int personId;

	public Customer(
		int id,
		int personId,
		String fname,
		String lname,
		int birthYear,
		String email,
		Gender gender
	) {
		super(personId, fname, lname, birthYear, gender, email);
		this.id = id;
	}

	public Customer(int id, int personId) {
		super(personId);
		this.id = id;
	}

	// name = fname + " " + lname
	public Customer(int id, String name, String email) {
		super(name, email);
		this.id = id;
	}

	public Customer(int id) {
		this.id = id;
	}

	public Customer(String fname, String lname, int birthYear, Gender gender, String email) {
		super(fname, lname, birthYear, gender, email);
	}

	public Customer(int id, String fname, String lname, int birthYear, Gender gender, String email) {
		super(id, fname, lname, birthYear, gender, email);
	}

	@Override
	public int getId() {
		return id;
	}

	public int getPersonId() {
		return personId;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", personId=" + personId + '}';
	}

	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.INSERT,
			Functions.INSERT_CUSTOMER,
			this.getFname(), this.getLname(), this.getBirthYear(), this.getGender().ordinal(), this.getEmail()
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.UPDATE,
			Functions.UPDATE_CUSTOMER,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.DELETE,
			Functions.DELETE_CUSTOMER,
			this.id
		);
	}

	private static List<Customer> select(String functionName, Object... params) {
		List<Customer> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(functionName, params);

			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Customer c = new Customer(
					rs.getInt("id"),
					rs.getInt("customer_person_fk"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getInt("birth_year"),
					rs.getString("email"),
					int2Gender(rs.getInt("gender"))
				);
				System.out.println(c);
				result.add(c);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all customers", SQLogger.SQLOperation.SELECT, null);
		} catch (SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
		}

		return result;
	}

	public static List<Customer> selectByEmail(String email) {
		return select(Database.SCHEMA + ".select_customers_by_email", email);
	}

	public static List<Customer> selectAll() {
		return select(Functions.SELECT_ALL_CUSTOMERS + "__");
	}

	public String UIString() {
		return this.getFname() + " " + this.getLname() + " " + this.getBirthYear() + " " + this.getGender() + " " + this.getEmail();
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
			"Email: " + person.getEmail()
		));
		return sb.toString();
	}

	/**
	 * new String[]{"Name", "Birth Year", "Gender", "Email"}
	 * 
	 * @return 
	 */
	@Override
	public Object[] objArray() {
		return new Object[]{
			this.getName(),
			this.getBirthYear(),
			this.getGender(),
			this.getEmail(),};
	}
}
