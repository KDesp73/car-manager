package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kdesp73.databridge.connections.PostgresConnection;

/**
 *
 * @author kdesp73
 */
public class Customer extends Person implements Dao {

	private String uuid;
	private int id;

	public Customer(int customerId, String email, int id, String fname, String lname, int birthYear, Gender gender) {
		super(id, fname, lname, email, birthYear, gender);
		this.id = customerId;
		// TODO: generate uuid
	}

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
	public void insert() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.INSERT_CUSTOMER, uuid, id);
		db.close();
	}

	@Override
	public void update(Object... values) {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.UPDATE_CUSTOMER, Utils.appendFront(id, values));
		db.close();
	}

	@Override
	public void delete() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.DELETE_CUSTOMER, this.id);
		db.close();
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
