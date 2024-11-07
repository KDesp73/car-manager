/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs;

import io.github.dmgtechlabs.Person.Gender;
import static io.github.dmgtechlabs.Person.int2Gender;
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
public class EmployeeLog {

	public String operation;
	public String timestamp;
	public String fname;
	public String lname;
	public String email;
	public float salary;

	public EmployeeLog(String operation, String timestamp, String fname, String lname, String email, float salary) {
		this.operation = operation;
		this.timestamp = timestamp;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.salary = salary;
	}

	public static Object[][] listToArray(List<EmployeeLog> list) {
		if (list == null || list.isEmpty()) {
			return new Object[0][0];
		}
		Object[][] array = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			EmployeeLog employeeLog = list.get(i);
			array[i][0] = employeeLog.operation;
			array[i][1] = employeeLog.timestamp;
			array[i][2] = employeeLog.fname;
			array[i][3] = employeeLog.lname;
			array[i][4] = employeeLog.email;
			array[i][5] = employeeLog.salary;
		}

		return array;
	}

	public static List<EmployeeLog> selectAll() {
		List<EmployeeLog> result = new ArrayList<>();
		try (PostgresConnection db = Database.connection()) {
			ResultSet rs = db.callFunction(Database.SCHEMA + ".select_all_employee_logs");
			if (rs.isClosed()) {
				return null;
			}

			while (rs.next()) {
				result.add(new EmployeeLog(
					rs.getString("operation"),
					rs.getTimestamp("timestamp").toString(),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getString("email"),
					rs.getFloat("salary")
				));
			}

			rs.close();
		} catch (RuntimeException | SQLException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ALL, SQLogger.LogType.ALL).log("Employee selectAll failed", ex);
		}
		return result;
	}
	
	public static void writeToFile(List<EmployeeLog> employeeLogs, String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// Write the header
			writer.write("Operation,Timestamp,First Name,Last Name,Email,Gender,Salary");
			writer.newLine();

			// Write each CarLog entry
			for (EmployeeLog log : employeeLogs) {
				writer.write(String.format("%s,%s,%s,%s,%s,%.2f",
					log.operation,
					log.timestamp,
					log.fname,
					log.lname,
					log.email,
					log.salary
				));
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace(); // Handle exceptions properly in real applications
		}
	}
}
