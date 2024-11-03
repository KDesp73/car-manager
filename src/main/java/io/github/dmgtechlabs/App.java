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
		var m = new Manufacturer(90, "test_name", "test_location");

//		m.insert();
		m.update("changed_name", "changed_location");

//		runGUI();
	}

}
