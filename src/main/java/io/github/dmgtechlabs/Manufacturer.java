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
public class Manufacturer implements Dao, UIObject {

	private int id;
	private String name;
	private String location;

	public Manufacturer() {
	}

	public Manufacturer(int id) {
		this.id = id;
	}


	public Manufacturer(String name) {
		this.name = name;
	}

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

	public String getManufacturerName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.INSERT,
			Functions.INSERT_MANUFACTURER,
			name, location
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.UPDATE,
			Functions.UPDATE_MANUFACTURER,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.DELETE,
			Functions.DELETE_MANUFACTURER,
			name
		);
	}

	public static void populate() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.POPULATE_MANUFACTURER);
		db.close();

		SQLogger.getLogger().logSQL("Populating Manufacturer", SQLogger.SQLOperation.INSERT, null);
	}

	private static List<Manufacturer> select(String functionName, Object... params) {
		List<Manufacturer> result = new ArrayList<>();
		try(PostgresConnection db = Database.connection()){
			ResultSet rs = db.callFunction(functionName, params);
			if(rs.isClosed()) return null;

			while(rs.next()){
				result.add(new Manufacturer(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL).logSQL(functionName + " run successfully", SQLogger.SQLOperation.SELECT, null);
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log(functionName + " failed", ex);
		}
		return result;
	}

	public static List<Manufacturer> selectByLocation(String location) {
		return select(Functions.SELECT_MANUFACTURERS_BY_LOCATION, location);
	}

	public static List<Manufacturer> selectAllManufacturers() {
		return select(Functions.SELECT_ALL_MANUFACTURERS);
	}

	@Override
	public String toString() {
		return "Manufacturer{" + "id=" + id + ", name=" + name + ", location=" + location + '}';
	}

	@Override
	public String UIString() {
		return this.name;
	}

	@Override
	public String toHTML() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	/**
	 * new String[]{"Name", "Location"}
	 *
	 * @return
	 */
	@Override
	public Object[] objArray() {
		return new Object[]{
			this.name,
			this.location
		};
	}

}
