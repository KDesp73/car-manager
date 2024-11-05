package io.github.dmgtechlabs;

import java.util.List;

/**
 *
 * @author kdesp73
 * @param <T>
 */
public interface Dao<T> {

	public boolean insert();

	public boolean update(Object... values);

	public boolean delete();
}
