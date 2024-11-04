/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

/**
 *
 * @author kdesp73
 */
public class Model extends Manufacturer implements Dao {

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

	public Model(String name, Type type, int year, int hp, WheelDrive wd, String manufacturerName, String manufacturerLocation) {
		super(manufacturerName, manufacturerLocation);
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

	@Override
	public int getId() {
		return id;
	}

	@Override
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
	public void insert() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.INSERT_MODEL, name, type.ordinal(), year, hp, wd.ordinal(), super.getId());
		db.close();
		
		SQLogger.getLogger(SQLogger.LogLevel.INFO).logSQL(null, SQLogger.SQLOperation.INSERT, this);
	}

	@Override
	public void update(Object... values) {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.UPDATE_MODEL, Utils.appendFront(id, values));
		db.close();
		
		SQLogger.getLogger(SQLogger.LogLevel.INFO).logSQL(null, SQLogger.SQLOperation.UPDATE, this);
	}

	@Override
	public void delete() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.DELETE_MODEL, this.id);
		db.close();
		
		SQLogger.getLogger(SQLogger.LogLevel.INFO).logSQL(null, SQLogger.SQLOperation.DELETE, this);
	}
}
