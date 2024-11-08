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
public class Car extends Model implements Dao, UIObject {

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

	public Car(
		int carId,
		String licensePlate,
		float price,
		int modelId,
		String modelName,
		Type modelType,
		int modelYear,
		WheelDrive modelWd,
		int modelHp,
		int manufacturerId,
		String manufacturerName,
		String manufacturerLocation,
		Service service
	) {
		super(modelId, modelName, modelType, modelYear, modelWd, modelHp, manufacturerId, manufacturerName, manufacturerLocation);
		this.id = carId;
		this.licensePlate = licensePlate;
		this.price = price;
		this.service = service;
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

	private static List<Car> select(String functionName, Object... params) {
		List<Car> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(functionName, params);
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				result.add(new Car(
					rs.getInt("car_id"),
					rs.getString("car_license_plate"),
					rs.getFloat("car_price"),
					rs.getInt("model_id"),
					rs.getString("model_name"),
					int2Type(rs.getInt("model_type")),
					rs.getInt("model_year"),
					int2WheelDrive(rs.getInt("model_wd")),
					rs.getInt("model_hp"),
					rs.getInt("manufacturer_id"),
					rs.getString("manufacturer_name"),
					rs.getString("manufacturer_location"),
					new Service(
						rs.getInt("service_id"),
						rs.getBoolean("service_tires"),
						rs.getBoolean("service_engine"),
						rs.getBoolean("service_brakes"),
						rs.getBoolean("service_oil"),
						rs.getBoolean("service_battery"),
						(rs.getDate("service_date") == null) ? null : rs.getDate("service_date").toString()
					)
				));
			}
			rs.close();
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log("Select All Cars failed", ex);
		}
		return result;
	}

	public static List<Car> selectAllCars() {
		return select(Functions.SELECT_ALL_CARS + "__");	
	}

	public static List<Car> selectCarsBySold(boolean sold) {
		return select(Database.SCHEMA + ".select_cars_by_sold", sold);
	}
	
	public static List<Car> selectCarsByPriceGreater(float price) {
		return select(Database.SCHEMA + ".select_cars_by_price_greater", price);
	}
	
	public static List<Car> selectCarsByPriceLess(float price) {
		return select(Database.SCHEMA + ".select_cars_by_price_less", price);
	}

	public static List<Car> selectCarsByPrice(float price) {
		return select(Database.SCHEMA + ".select_cars_by_price", price);
	}
	
	@Override
	public String UIString() {
		return this.licensePlate + " - " + this.price + "$ " + this.getManufacturerName() + " " + this.getName();
	}

	@Override
	public String toHTML() {
		Model model = (Model) this;
		Manufacturer manufacturer = (Manufacturer) model;

		StringBuilder sb = new StringBuilder();
		sb.append(Utils.HTML.header(1, this.licensePlate));
		sb.append(Utils.HTML.header(3, "Price: " + this.price + "$"));

		sb.append(Utils.HTML.header(3, "Model"));
		sb.append(Utils.HTML.ul(
			"Name: " + manufacturer.getManufacturerName() + " " + model.getName(),
			"Type: " + model.getType(),
			"Hp: " + model.getHp(),
			"WD: " + model.getWd().toString().substring(1),
			"Year: " + model.getYear()
		));
		sb.append(Utils.HTML.header(3, "Service"));
		sb.append(Utils.HTML.ul(
			"Date: " + ((this.service.done()) ? this.service.getDate() : ""),
			"Engine: " + this.service.engineChecked(),
			"Oil: " + this.service.oilChecked(),
			"Battery: " + this.service.batteryChecked(),
			"Brakes: " + this.service.brakesChecked(),
			"Tires: " + this.service.tiresChecked()
		));

		return sb.toString();
	}
	
	/**
	 * new String[]{"License Plate", "Price", "Model", "Type", "WD", "Hp"}
	 * @return 
	 */
	@Override
	public Object[] objArray() {
		return new Object[]{
			this.licensePlate,
			this.price,
			this.getManufacturerName() + " " + this.getName(),
			this.getType(),
			this.getWd().toString().substring(1),
			this.getHp()
		};
	}
}
