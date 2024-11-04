package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.helpers.SQLogger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
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

	// For adding
	public Manufacturer(String name, String location) {
		this.name = name;
		this.location = location;
	}

	// For loading
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
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.INSERT_MANUFACTURER, name, location);
		db.close();
		
		SQLogger.getLogger().logSQL(null, SQLogger.SQLOperation.INSERT, this);
	}

	@Override
	public void update(Object... values) {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.UPDATE_MANUFACTURER, Utils.appendFront(id, values));
		db.close();
	
		SQLogger.getLogger().logSQL(null, SQLogger.SQLOperation.UPDATE, this);
	}

	@Override
	public void delete() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.DELETE_MANUFACTURER, this.name);
		db.close();
		
		SQLogger.getLogger().logSQL(null, SQLogger.SQLOperation.DELETE, this);
	}

	public static void populate() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.POPULATE_MANUFACTURER);
		db.close();
		
		SQLogger.getLogger().logSQL("Populating Manufacturer", SQLogger.SQLOperation.INSERT, null);
	}

	public static List<Manufacturer> selectAll() {
		
		SQLogger.printSelf();
		PostgresConnection db = Database.connection();

		ResultSet rs = db.callFunction(Functions.SELECT_ALL_MANUFACTURERS);
		List<Manufacturer> result = new ArrayList<>();
		try {
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				Manufacturer m = new Manufacturer(rs.getInt(3), rs.getString(1), rs.getString(2));
				result.add(m);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL("select all manufacturers", SQLogger.SQLOperation.SELECT, null);
		} catch (SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("selectAll failed", ex);
		}

		db.close();

		return result;
	}

	@Override
	public String toString() {
		return "Manufacturer{" + "id=" + id + ", name=" + name + ", location=" + location + '}';
	}

}
