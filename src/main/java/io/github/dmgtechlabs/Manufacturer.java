package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;

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
		DatabaseConnection db = Database.connection();
		String query = new QueryBuilder().insertInto("Manufacturer").columns("name", "location").values(this.name, this.location).build();
		System.out.println(query);
		db.executeUpdate(query);
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

}
