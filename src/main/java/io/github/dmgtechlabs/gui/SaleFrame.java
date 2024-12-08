/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Customer;
import io.github.dmgtechlabs.Employee;
import io.github.dmgtechlabs.Sale;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kdesp73
 */
public class SaleFrame extends javax.swing.JFrame {

	private Sale sale;
	private List<Car> cars;
	private List<Employee> employees;
	private List<Customer> customers;
	
	public boolean carsEmpty(){
		return this.cars.isEmpty();
	}

	/**
	 * Creates new form InsertSaleFrame
	 */
	public SaleFrame() {
		initComponents();
		GUIUtils.commonSetup(this);
		this.setResizable(false);
		
		this.cars = Car.selectCarsBySoldAndRepaired(false);
		this.employees = Employee.selectAll();
		this.customers = Customer.selectAll();

		if(this.cars.isEmpty()){
			GUIUtils.logUserError(null, "No cars suitable for sale. Add or repair more cars");
			this.dispose();
		}
		
		for (Car car : cars) {
			this.carComboBox.addItem(car.UIString());
		}

		for (Customer customer : customers) {
			this.customerComboBox.addItem(customer.UIString());
		}

		for (Employee emp : employees) {
			this.employeeComboBox.addItem(emp.UIString());
		}

		this.discountTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String text = discountTextField.getText();

				// Allow only digits and a single dot that is not the first character
				if (!(Character.isDigit(c) || (c == '.' && !text.isEmpty() && !text.contains(".")))) {
					e.consume();
				}
			}
		});
	}

	public SaleFrame(Sale sale) {
		this();
		this.sale = sale;
		this.actionButton.setText("Edit");

		this.employeeComboBox.setSelectedItem(sale.getEmployee().UIString());
		this.customerComboBox.setSelectedItem(sale.getCustomer().UIString());
		this.discountTextField.setValue(sale.getDiscount());
		this.carComboBox.setSelectedItem(sale.getCar().UIString());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        discountTextField = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        employeeComboBox = new javax.swing.JComboBox<>();
        carComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        actionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(687, 530));

        jLabel6.setText("Discount");

        discountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Customer");

        jLabel8.setText("Salesman");

        carComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("Car");

        actionButton.setText("Add");
        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(18, 18, 18)
                .addComponent(actionButton)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addComponent(jLabel1))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carComboBox, 0, 329, Short.MAX_VALUE)
                            .addComponent(discountTextField)
                            .addComponent(customerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(260, 260, 260)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

	private void clearForm() {
		this.carComboBox.setSelectedIndex(0);
		this.customerComboBox.setSelectedIndex(0);
		this.employeeComboBox.setSelectedIndex(0);
		this.discountTextField.setText("");
	}

	private void printForm() {
		System.out.println(this.cars.get(this.carComboBox.getSelectedIndex()));
		System.out.println(this.employees.get(this.employeeComboBox.getSelectedIndex()));
		System.out.println(this.customers.get(this.customerComboBox.getSelectedIndex()));
		System.out.println(this.employees.get(this.employeeComboBox.getSelectedIndex()).getEmployeeId());
		System.out.println(this.customers.get(this.customerComboBox.getSelectedIndex()).getId());

		System.out.println(this.discountTextField.getText());
	}

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed

		float price = this.cars.get(this.carComboBox.getSelectedIndex()).getPrice();
		float discount = (this.discountTextField.getText().isEmpty()) ? 0 : Float.parseFloat(this.discountTextField.getText());
		int carId = this.cars.get(this.carComboBox.getSelectedIndex()).getId();
		int employeeId = this.employees.get(this.employeeComboBox.getSelectedIndex()).getEmployeeId();
		int customerId = this.customers.get(this.customerComboBox.getSelectedIndex()).getId();

		if (this.sale == null) {
			Sale s = new Sale(
				price - price * discount,
				discount,
				carId,
				employeeId,
				customerId
			);

			if (s.insert()) {
				JOptionPane.showMessageDialog(this, "Sale added successfully");
				this.clearForm();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add sale", "Error", JOptionPane.ERROR_MESSAGE);
			}
			return;
		}
		
		if (this.sale.update(price - price*discount, discount, carId, employeeId, customerId)) {
			JOptionPane.showMessageDialog(this, "Sale edited successfully");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Failed to edit sale", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_actionButtonActionPerformed

    private void discountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTextFieldActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_discountTextFieldActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SaleFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> carComboBox;
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JFormattedTextField discountTextField;
    private javax.swing.JComboBox<String> employeeComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
