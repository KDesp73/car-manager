
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs;

import io.github.dmgtechlabs.db.Database;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class CarLog {

	public String operation;
	public String timestamp;
	public String license_plate;
	public float price;
	public String model;
	public String manufacturer;

	public CarLog(
		String operation,
		String timestamp,
		String license_plate,
		float price,
		String model,
		String manufacturer
	) {
		this.operation = operation;
		this.timestamp = timestamp;
		this.license_plate = license_plate;
		this.price = price;
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public static Object[][] tableData(List<CarLog> list) {
		if (list == null || list.isEmpty()) {
			return new Object[0][0];
		}

		Object[][] array = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			CarLog carLog = list.get(i);
			array[i][0] = carLog.operation;
			array[i][1] = carLog.timestamp;
			array[i][2] = carLog.license_plate;
			array[i][3] = carLog.price;
			array[i][4] = carLog.model;
			array[i][5] = carLog.manufacturer;
		}

		return array;
	}

	public static List<CarLog> selectAll() {
		List<CarLog> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Database.SCHEMA + ".select_all_car_logs");
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				result.add(new CarLog(
					rs.getString("operation"),
					rs.getTimestamp("timestamp").toString(),
					rs.getString("license_plate"),
					rs.getFloat("price"),
					rs.getString("model"),
					rs.getString("manufacturer")
				));
			}

			rs.close();
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log("CarLog selectAll failed", ex);
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[").append(operation);
		sb.append(" ").append(timestamp).append("] ");
		sb.append("Car { license_plate=").append(license_plate);
		sb.append(", price=").append(price);
		sb.append(", model=").append(model);
		sb.append(", manufacturer=").append(manufacturer);
		sb.append('}');
		return sb.toString();
	}

	public static void writeToFile(List<CarLog> carLogs, String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// Write the header
			writer.write("Operation,Timestamp,License Plate,Price,Model,Manufacturer");
			writer.newLine();

			// Write each CarLog entry
			for (CarLog log : carLogs) {
				writer.write(String.format("%s,%s,%s,%.2f,%s,%s",
					log.operation,
					log.timestamp,
					log.license_plate,
					log.price,
					log.model,
					log.manufacturer));
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace(); // Handle exceptions properly in real applications
		}
	}

}
