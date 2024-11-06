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
 * @author thanasis
 */
public class Car extends Model implements Dao {

	private int id;
	private String licensePlate;
	private float price;
	private Service service;

	public Car(String licencePlate, float price, int modelId) {
		super(modelId);
		this.licensePlate = licencePlate;
		this.price = price;
		this.service = null;
	}

	public Car(int id) {
		this.id = id;
	}
	
	
	public Car(int id, String licensePlate, float price, int modelId, int serviceId) {
		super(modelId);
		this.licensePlate = licensePlate;
		this.price = price;
		this.id = id;
		this.service = new Service(serviceId);
	}
	
	public Car(
		int id,
		String licensePlate,
		float price,
		String modelName,
		int modelYear,
		String manufacturerName
	) {
		super(modelName, modelYear, manufacturerName);
		this.id = id;
		this.licensePlate = licensePlate;
		this.price = price;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getLicencePlate() {
		return licensePlate;
	}

	public float getPrice() {
		return price;
	}

	public Service getService() {
		return service;
	}

	@Override
	public boolean insert() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.INSERT, 
			Functions.INSERT_CAR, 
			licensePlate, price, super.getId()
		);
	}

	@Override
	public boolean update(Object... values) {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.UPDATE, 
			Functions.UPDATE_CAR, 
			Utils.appendFront(id, values)
		);
	}

	@Override
	public boolean delete() {
		return Database.DaoFunctionWrapper(
			this, 
			SQLogger.SQLOperation.DELETE, 
			Functions.DELETE_CAR,
			this.licensePlate
		);
	}
	
	public static List<Car> selectAllCars() {
		List<Car> result = new ArrayList<>();
		try(PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Functions.SELECT_ALL_CARS);
			if(rs.isClosed()) return null;
			
			while(rs.next()) {
				result.add(new Car(
					rs.getInt("id"),
					rs.getString("license_plate"),
					rs.getFloat("price"),
					rs.getInt("car_model_fk"),
					rs.getInt("car_service_fk")
				));
			}
			rs.close();
		} catch(RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log("Select All Cars failed", ex);
		}
		return result;
	}
	
	public String UIString() {
		return this.licensePlate + " - " + this.price;
	}
}
