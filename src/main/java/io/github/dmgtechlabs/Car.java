package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

/**
 *
 * @author thanasis
 */
public class Car extends Model implements Dao {

	private int id;
	private String license_plate;
	private float price;
	private Service service;

	public Car(String licence_plate, float price, int modelId) {
		super(modelId);
		this.license_plate = licence_plate;
		this.price = price;
		this.service = null;
	}

	public Car(int id, String licence_plate, float price, Service service, int modelId, String modelName, Type modelType, int modelYear, int modelHp, WheelDrive modelWd, int manufacturerId, String manufacturerName, String manufacturerLocation) {
		super(modelId, modelName, modelType, modelYear, modelHp, modelWd, manufacturerId, manufacturerName, manufacturerLocation);
		this.id = id;
		this.license_plate = licence_plate;
		this.price = price;
		this.service = service;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getLicence_plate() {
		return license_plate;
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
			license_plate, price, super.getId()
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
			this.id
		);
	}
}
