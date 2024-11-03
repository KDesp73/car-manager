package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import java.sql.CallableStatement;
import java.sql.SQLException;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanasis
 */
public class Manufacturer implements Dao {

	private int id;
	private String name;
	private String location;

	public Manufacturer() {
	}

	public Manufacturer(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	@Override
	public void insert() {
		PostgresConnection db = (PostgresConnection) Database.connection();

		db.callProcedure(Functions.insert("manufacturer"), Database.quote(name), Database.quote(location));

		db.close();
	}

	@Override
	public void update() {
		PostgresConnection db = (PostgresConnection) Database.connection();

		db.callProcedure(Functions.update("manufacturer"), Database.quote(name), Database.quote(location));

		db.close();
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public static void populate() {
		PostgresConnection db = (PostgresConnection) Database.connection();

		db.callProcedure(Functions.POPULATE_MANUFACTURER);

		db.close();
	}

}
