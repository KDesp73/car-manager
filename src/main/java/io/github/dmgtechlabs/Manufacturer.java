package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
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

	private String name;
	private String location;

	public Manufacturer() {
	}

	public Manufacturer(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public void insert() {
		PostgresConnection db = (PostgresConnection) Database.connection();

		db.callProcedure(Database.SCHEMA + ".insert_manufacturer", Database.quote(name), Database.quote(location));

		db.close();
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public static void populate() {
		PostgresConnection db = (PostgresConnection) Database.connection();

		db.callProcedure(Database.SCHEMA + ".populate_manufacturer");

		db.close();
	}

}
