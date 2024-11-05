package io.github.dmgtechlabs.db;

import io.github.dmgtechlabs.files.Environment;
import java.util.function.BiFunction;
import java.util.function.Function;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.connections.PostgresConnection;
import kdesp73.databridge.helpers.SQLogger;

public class Database {

	private static final String URL = "dblabs.iee.ihu.gr:5432/iee2021035";
	private static String username = Environment.getDblabsUsername();
	private static String password = Environment.getDblabsPassword();
	private static DatabaseConnection instance;
	public static String SCHEMA = "\"CarManager_DB\"";

	private Database() {
		// Private constructor to prevent external instantiation
	}

	public static PostgresConnection connection() {
		synchronized (DatabaseConnection.class) {
			try {
				String url = "jdbc:postgresql://" + URL;

				instance = new PostgresConnection();
				instance.connect(url, username, password);
				instance.execute("SET search_path TO " + SCHEMA + ";"); // Specify the schema
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to create the database connection.");
			}
		}
		return (PostgresConnection) instance;
	}

	public static boolean DaoFunctionWrapper(Object instance, SQLogger.SQLOperation operation, String procedureName, Object... params) {
		try (PostgresConnection db = Database.connection()) {
			// Call the provided function
			db.callProcedure(procedureName, params);

			// Logging
			SQLogger.getLogger(SQLogger.LogLevel.INFO, SQLogger.LogType.ALL)
				.logSQL("Called " + procedureName, operation, instance);

			return true;
		} catch (RuntimeException ex) {
			SQLogger.getLogger(SQLogger.LogLevel.ERRO, SQLogger.LogType.STDERR).log(operation + " failed for " + instance.toString(), ex);
			return false;
		}
	}
}
