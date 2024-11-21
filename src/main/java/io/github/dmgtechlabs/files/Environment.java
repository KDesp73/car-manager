package io.github.dmgtechlabs.files;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {
	private static String DBLABS_USERNAME;
	private static String DBLABS_PASSWORD;
	
	public static void load(){
		Dotenv dotenv = Dotenv.load();

		DBLABS_USERNAME = dotenv.get("DBLABS_USERNAME");
		DBLABS_PASSWORD = dotenv.get("DBLABS_PASSWORD");
	}
	
	public static String getDblabsUsername() {
		load();
		return DBLABS_USERNAME;
	}
	
	public static String getDblabsPassword() {
		load();
		return DBLABS_PASSWORD;
	}
}
