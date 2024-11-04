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

	private Person p;
	private String uuid;
	private int id;

	public Customer(int customerId, String uuid, Person p) {
		super(p.getId(), p.getFname(), p.getLname(), p.getEmail(), p.getBirthYear(), p.getGender());
		this.p = p;
		this.id = customerId;
		this.uuid = uuid;
		// TODO: generate uuid
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

	public int getPersonId() {
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
			uuid, id
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

//	public static List<Customer> selectAll(){
//		PostgresConnection db = Database.connection();
//
//		ResultSet rs = db.callFunction(Functions.SELECT_ALL_CUSTOMERS);
//
//		List<Customer> result = new ArrayList<>();
//		try {
//			if (rs.isClosed()) {
//				return null;
//			}
//
//			while (rs.next()) {
//				Customer c = new Customer(rs.getString("id"), rs.getString(""));
//			}
//
//		} catch (SQLException ex) {
//
//		}
//	}

}
