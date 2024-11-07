/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.Car;
import io.github.dmgtechlabs.Customer;
import io.github.dmgtechlabs.Email;
import io.github.dmgtechlabs.Employee;
import io.github.dmgtechlabs.Person;
import static io.github.dmgtechlabs.Person.int2Gender;
import io.github.dmgtechlabs.Sale;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Year;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author kdesp73
 */
public class EmployeeFrame extends javax.swing.JFrame {
	
	private Employee employee;

	static class EmailVerifier extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {
			String text = ((JFormattedTextField) input).getText();
			return Email.EMAIL_PATTERN.matcher(text).matches();
		}

		@Override
		public boolean shouldYieldFocus(JComponent input) {
			if (!verify(input)) {
				JOptionPane.showMessageDialog(input, "Please enter a valid email address.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
				return false; // Keep focus on the field if invalid
			}
			return true; // Allow focus transfer if valid
		}
	}

	/**
	 * Creates new form InsertSaleFrame
	 */
	public EmployeeFrame() {
		initComponents();
		GUIUtils.commonSetup(this);
		this.setResizable(false);

		GUIUtils.setPlaceholder(this.fnameTextField, "First Name");
		GUIUtils.setPlaceholder(this.lnameTextField, "Last Name");
		GUIUtils.setPlaceholder(this.emailTextFormattedField, "Email");
		this.emailTextFormattedField.setInputVerifier(new EmailVerifier());
		this.birthYearSpinner.setModel(new SpinnerNumberModel(1990, 1900, Year.now().getValue() - 18, 1));
		GUIUtils.setPlaceholder(this.salaryFormattedTextField, "Salary");
		this.salaryFormattedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String text = salaryFormattedTextField.getText();

				// Allow only digits and a single dot that is not the first character
				if (!(Character.isDigit(c) || (c == '.' && !text.isEmpty() && !text.contains(".")))) {
					e.consume();
				}
			}
		});

		this.genderComboBox.setModel(new DefaultComboBoxModel(new String[]{
			Person.Gender.MALE.toString(),
			Person.Gender.FEMALE.toString(),
			Person.Gender.OTHER.toString()
		}));
	}
	
	public EmployeeFrame(Employee employee) {
		this();
		this.employee = employee;
		this.actionButton.setText("Edit");
		
		// Load data into form
		this.fnameTextField.setText(employee.getFname());
		this.lnameTextField.setText(employee.getFname());
		this.birthYearSpinner.setModel(new SpinnerNumberModel(employee.getBirthYear(), 1900, Year.now().getValue() - 18, 1));
		this.genderComboBox.setSelectedItem(employee.getGender().name());
		this.emailTextFormattedField.setText(employee.getEmail());
		this.salaryFormattedTextField.setText(employee.getSalary() + "");
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
        actionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fnameTextField = new javax.swing.JTextField();
        lnameTextField = new javax.swing.JTextField();
        birthYearSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        emailTextFormattedField = new javax.swing.JFormattedTextField();
        salaryFormattedTextField = new javax.swing.JFormattedTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText("Birth Year");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Gender");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(259, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(fnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailTextFormattedField)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(genderComboBox, 0, 135, Short.MAX_VALUE)
                                                .addComponent(birthYearSpinner)))
                                        .addComponent(salaryFormattedTextField)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(fnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(birthYearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(emailTextFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salaryFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
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

	private void clearForm() {
		this.fnameTextField.setText("");
		this.lnameTextField.setText("");
		this.birthYearSpinner.setValue(0);
		this.genderComboBox.setSelectedIndex(0);
		this.emailTextFormattedField.setText("");
		this.salaryFormattedTextField.setText("");
	}
	
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed
		if (this.actionButton.getText() == "Add") {
			Employee e = new Employee(
				Float.parseFloat(this.salaryFormattedTextField.getText()),
				this.fnameTextField.getText(),
				this.lnameTextField.getText(),
				(int) this.birthYearSpinner.getValue(),
				int2Gender(this.genderComboBox.getSelectedIndex()),
				this.emailTextFormattedField.getText()
			);

			if (e.insert()) {
				JOptionPane.showMessageDialog(this, "Employee " + e.getFname() + " " + e.getLname() + "added successfully");
				this.clearForm();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add employee", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			Employee e = new Employee(
				Float.parseFloat(this.salaryFormattedTextField.getText()),
				this.fnameTextField.getText(),
				this.lnameTextField.getText(),
				(int) this.birthYearSpinner.getValue(),
				int2Gender(this.genderComboBox.getSelectedIndex()),
				this.emailTextFormattedField.getText()
			);

			if (e.update()) {
				JOptionPane.showMessageDialog(this, "Employee " + e.getFname() + " " + e.getLname() + "updated successfully");
				//this.clearForm();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to update employee", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_actionButtonActionPerformed

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
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EmployeeFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionButton;
    private javax.swing.JSpinner birthYearSpinner;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFormattedTextField emailTextFormattedField;
    private javax.swing.JTextField fnameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lnameTextField;
    private javax.swing.JFormattedTextField salaryFormattedTextField;
    // End of variables declaration//GEN-END:variables
}
