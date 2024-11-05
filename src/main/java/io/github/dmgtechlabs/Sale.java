package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private int carId;
	private int employeeId;
	private int customerId;
 	private float discount;
	private float finalPrice;
	private String date;

	public Sale(){}
	
	public Sale(int id, float price, float discount, int carId, int employeeId, int customerId, String date) {
		this.id = id;
		this.finalPrice = price;
		this.discount = discount;
		this.carId = carId;
		this.employeeId = employeeId;
		this.customerId = customerId;
		this.date = date;
	}
	
	public Sale(float finalPrice, float discount, int carId, int employeeId, int customerId){
		this.finalPrice = finalPrice;
		this.discount = discount;
		this.carId = carId;
		this.employeeId = employeeId;
		this.customerId = customerId;
	}
	
	public int getId() {
		return id;
	}

	public int getCarId() {
		return carId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public int getCustomerId() {
		return customerId;
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
			this.finalPrice, this.discount, this.carId, this.employeeId, this.customerId
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
	
	public List<Sale> selectAll() {
		List<Sale> result = new ArrayList<>();
		try(PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Functions.SELECT_ALL_SALES);
			if(rs.isClosed()) return null;
			
			while(rs.next()) {
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
		} catch(RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log("Sales select all failed", ex);
		}
		
		return result;
	}

}
