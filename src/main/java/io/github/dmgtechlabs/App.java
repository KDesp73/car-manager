package io.github.dmgtechlabs;

import io.github.dmgtechlabs.gui.MainFrame;
import javax.swing.UIManager;
import io.github.dmgtechlabs.Manufacturer;
import io.github.dmgtechlabs.db.Database;
import kdesp73.databridge.connections.DatabaseConnection;

public class App {

	private static void manufacturersInsertStatements() {
		new Manufacturer("Ford", "USA").insert();
		new Manufacturer("Toyota", "Japan").insert();
		new Manufacturer("Volkswagen", "Germany").insert();
		new Manufacturer("Hyundai", "South Korea").insert();
		new Manufacturer("BMW", "Germany").insert();
		new Manufacturer("Honda", "Japan").insert();
		new Manufacturer("Nissan", "Japan").insert();
		new Manufacturer("Chevrolet", "USA").insert();
		new Manufacturer("Mercedes-Benz", "Germany").insert();
		new Manufacturer("Audi", "Germany").insert();
		new Manufacturer("Kia", "South Korea").insert();
		new Manufacturer("Renault", "France").insert();
		new Manufacturer("Peugeot", "France").insert();
		new Manufacturer("Fiat", "Italy").insert();
		new Manufacturer("Porsche", "Germany").insert();
		new Manufacturer("Jeep", "USA").insert();
		new Manufacturer("Mazda", "Japan").insert();
		new Manufacturer("Subaru", "Japan").insert();
		new Manufacturer("Land Rover", "UK").insert();
		new Manufacturer("Jaguar", "UK").insert();
		new Manufacturer("Volvo", "Sweden").insert();
		new Manufacturer("Tesla", "USA").insert();
		new Manufacturer("Ferrari", "Italy").insert();
		new Manufacturer("Lamborghini", "Italy").insert();
		new Manufacturer("Maserati", "Italy").insert();
		new Manufacturer("Bentley", "UK").insert();
		new Manufacturer("Rolls-Royce", "UK").insert();
		new Manufacturer("Saab", "Sweden").insert();
		new Manufacturer("Opel", "Germany").insert();
		new Manufacturer("Citroën", "France").insert();
		new Manufacturer("Alfa Romeo", "Italy").insert();
		new Manufacturer("Dacia", "Romania").insert();
		new Manufacturer("Tata Motors", "India").insert();
		new Manufacturer("Mahindra", "India").insert();
		new Manufacturer("Chery", "China").insert();
		new Manufacturer("Geely", "China").insert();
		new Manufacturer("BYD", "China").insert();
		new Manufacturer("Holden", "Australia").insert();
		new Manufacturer("Seat", "Spain").insert();

	}

	private static void runGUI() {
		System.setProperty("sun.java2d.uiScale", "1");
		try {
			UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		App.manufacturersInsertStatements();
		Manufacturer.populate();
//		runGUI();
	}

}
