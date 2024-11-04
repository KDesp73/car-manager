package io.github.dmgtechlabs;

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

	public Service(int id, boolean tires, boolean engine, boolean brakes, boolean oil, boolean battery) {
		this.id = id;
		this.tires = tires;
		this.engine = engine;
		this.brakes = brakes;
		this.oil = oil;
		this.battery = battery;
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

	@Override
	public boolean insert() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean update(Object... values) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
