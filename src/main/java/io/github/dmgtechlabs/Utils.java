/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 */
public class Utils {

	public static Object[] appendFront(Object item, Object... values) {
		Object[] params = new Object[values.length + 1];
		params[0] = item;
		System.arraycopy(values, 0, params, 1, values.length);

		return params;
	}

	public static Object[] appendBack(Object item, Object... values) {
		Object[] params = new Object[values.length + 1];
		System.arraycopy(values, 0, params, 0, values.length);
		params[values.length] = item;

		return params;
	}

}
