package io.github.dmgtechlabs;

/**
 *
 * @author thanasis
 */
public class Manufacturer {

	private String name;
	private String location;

	public Manufacturer() {
	}

	public Manufacturer(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

}
