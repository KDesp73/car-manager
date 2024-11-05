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
//		Customer c1 = new Customer(1234, "a23df-fah43-pi3jh-asd64", "Athanasios", "Georgalis", "thanasisgeorg03@gmail.com", 2003, Person.Gender.MALE);		
//		Customer c2 = new Customer(5678, "b29kf-mfgh3-poi21-nuvi7", "Konstantinos", "Despoinidis", "kdesp73@gmail.com", 2003, Person.Gender.MALE);
//		
//		c1.insert();
//		c2.insert();
		
//		Employee e1 = new Employee(1234, 500, "Athanasios", "Georgalis", "thanasisgeorg03@gmail.com", 2003, Person.Gender.MALE);		
//		Employee e2 = new Employee(5678, 500, "Konstantinos", "Despoinidis", "kdesp73@gmail.com", 2003, Person.Gender.MALE);
//		
//		e1.insert();
//		e2.insert();

//		if (Customer.selectAll().size() != 0) {
//			for (int i = 0; i < Customer.selectAll().size(); i++) {
//				System.out.println("Index: " + i);
//				System.out.println(Customer.selectAll().get(i).toString());
//			}
//		} else System.out.println("IS EMPTY");

		

//		var model = new Model("Focus", Model.Type.Sedan, 2008, 140, Model.WheelDrive._2WD, 51);
//		System.out.println(model);
//		model.insert();
		
		var car = new Car(4, "license_plate", 5000, 3);
		car.delete();

//		runGUI();
	}

}
