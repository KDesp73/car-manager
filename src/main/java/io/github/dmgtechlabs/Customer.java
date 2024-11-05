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

	public Customer(int id, String uuid, int personId, String fname, String lname, String email, int birthYear, Gender gender) {
		super(personId, fname, lname, email, birthYear, gender);
		this.id = id;
		this.uuid = uuid;
		// TODO: generate uuid
	}
	
	public Customer(String uuid, int id, int personId) {
		super(personId);
		this.uuid = uuid;
		this.id = id;
	}

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

	public static List<Customer> selectAll() {
		PostgresConnection db = Database.connection();

		ResultSet rs = db.callFunction(Functions.SELECT_ALL_CUSTOMERS);

		List<Customer> result = new ArrayList<>();
		try {
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Customer c = new Customer(rs.getString(2), rs.getInt(1), rs.getInt(3));
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
