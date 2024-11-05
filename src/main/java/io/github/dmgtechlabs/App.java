package io.github.dmgtechlabs;

import io.github.dmgtechlabs.gui.MainFrame;
import javax.swing.UIManager;
import io.github.dmgtechlabs.db.Database;
import kdesp73.databridge.connections.DatabaseConnection;

public class App {

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
//		Customer c2 = new Customer("poi987-nf5ql8-zy345q", 200, 5678);
//		c2.delete();


//		var model = new Model("Focus", Model.Type.Sedan, 2008, 140, Model.WheelDrive._2WD, 51);
//		System.out.println(model);
//		model.insert();
		
//		var car = new Car(4, "license_plate", 5000, 3);
//		car.delete();

//		runGUI();
	}

}
