package io.github.dmgtechlabs.gui;//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables//GEN-LINE:variables

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Sale;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;

public class MainFrame extends javax.swing.JFrame {
	
	private HelpFrame helpFrame;
	private AboutFrame aboutFrame;
	private LogsFrame logsFrame;
	private CardLayout cardLayout;
	private InsertSaleFrame insertSaleFrame;
	private InsertEmployeeFrame insertEmployeeFrame;
	private InsertCarFrame insertCarFrame;

	// Sales Card
	private List<Sale> sales;

	// Cars Card
	private List<Car> cars;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
		GUIUtils.commonSetup(this);
		
		this.cardLayout = (CardLayout) this.cardContainer.getLayout();
		this.helpFrame = new HelpFrame();
		this.aboutFrame = new AboutFrame();
		this.logsFrame = null;
//		this.insertSaleFrame = new InsertSaleFrame();
//		this.insertEmployeeFrame = new InsertEmployeeFrame();
//		this.insertCarFrame = new InsertCarFrame();
		
		this.formList.setFixedCellHeight(40);
		this.formList.setListData(new String[]{"Sales", "Cars", "Employees", "Customers"});
		this.cardLayout.addLayoutComponent(this.salesPanel, "Sales");
		this.cardLayout.addLayoutComponent(this.carsPanel, "Cars");
		this.cardLayout.addLayoutComponent(this.employeesPanel, "Employees");
		this.cardLayout.addLayoutComponent(this.customersPanel, "Customers");

		// Sales Card
		this.salesList.setFixedCellHeight(25);
		this.sales = Sale.selectAll();
		this.salesList.setListData(Sale.listToArray(sales));
		
		// Cars Card
		this.carsList.setFixedCellHeight(25);
		this.cars = Car.selectAllCars();
		this.carsList.setListData(Car.listToArray(cars));
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formListContainer = new javax.swing.JScrollPane();
        formList = new javax.swing.JList<>();
        cardContainer = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        carsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        carsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        addCarButton = new javax.swing.JButton();
        editCarButton = new javax.swing.JButton();
        deleteCarButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        carsEditorPane = new javax.swing.JEditorPane();
        employeesPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        addMenu = new javax.swing.JMenu();
        addSaleMenuItem = new javax.swing.JMenuItem();
        addCarMenuItem = new javax.swing.JMenuItem();
        addCustomerMenuItem = new javax.swing.JMenuItem();
        addEmployeeMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        logsMenu = new javax.swing.JMenu();
        carsLogsMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        formList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        formList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        formList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formListMouseClicked(evt);
            }
        });
        formListContainer.setViewportView(formList);

        cardContainer.setLayout(new java.awt.CardLayout());

        salesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(salesList);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALES");

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                .addContainerGap())
        );

        cardContainer.add(salesPanel, "card2");

        carsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(carsList);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CARS");

        addCarButton.setText("ADD");

        editCarButton.setText("EDIT");

        deleteCarButton.setText("DELETE");

        jScrollPane3.setViewportView(carsEditorPane);

        javax.swing.GroupLayout carsPanelLayout = new javax.swing.GroupLayout(carsPanel);
        carsPanel.setLayout(carsPanelLayout);
        carsPanelLayout.setHorizontalGroup(
            carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carsPanelLayout.createSequentialGroup()
                .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(addCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(editCarButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCarButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        carsPanelLayout.setVerticalGroup(
            carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carsPanelLayout.createSequentialGroup()
                        .addGroup(carsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addCarButton)
                            .addComponent(editCarButton)
                            .addComponent(deleteCarButton))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        cardContainer.add(carsPanel, "card3");

        jLabel3.setText("employees");

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeesPanelLayout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(296, 296, 296))
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel3)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        cardContainer.add(employeesPanel, "card4");

        jLabel4.setText("customers");

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPanelLayout.createSequentialGroup()
                .addContainerGap(626, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(102, 102, 102))
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel4)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        cardContainer.add(customersPanel, "card5");

        addMenu.setText("Add");

        addSaleMenuItem.setText("Sale");
        addSaleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addSaleMenuItem);

        addCarMenuItem.setText("Car");
        addCarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addCarMenuItem);

        addCustomerMenuItem.setText("Customer");
        addMenu.add(addCustomerMenuItem);

        addEmployeeMenuItem.setText("Employee");
        addEmployeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addEmployeeMenuItem);

        jMenuBar1.add(addMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        logsMenu.setText("Logs");

        carsLogsMenuItem.setText("Cars");
        carsLogsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsLogsMenuItemActionPerformed(evt);
            }
        });
        logsMenu.add(carsLogsMenuItem);

        jMenuBar1.add(logsMenu);

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
                .addComponent(formListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formListContainer)
            .addComponent(cardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void formListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formListMouseClicked
		if (evt.getButton() == MouseEvent.BUTTON1) {
			String selected = this.formList.getSelectedValue();
			
			this.cardLayout.show(this.cardContainer, selected);
		}
    }//GEN-LAST:event_formListMouseClicked

    private void carsLogsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsLogsMenuItemActionPerformed
		if (this.logsFrame != null && this.logsFrame.isShowing()) {
			return;
		}
		
		this.logsFrame = new LogsFrame(LogsFrame.LogType.CARS);
		this.logsFrame.setVisible(true);
    }//GEN-LAST:event_carsLogsMenuItemActionPerformed

    private void addSaleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleMenuItemActionPerformed
		if (this.insertSaleFrame.isShowing()) {
			return;
		}
		
		this.insertSaleFrame.setVisible(true);
    }//GEN-LAST:event_addSaleMenuItemActionPerformed

    private void addEmployeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuItemActionPerformed
        if (this.insertEmployeeFrame.isShowing()) {
			return;
		}
		
		this.insertEmployeeFrame.setVisible(true);
    }//GEN-LAST:event_addEmployeeMenuItemActionPerformed

    private void addCarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarMenuItemActionPerformed
        if (this.insertCarFrame.isShowing()) {
			return;
		}
		
		this.insertCarFrame.setVisible(true);
    }//GEN-LAST:event_addCarMenuItemActionPerformed

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
    private javax.swing.JButton addCarButton;
    private javax.swing.JMenuItem addCarMenuItem;
    private javax.swing.JMenuItem addCustomerMenuItem;
    private javax.swing.JMenuItem addEmployeeMenuItem;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem addSaleMenuItem;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JEditorPane carsEditorPane;
    private javax.swing.JList<String> carsList;
    private javax.swing.JMenuItem carsLogsMenuItem;
    private javax.swing.JPanel carsPanel;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JButton deleteCarButton;
    private javax.swing.JButton editCarButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JList<String> formList;
    private javax.swing.JScrollPane formListContainer;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu logsMenu;
    private javax.swing.JList<String> salesList;
    private javax.swing.JPanel salesPanel;
    // End of variables declaration//GEN-END:variables
}
