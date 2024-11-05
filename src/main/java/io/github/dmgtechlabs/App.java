package io.github.dmgtechlabs;

import io.github.dmgtechlabs.gui.MainFrame;
import javax.swing.UIManager;
import io.github.dmgtechlabs.db.Database;
import kdesp73.databridge.connections.DatabaseConnection;

public class App {

	private static void runGUI() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	public static void main(String[] args) {	
		var list = CarLog.selectAll();
		for(CarLog m : list) {
			System.out.println(m);
		}
	}

}
