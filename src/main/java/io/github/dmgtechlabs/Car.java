package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Car implements Dao {

	public static enum Type {
		SUV,
		Sedan,
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

	private String model;
	private Type type;
	private int year;
	private float price;
	private int hp;
	private String licence_plate;
	private WheelDrive wd;
	private Manufacturer manufacturer;
	private Service service;

	public Car(String model, Type type, int year, float price, int hp, String licence_plate, WheelDrive wd, Manufacturer manufacturer, Service service) {
		this.model = model;
		this.type = type;
		this.year = year;
		this.price = price;
		this.hp = hp;
		this.licence_plate = licence_plate;
		this.wd = wd;
		this.manufacturer = manufacturer;
		this.service = service;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getHp() {
		return hp;
	}

	public String getLicence_plate() {
		return licence_plate;
	}

	public WheelDrive getWd() {
		return wd;
	}

	public Manufacturer getM_id() {
		return manufacturer;
	}

	public Service getS_id() {
		return service;
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
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String[] columns() {
		return new String[]{"model", "type", "year", "price", "hp", "license_plate", "wd"};
	}
}
