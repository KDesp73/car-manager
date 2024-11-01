package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Service {

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

	public int getId() {
		return id;
	}

	public boolean isTires() {
		return tires;
	}

	public boolean isEngine() {
		return engine;
	}

	public boolean isBrakes() {
		return brakes;
	}

	public boolean isOil() {
		return oil;
	}

	public boolean isBattery() {
		return battery;
	}

}
