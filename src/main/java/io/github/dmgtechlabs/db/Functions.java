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

	private static String MANUFACTURER_TABLE = "manufacturer";

	public static String INSERT_MANUFACTURER = insert(MANUFACTURER_TABLE);
	public static String UPDATE_MANUFACTURER = update(MANUFACTURER_TABLE);
	public static String DELETE_MANUFACTURER = delete(MANUFACTURER_TABLE);
	public static String POPULATE_MANUFACTURER = Database.SCHEMA + ".populate_manufacturer";
	public static String SELECT_ALL_MANUFACTURERS = Database.SCHEMA + ".select_all_manufacturers";

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
