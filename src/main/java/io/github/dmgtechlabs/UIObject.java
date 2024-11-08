/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.dmgtechlabs;

import java.util.List;

/**
 *
 * @author kdesp73
 */
public interface UIObject {
	String UIString();
	String toHTML();
	Object[] objArray();
	
	public static String[] listToArray(List<UIObject> list) {
		String[] result = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i).UIString();
		}

		return result;
	}
	
	public static Object[][] tableData(List<UIObject> list) {
		var result = new Object[list.size()][];
		
		for(int i = 0; i < list.size(); i++) {
			result[i] = list.get(i).objArray();
		}
		
		return result;
	}
}
