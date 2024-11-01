package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Sale implements Dao {

	private Employee salesman;
	private Customer customer;
	private Car car;
	private float discount;
	private float finalPrice;

	public Sale(Employee salesman, Customer customer, Car car, float discount) {
		this.salesman = salesman;
		this.customer = customer;
		this.car = car;
		this.discount = discount;

		this.calculateFinalPrice();
	}

	public void calculateFinalPrice() {
		this.finalPrice = car.getPrice() - car.getPrice() * this.discount;
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
		return new String[]{"discount"};
	}
}
