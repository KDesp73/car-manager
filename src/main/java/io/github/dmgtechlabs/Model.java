/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Model extends Manufacturer implements Dao, UIObject {

	public static enum Type {
		Sedan,
		SUV,
		Hatchback,
		Truck,
		Minivan,
		Luxury,
		Sports,
		Hybrid,
		Electric,
		Compact
	}

	public static enum WheelDrive {
		_2WD,
		_4WD,
		_6WD,
		_8WD,
		_AWD
	}

	private int id;
	private String name;
	private Type type;
	private int year;
	private int hp;
	private WheelDrive wd;

	public Model() {}

	public Model(int id) {
		this.id = id;
	}

	public Model(String name, Type type, int year, int hp, WheelDrive wd, int manufacturerId) {
		super(manufacturerId);
		this.name = name;
		this.type = type;
		this.year = year;
		this.hp = hp;
		this.wd = wd;
	}

	public Model(int id, String name, Type type, int year, int hp, WheelDrive wd, String manufacturerName) {
		super(manufacturerName);
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.hp = hp;
		this.wd = wd;
	}

	public Model(String name, Type type, int year, int hp, WheelDrive wd, String manufacturerName) {
		super(manufacturerName);
		this.name = name;
		this.type = type;
		this.year = year;
		this.hp = hp;
		this.wd = wd;
	}

	public Model(String name, int year, int hp, String manufacturerName, String manufacturerLocation) {
		super(manufacturerName, manufacturerLocation);
		this.name = name;
		this.type = Type.Sedan;
		this.year = year;
		this.hp = hp;
		this.wd = WheelDrive._2WD;
	}

	public Model(String name, int year, String manufacturerName) {
		super(manufacturerName);
		this.name = name;
		this.year = year;
	}

	public Model(int id, String name, Type type, int year, int hp, WheelDrive wd, int manufacturerId, String manufacturerName, String manufacturerLocation) {
		super(manufacturerId, manufacturerName, manufacturerLocation);
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.hp = hp;
		this.wd = wd;
	}

	public Model(int id, String name, int year, int hp, int manufacturerId, String manufacturerName, String manufacturerLocation) {
		super(manufacturerId, manufacturerName, manufacturerLocation);
		this.id = id;
		this.name = name;
		this.type = Type.Sedan;
		this.year = year;
		this.hp = hp;
		this.wd = WheelDrive._2WD;
	}

	public Model(int modelId, String modelName, Type modelType, int modelYear, WheelDrive modelWd, int modelHp, int manufacturerId, String manufacturerName, String manufacturerLocation) {
		super(manufacturerId, manufacturerName, manufacturerLocation);
		this.id = modelId;
		this.name = modelName;
		this.type = modelType;
		this.year = modelYear;
		this.wd = modelWd;
		this.hp = modelHp;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public int getYear() {
		return year;
	}

	public int getHp() {
		return hp;
	}

	public WheelDrive getWd() {
		return wd;
	}

	public static Type int2Type(int type) {
		for (Type t : Type.values()) {
			if (type == t.ordinal()) {
				return t;
			}
		}
		return null;
	}

	public static WheelDrive int2WheelDrive(int wheelDrive) {
		for (WheelDrive wd : WheelDrive.values()) {
			if (wheelDrive == wd.ordinal()) {
				return wd;
			}
		}
		return null;
	}

	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.INSERT,
			Functions.INSERT_MODEL,
			name, type.ordinal(), year, hp, wd.ordinal(), super.getId()
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.UPDATE,
			Functions.UPDATE_MODEL,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.DELETE,
			Functions.DELETE_MODEL,
			this.id
		);
	}

	public static void populate() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Database.SCHEMA + ".populate_model");
		db.close();

		SQLogger.getLogger().logSQL("Populating Model", SQLogger.SQLOperation.INSERT, null);
	}

	private static List<Model> select(String functionName, Object... params) {
		List<Model> result = new ArrayList<>();
		try(PostgresConnection db = Database.connection()){
			ResultSet rs = db.callFunction(functionName, params);
			if(rs.isClosed()) return null;

			while(rs.next()) {
				result.add(new Model(
					rs.getInt("model_id"),
					rs.getString("model_name"),
					int2Type(rs.getInt("model_type")),
					rs.getInt("model_year"),
					rs.getInt("model_hp"),
					int2WheelDrive(rs.getInt("model_wd")),
					rs.getString("man_name")
				));
			}
			rs.close();

		} catch(RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log(functionName + " failed", ex);
		}
		return result;
	}

	public static List<Model> selectAllModels() {
		return select(Functions.SELECT_ALL_MODELS);
	}

	public static List<Model> selectByManufacturer(String man) {
		return select(Database.SCHEMA + ".select_models_by_manufacturer", man);
	}

	@Override
	public String toString() {
		return "Model{" + "id=" + id + ", name=" + name + ", type=" + type + ", year=" + year + ", hp=" + hp + ", wd=" + wd + '}' + super.toString();
	}

	@Override
	public String UIString(){
		return this.name + " " + this.year + " (" + this.type + " " + this.hp + "hp)";
	}

	/**
	 * new String[]{"Name", "Type", "Year", "WD", "Hp"}
	 *
	 * @return
	 */
	@Override
	public Object[] objArray() {
		return new Object[]{
			this.name,
			this.type,
			this.year,
			this.wd.toString().substring(1),
			this.hp
		};
	}
}
