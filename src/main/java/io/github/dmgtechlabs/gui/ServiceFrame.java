/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.Service;
import javax.swing.JOptionPane;

/**
 *
 * @author kdesp73
 */
public class ServiceFrame extends javax.swing.JFrame {

	private Service service;
	
	/**
	 * Creates new form ServiceFrame
	 */
	public ServiceFrame(Service service) {
		initComponents();
		GUIUtils.commonSetup(this);
		this.service = service;
		
		if(service == null) return;
		
		this.tiresCheckBox.setSelected(service.tiresChecked());
		this.brakesCheckBox.setSelected(service.brakesChecked());
		this.engineCheckBox.setSelected(service.engineChecked());
		this.oilCheckBox.setSelected(service.oilChecked());
		this.batteryCheckBox.setSelected(service.batteryChecked());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        engineCheckBox = new javax.swing.JCheckBox();
        batteryCheckBox = new javax.swing.JCheckBox();
        oilCheckBox = new javax.swing.JCheckBox();
        brakesCheckBox = new javax.swing.JCheckBox();
        tiresCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        engineCheckBox.setText("Engine");

        batteryCheckBox.setText("Battery");

        oilCheckBox.setText("Oil");

        brakesCheckBox.setText("Brakes");

        tiresCheckBox.setText("Tires");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(18, 18, 18)
                .addComponent(applyButton)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tiresCheckBox)
                    .addComponent(brakesCheckBox)
                    .addComponent(oilCheckBox)
                    .addComponent(batteryCheckBox)
                    .addComponent(engineCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(engineCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(batteryCheckBox)
                .addGap(18, 18, 18)
                .addComponent(oilCheckBox)
                .addGap(18, 18, 18)
                .addComponent(brakesCheckBox)
                .addGap(18, 18, 18)
                .addComponent(tiresCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(cancelButton))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        Service updatedService = new Service(
			this.tiresCheckBox.isSelected(),
			this.engineCheckBox.isSelected(),
			this.brakesCheckBox.isSelected(),
			this.oilCheckBox.isSelected(),
			this.batteryCheckBox.isSelected()
		);
		
		if(service.update(
			updatedService.tiresChecked(),
			updatedService.engineChecked(),
			updatedService.brakesChecked(),
			updatedService.oilChecked(),
			updatedService.batteryChecked()
		)){
			JOptionPane.showMessageDialog(this, "Service updated successfully");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Failed updating service", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_applyButtonActionPerformed

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
			java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ServiceFrame(null).setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JCheckBox batteryCheckBox;
    private javax.swing.JCheckBox brakesCheckBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox engineCheckBox;
    private javax.swing.JCheckBox oilCheckBox;
    private javax.swing.JCheckBox tiresCheckBox;
    // End of variables declaration//GEN-END:variables
}