package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Manufacturer {

	private int id;
	private String name;
	private String location;

	public Manufacturer() {
	}

	public Manufacturer(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

}
