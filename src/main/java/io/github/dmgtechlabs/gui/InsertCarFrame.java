/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Customer;
import io.github.dmgtechlabs.Employee;
import io.github.dmgtechlabs.Manufacturer;
import io.github.dmgtechlabs.Model;
import io.github.dmgtechlabs.Sale;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kdesp73
 */
public class InsertCarFrame extends javax.swing.JFrame {

	private List<Manufacturer> manufacturers;
	private List<Model> models;

	/**
	 * Creates new form InsertSaleFrame
	 */
	public InsertCarFrame() {
		initComponents();
		GUIUtils.commonSetup(this);

		this.manufacturers = Manufacturer.selectAllManufacturers();
		for(Manufacturer m : this.manufacturers) {
			this.manufacturerComboBox.addItem(m.UIString());
		}
		
		GUIUtils.setPlaceholder(this.priceTextFormattedField, "Price");
		GUIUtils.setPlaceholder(this.licensePlateTextField, "License Plate");
		
		this.priceTextFormattedField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String text = priceTextFormattedField.getText();

				// Allow only digits and a single dot that is not the first character
				if (!(Character.isDigit(c) || (c == '.' && !text.isEmpty() && !text.contains(".")))) {
					e.consume();
				}
			}
		});
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
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        manufacturerComboBox = new javax.swing.JComboBox<>();
        modelComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        priceTextFormattedField = new javax.swing.JFormattedTextField();
        licensePlateTextField = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Manufacturer");

        manufacturerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Model");

        licensePlateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licensePlateTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceTextFormattedField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modelComboBox, 0, 147, Short.MAX_VALUE)
                            .addComponent(manufacturerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(licensePlateTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(manufacturerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(priceTextFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(licensePlateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
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
		this.priceTextFormattedField.setText("");
		this.licensePlateTextField.setText("");
		this.modelComboBox.removeAllItems();
	}
	
	private void printForm() {
		System.out.println(this.licensePlateTextField.getText());
		System.out.println(this.priceTextFormattedField.getText());
		System.out.println(this.manufacturerComboBox.getSelectedIndex()  + ": " + this.manufacturerComboBox.getSelectedItem());
		System.out.println(this.modelComboBox.getSelectedIndex()  + ": " + this.modelComboBox.getSelectedItem());
	}
	
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
		this.printForm();
		Car c = new Car(
			this.licensePlateTextField.getText(),
			Float.parseFloat(this.priceTextFormattedField.getText()),
			this.models.get(this.modelComboBox.getSelectedIndex()).getId()
		);
		
		if(c.insert()) {
			JOptionPane.showMessageDialog(this, "Added Car (" + c.getLicencePlate() + ") successfully");
			this.clearForm();
		} else { 
			JOptionPane.showMessageDialog(this, "Error", "Failed adding car", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_addButtonActionPerformed

    private void licensePlateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licensePlateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licensePlateTextFieldActionPerformed

    private void manufacturerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerComboBoxActionPerformed
        this.models = Model.selectByManufacturer(this.manufacturers.get(this.manufacturerComboBox.getSelectedIndex()).getManufacturerName());
		
		this.modelComboBox.removeAllItems();
		for(Model m : this.models) {
			this.modelComboBox.addItem(m.UIString());
		}
    }//GEN-LAST:event_manufacturerComboBoxActionPerformed

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
			java.util.logging.Logger.getLogger(InsertCarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InsertCarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InsertCarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InsertCarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InsertCarFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField licensePlateTextField;
    private javax.swing.JComboBox<String> manufacturerComboBox;
    private javax.swing.JComboBox<String> modelComboBox;
    private javax.swing.JFormattedTextField priceTextFormattedField;
    // End of variables declaration//GEN-END:variables
}
