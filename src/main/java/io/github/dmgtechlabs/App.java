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
//		Customer c1 = new Customer(1234, "a23df-fah43-pi3jh-asd64", new Person(1234, "Athanasios", "Georgalis", "thanasisgeorg03@gmail.com", 2003, Person.Gender.MALE));		
//		Customer c2 = new Customer(5678, "b29kf-mfgh3-poi21-nuvi7", new Person(5678, "Konstantinos", "Despoinidis", "kdesp73@gmail.com", 2003, Person.Gender.MALE));
//		
//		c1.insert();
//		c2.insert();
		
//		runGUI();
	}

}
