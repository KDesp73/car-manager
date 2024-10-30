package io.github.dmgtechlabs.db;

import io.github.dmgtechlabs.files.Environment;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.connections.PostgresConnection;

public class Database {

	private static final String URL = "dblabs.iee.ihu.gr:5432/CarManager-DB";
	private static String username = Environment.getDblabsUsername();
	private static String password = Environment.getDblabsPassword();
	private static DatabaseConnection instance;

	private Database() {
		// Private constructor to prevent external instantiation
	}

	public static DatabaseConnection connection() {
		synchronized (DatabaseConnection.class) {
			try {
				String url = "jdbc:postgresql://" + URL;

				instance = new PostgresConnection();
				instance.connect(url, username, password);
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to create the database connection.");
			}
		}
		return instance;
	}

}
