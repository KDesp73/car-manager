/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.dmgtechlabs;

/**
 *
 * @author kdesp73
 * @param <T>
 */
public interface Dao<T> {

	public void insert();

	public void update();

	public void delete();

	public String[] columns();
}
