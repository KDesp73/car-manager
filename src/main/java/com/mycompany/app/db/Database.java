package com.mycompany.app.db;

import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.connections.PostgresConnection;

public class Database {

    private static final String URL = "";
    private static String username = "";
    private static String password = "";
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
