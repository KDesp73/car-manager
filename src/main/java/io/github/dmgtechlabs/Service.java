package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Service {

	private boolean tires;
	private boolean engine;
	private boolean brakes;
	private boolean oil;
	private boolean battery;

	public Service(boolean tires, boolean engine, boolean brakes, boolean oil, boolean battery) {
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

}
