/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import io.github.dmgtechlabs.UIObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.function.Function;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author kdesp73
 */
public class GUIUtils {
	public static void addWindowClosedListener(JFrame frame, Runnable action) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                action.run(); 
            }
        });
    }

	
	public static void showInfo(JEditorPane pane, UIObject obj) {
		pane.setText(obj.toHTML());
	}
	
	public static void showFrame(JFrame frame) {
		if(frame.isShowing()) return;
		
		frame.setVisible(true);
	}
	
	public static void commonSetup(JFrame frame) {
		frame.setLocationRelativeTo(null);
		GUIMethods.setFontFamilyRecursively(frame, "sans-serif", Font.PLAIN);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static KeyAdapter getFloatFormattedAdapter(String text){
		return new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || c == '.' && !text.contains(".")) || (c == '.' && !text.isEmpty())) {
                    e.consume();
                }
            }
        };
	}
	
	public static void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }
	
	public static int generateID() {
		Random rand = new Random();
		
		return rand.nextInt(10000);
	}
}
