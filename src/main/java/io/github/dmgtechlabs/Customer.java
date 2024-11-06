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
public class Customer extends Person implements Dao {

	private String uuid;
	private int id;
	private int personId;

	public Customer(
		int id, 
		String uuid, 
		int personId, 
		String fname,
		String lname, 
		int birthYear, 
		String email,
		Gender gender
	) {
		super(personId, fname, lname, birthYear, gender, email);
		this.id = id;
		this.uuid = uuid;
		// TODO: generate uuid
	}
	
	public Customer(String uuid, int id, int personId) {
		super(personId);
		this.uuid = uuid;
		this.id = id;
	}
	
	// name = fname + " " + lname
	public Customer(int id, String uuid, String name, String email){
		super(name, email);
		this.id = id;
		this.uuid = uuid;
	}
	
	public Customer(int id) {
		this.id = id;
	}

//	public Customer(int customerId, String uuid, String email, int id, String fname, String lname, int birthYear, Gender gender) {
//		super(id, fname, lname, email, birthYear, gender);
//		this.id = customerId;
//		this.uuid = uuid;
//		// TODO: generate uuid
//	}

	public String getUuid() {
		return uuid;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer{" + "uuid=" + uuid + '}';
	}
	
	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.INSERT, 
			Functions.INSERT_CUSTOMER,
			id, uuid, super.getId()
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
			this.id, super.getId()
		);
	}
	
	public static List<Customer> selectAll() {
		PostgresConnection db = Database.connection();

		ResultSet rs = db.callFunction(Functions.SELECT_ALL_CUSTOMERS + "__");

		List<Customer> result = new ArrayList<>();
		try {
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Customer c = new Customer(
					rs.getInt("id"),
					rs.getString("uuid"),
					rs.getInt("customer_person_fk"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getInt("birth_year"),
					rs.getString("email"),
					int2Gender(rs.getInt("gender"))
				);
				result.add(c);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all customers", SQLogger.SQLOperation.SELECT, null);
		} catch (SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
		}

		db.close();

		return result;
	}
}
