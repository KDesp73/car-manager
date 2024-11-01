package io.github.dmgtechlabs.gui;//GEN-LINE:variables//GEN-END:variables//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables

public class MainFrame extends javax.swing.JFrame {

	private HelpFrame helpFrame;
	private AboutFrame aboutFrame;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();

		this.helpFrame = new HelpFrame();
		this.aboutFrame = new AboutFrame();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:variables//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables
	private void initComponents() {

		actionListScrollPane = new javax.swing.JScrollPane();
		actionList = new javax.swing.JList<>();
		cardContainer = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jMenuBar1 = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		editMenu = new javax.swing.JMenu();
		helpMenu = new javax.swing.JMenu();
		helpMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		actionList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		actionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		actionList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		actionListScrollPane.setViewportView(actionList);

		cardContainer.setLayout(new java.awt.CardLayout());

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 874, Short.MAX_VALUE)
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 689, Short.MAX_VALUE)
		);

		cardContainer.add(jPanel2, "card2");

		fileMenu.setText("File");
		jMenuBar1.add(fileMenu);

		editMenu.setText("Edit");
		jMenuBar1.add(editMenu);

		helpMenu.setText("Help");

		helpMenuItem.setText("Help");
		helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				helpMenuItemActionPerformed(evt);
			}
		});
		helpMenu.add(helpMenuItem);

		aboutMenuItem.setText("About");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		helpMenu.add(aboutMenuItem);

		jMenuBar1.add(helpMenu);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(actionListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(actionListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
				.addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		pack();

	}// </editor-fold>

	private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
		if (helpFrame.isShowing()) {
			return;
		}

		helpFrame.setVisible(true);
	}//GEN-LAST:event_helpMenuItemActionPerformed

	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
		if (aboutFrame.isShowing()) {
			return;
		}

		aboutFrame.setVisible(true);
	}//GEN-LAST:event_aboutMenuItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JMenu editMenu;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenu helpMenu;
	private private javax.swing.JMenuItem helpMenuItem;
	private javax.swing.JMenuBar jMenuBar1;
	// End of variables declaration//GEN-END:variables
}
