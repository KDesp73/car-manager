package io.github.dmgtechlabs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kdesp73
 */
public class Email {

	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public String address;

	public Email(String address) {
		this.address = address;
	}

	public boolean validate() {
		if (address == null || address.isEmpty()) {
			return false;
		}

		Matcher matcher = EMAIL_PATTERN.matcher(address);
		return matcher.matches();
	}

}
