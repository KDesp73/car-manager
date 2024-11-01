/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author kdesp73
 */
public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException(String message) {
		super(message);
	}

}
