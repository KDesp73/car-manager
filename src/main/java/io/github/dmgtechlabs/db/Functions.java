/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs.db;

/**
 *
 * @author kdesp73
 */
public class Functions {

	private static String CUSTOMER_TABLE = "customer";
	private static String EMPLOYEE_TABLE = "employee";
	private static String PERSON_TABLE = "person";
	private static String MANUFACTURER_TABLE = "manufacturer";
	private static String MODEL_TABLE = "model";
	private static String CAR_TABLE = "car";
	private static String SERVICE_TABLE = "service";
	private static String SALES_TABLE = "sales";

	public static String INSERT_SALE = Database.SCHEMA + ".insert_sale";
	public static String UPDATE_SALE = Database.SCHEMA + ".update_sale";
	public static String DELETE_SALE = Database.SCHEMA + ".delete_sale";
	public static String SELECT_ALL_SALES = Database.SCHEMA + ".select_all_sales";

	public static String UPDATE_SERVICE = update(SERVICE_TABLE);

	public static String INSERT_CUSTOMER = insert(CUSTOMER_TABLE);
	public static String UPDATE_CUSTOMER = update(CUSTOMER_TABLE);
	public static String DELETE_CUSTOMER = delete(CUSTOMER_TABLE);
	public static String SELECT_ALL_CUSTOMERS = Database.SCHEMA + ".select_all_customers";

	public static String INSERT_EMPLOYEE = insert(EMPLOYEE_TABLE);
	public static String UPDATE_EMPLOYEE = update(EMPLOYEE_TABLE);
	public static String DELETE_EMPLOYEE = delete(EMPLOYEE_TABLE);
	public static String SELECT_ALL_EMPLOYEES = Database.SCHEMA + ".select_all_employees";

	public static String INSERT_PERSON = insert(PERSON_TABLE);
	public static String UPDATE_PERSON = update(PERSON_TABLE);
	public static String DELETE_PERSON = delete(PERSON_TABLE);
	public static String SELECT_ALL_PERSONS = Database.SCHEMA + ".select_all_persons";

	public static String INSERT_CAR = insert(CAR_TABLE);
	public static String UPDATE_CAR = update(CAR_TABLE);
	public static String DELETE_CAR = delete(CAR_TABLE);
	public static String SELECT_ALL_CARS = Database.SCHEMA + ".select_all_cars";

	public static String INSERT_MODEL = insert(MODEL_TABLE);
	public static String UPDATE_MODEL = update(MODEL_TABLE);
	public static String DELETE_MODEL = delete(MODEL_TABLE);
	public static String POPULATE_MODEL = Database.SCHEMA + ".populate_model";
	public static String SELECT_ALL_MODELS = Database.SCHEMA + ".select_all_models";

	public static String INSERT_MANUFACTURER = insert(MANUFACTURER_TABLE);
	public static String UPDATE_MANUFACTURER = update(MANUFACTURER_TABLE);
	public static String DELETE_MANUFACTURER = delete(MANUFACTURER_TABLE);
	public static String POPULATE_MANUFACTURER = Database.SCHEMA + ".populate_manufacturer";
	public static String SELECT_ALL_MANUFACTURERS = Database.SCHEMA + ".select_all_manufacturers";
	public static String SELECT_MANUFACTURERS_BY_LOCATION = Database.SCHEMA + ".select_manufacturers_by_location";

	private static String insert(String table) {
		return Database.SCHEMA + ".insert_" + table;
	}

	private static String update(String table) {
		return Database.SCHEMA + ".update_" + table;
	}

	private static String delete(String table) {
		return Database.SCHEMA + ".delete_" + table;
	}

	private static String select(String table) {
		return Database.SCHEMA + ".select_" + table;
	}

}
