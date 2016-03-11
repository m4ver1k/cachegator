/**
 *
 */
package org.cachegator.dao;

import java.util.List;

import org.cachegator.beans.CacheDetails;

/**
 * @author m4ver1k
 * @since  31-Jan-2016
 * 
 */
public interface CacheDetailDao {
	public void insert(CacheDetails cacheDetails);
	public List<CacheDetails> getAll();
	public CacheDetails get(int id);
	public void delete(int id);
	public void update(CacheDetails cacheDetails);
}
