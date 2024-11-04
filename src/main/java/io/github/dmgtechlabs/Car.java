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
		try(PostgresConnection db = Database.connection()) {
			db.callProcedure(Functions.INSERT_CAR, license_plate, price, super.getId());
			SQLogger.getLogger(SQLogger.LogLevel.INFO).logSQL(null, SQLogger.SQLOperation.INSERT, this);
			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO).log("Insert Car failed", ex);
			return false;
		}
	}

	@Override
	public boolean update(Object... values) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean delete() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
