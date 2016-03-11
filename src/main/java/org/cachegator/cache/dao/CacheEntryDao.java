/**
 *
 */
package org.cachegator.cache.dao;

import java.util.List;

import org.cachegator.beans.CacheEntry;

/**
 * @author m4ver1k
 * @since 04-Mar-2016
 * 
 */
public interface CacheEntryDao {
	public List<CacheEntry> getAll(String group,String conName);

	public CacheEntry get(String group, String key,String conName);

	public CacheEntry save(CacheEntry cacheEntry,String conName);

	public void remove(CacheEntry entry,String conName);

	public void removeAll(String group,String conName);
}
