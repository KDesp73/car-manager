package io.github.dmgtechlabs;

import io.github.dmgtechlabs.gui.MainFrame;
import javax.swing.UIManager;
import io.github.dmgtechlabs.db.Database;
import javax.swing.UnsupportedLookAndFeelException;
import kdesp73.databridge.connections.DatabaseConnection;

public class App {

	private static void runGUI() {
		System.setProperty("sun.java2d.uiScale", "1");
//		try {
//			UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme());
//		} catch (UnsupportedLookAndFeelException ex) {
//			System.err.println("Failed to initialize LaF");
//		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	public static void main(String[] args) {	
		runGUI();
	}

}
