/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs.gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author kdesp73
 */
public class GUIUtils {
	public static void commonSetup(JFrame frame) {
		frame.setLocationRelativeTo(null);
		GUIMethods.setFontFamilyRecursively(frame, "sans-serif", Font.PLAIN);
	}
}
