package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Car {

	private int id;
	private String model;
	private int type;
	private int year;
	private float price;
	private int hp;
	private String licence_plate;
	private int wd;
	private Manufacturer m_id;
	private Service s_id;

	public Car(int id, String model, int type, int year, float price, int hp, String licence_plate, int wd, Manufacturer m_id, Service s_id) {
		this.id = id;
		this.model = model;
		this.type = type;
		this.year = year;
		this.price = price;
		this.hp = hp;
		this.licence_plate = licence_plate;
		this.wd = wd;
		this.m_id = m_id;
		this.s_id = s_id;
	}

	public int getId() {
		return id;
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
		return m_id;
	}

	public Service getS_id() {
		return s_id;
	}

}
