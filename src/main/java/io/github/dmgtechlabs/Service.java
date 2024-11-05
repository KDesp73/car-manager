package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.helpers.SQLogger;

/**
 *
 * @author thanasis
 */
public class Service implements Dao {

	private int id;
	private boolean tires;
	private boolean engine;
	private boolean brakes;
	private boolean oil;
	private boolean battery;
	private String date;

	public Service(int id) {
		this.id = id;
	}
	
	public Service(int id, boolean tires, boolean engine, boolean brakes, boolean oil, boolean battery, String date) {
		this.id = id;
		this.tires = tires;
		this.engine = engine;
		this.brakes = brakes;
		this.oil = oil;
		this.battery = battery;
		this.date = date;
	}

	public boolean tiresChecked() {
		return tires;
	}

	public boolean engineChecked() {
		return engine;
	}

	public boolean brakesChecked() {
		return brakes;
	}

	public boolean oilChecked() {
		return oil;
	}

	public boolean batteryChecked() {
		return battery;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	@Override
	public boolean insert() {
		throw new RuntimeException("Service should not be inserted independently from a Car");
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.UPDATE, 
			Functions.UPDATE_SERVICE, 
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		throw new RuntimeException("Service should not be deleted independently from a Car");
	}

}
