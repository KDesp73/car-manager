package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

/**
 *
 * @author kdesp73
 */
public class Sale implements Dao {

	private int id;
	private Car car;
	private Employee employee;
	private Customer customer;
	private float discount;
	private float finalPrice;
	private String date;

	public Sale() {
	}

	public Sale(int id, float price, float discount, int carId, int employeeId, int customerId, String date) {
		this.id = id;
		this.finalPrice = price;
		this.discount = discount;
		this.car = new Car(carId);
		this.employee = new Employee(employeeId);
		this.customer = new Customer(customerId);
		this.date = date;
	}

	public Sale(int id, float price, float discount, Car car, Employee employee, Customer customer, String date) {
		this.id = id;
		this.finalPrice = price;
		this.discount = discount;
		this.car = car;
		this.employee = employee;
		this.customer = customer;
		this.date = date;
	}

	public Sale(float finalPrice, float discount, int carId, int employeeId, int customerId) {
		this.finalPrice = finalPrice;
		this.discount = discount;
		this.car = new Car(carId);
		this.employee = new Employee(employeeId);
		this.customer = new Customer(customerId);
	}

	public int getId() {
		return id;
	}

	public Car getCar() {
		return car;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getDate() {
		return date;
	}

	public float getDiscount() {
		return discount;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.INSERT,
			Functions.INSERT_SALE,
			this.finalPrice, this.discount, this.car.getId(), this.employee.getId(), this.customer.getId()
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.UPDATE,
			Functions.UPDATE_SALE,
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this,
			SQLogger.SQLOperation.DELETE,
			Functions.DELETE_SALE,
			id
		);
	}

	public static List<Sale> selectAll() {
		List<Sale> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Functions.SELECT_ALL_SALES);
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				result.add(new Sale(
					rs.getInt("id"),
					rs.getFloat("price"),
					rs.getFloat("discount"),
					rs.getInt("sales_car_fk"),
					rs.getInt("sales_employee_fk"),
					rs.getInt("sales_customer_fk"),
					rs.getDate("date").toString())
				);
			}
			rs.close();
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).logSQL("Select All Sales", SQLogger.SQLOperation.SELECT, null);
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Sales select all failed", ex);
		}

		return result;
	}

	public static Sale select(int id) {
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Database.SCHEMA + ".select_sale", id);
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				return new Sale(
					rs.getInt("sale_id"),
					rs.getFloat("sale_price"),
					rs.getFloat("sale_discount"),
					new Car(
						rs.getInt("car_id"),
						rs.getString("car_license_plate"),
						rs.getFloat("car_price"),
						rs.getString("car_model_name"),
						rs.getInt("car_model_year"),
						rs.getString("car_manufacturer_name")
					),
					new Employee(
						rs.getInt("employee_id"),
						rs.getString("employee_name"),
						rs.getString("employee_email")
					),
					new Customer(
						rs.getInt("customer_id"),
						rs.getString("customer_name"),
						rs.getString("customer_email")
					),
					rs.getDate("sale_date").toString()
				);
			}
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log("Select Sale by id failed", ex);
		}
		return null;
	}

}
