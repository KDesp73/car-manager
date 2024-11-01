package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Car {

	private String model;
	private int type;
	private int year;
	private float price;
	private int hp;
	private String licence_plate;
	private int wd;
	private Manufacturer manufacturer;
	private Service service;

	public Car(String model, int type, int year, float price, int hp, String licence_plate, int wd, Manufacturer manufacturer, Service service) {
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

	public int getType() {
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

	public int getWd() {
		return wd;
	}

	public Manufacturer getM_id() {
		return manufacturer;
	}

	public Service getS_id() {
		return service;
	}

}
