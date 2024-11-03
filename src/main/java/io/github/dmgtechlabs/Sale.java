package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Sale implements Dao {

	private int id;
	private Employee salesman;
	private Customer customer;
	private Car car;
	private float discount;
	private float finalPrice;

	public Sale(int id, Employee salesman, Customer customer, Car car, float discount) {
		this.id = id;
		this.salesman = salesman;
		this.customer = customer;
		this.car = car;
		this.discount = discount;

		this.calculateFinalPrice();
	}

	public int getId() {
		return id;
	}

	public Employee getSalesman() {
		return salesman;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public float getDiscount() {
		return discount;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void calculateFinalPrice() {
		this.finalPrice = car.getPrice() - car.getPrice() * this.discount;
	}

	@Override
	public void insert() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update(Object... values) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
