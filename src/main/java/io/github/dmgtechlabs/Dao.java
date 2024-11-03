package io.github.dmgtechlabs;

import java.util.List;

/**
 *
 * @author kdesp73
 * @param <T>
 */
public interface Dao<T> {

	public void insert();

	public void update(Object... values);

	public void delete();

	public static <T> List<T> select(String condition) {
		throw new UnsupportedOperationException("TODO: implement for each class that supports the Dao");
	}
}
