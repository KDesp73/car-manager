package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import io.github.dmgtechlabs.db.Functions;
import kdesp73.databridge.connections.PostgresConnection;

/**
 *
 * @author thanasis
 */
public class Car extends Model implements Dao {

	private int id;
	private String licence_plate;
	private float price;
	private Service service;

	public Car(String licence_plate, float price, Service service, String modelName, Type modelType, int modelYear, int modelHp, WheelDrive modelWd, String manufacturerName, String manufacturerLocation) {
		super(modelName, modelType, modelYear, modelHp, modelWd, manufacturerName, manufacturerLocation);
		this.licence_plate = licence_plate;
		this.price = price;
		this.service = service;
	}

	public Car(int id, String licence_plate, float price, Service service, int modelId, String modelName, Type modelType, int modelYear, int modelHp, WheelDrive modelWd, int manufacturerId, String manufacturerName, String manufacturerLocation) {
		super(modelId, modelName, modelType, modelYear, modelHp, modelWd, manufacturerId, manufacturerName, manufacturerLocation);
		this.id = id;
		this.licence_plate = licence_plate;
		this.price = price;
		this.service = service;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getLicence_plate() {
		return licence_plate;
	}

	public float getPrice() {
		return price;
	}

	public Service getService() {
		return service;
	}
	
	@Override
	public void insert() {
		PostgresConnection db = Database.connection();
		db.callProcedure(Functions.INSERT_CAR, null);
		db.close();
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
