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

	public static String INSERT_MANUFACTURER = Database.SCHEMA + ".insert_manufacturer";
	public static String UPDATE_MANUFACTURER = Database.SCHEMA + ".update_manufacturer";
	public static String POPULATE_MANUFACTURER = Database.SCHEMA + ".populate_manufacturer";

	public static String insert(String table) {
		return Database.SCHEMA + ".insert_" + table;
	}

	public static String update(String table) {
		return Database.SCHEMA + ".update_" + table;
	}

	public static String delete(String table) {
		return Database.SCHEMA + ".delete_" + table;
	}

}
