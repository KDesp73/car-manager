/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.Email;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author kdesp73
 */
public class EmailVerifier extends InputVerifier {

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
