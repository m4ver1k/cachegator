/**
 *
 */
package org.cachegator.dao;

import java.util.List;

import org.cachegator.beans.ConnectionDetails;

/**
 * @author m4ver1k
 * @since  17-Jan-2016
 * 
 */
public interface ConnectionDao {
	public void insert(ConnectionDetails connectionDetails);
	public void update(ConnectionDetails connectionDetails);
	public void remove(int id);
	public ConnectionDetails get(int id);
	public List<ConnectionDetails> getAll();
}
