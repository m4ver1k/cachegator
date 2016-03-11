/**
 *
 */
package org.cachegator.cache.dao;

import java.util.ArrayList;
import java.util.List;

import org.cachegator.beans.CacheEntry;
import org.cachegator.core.connection.RedisConnectionManager;
import org.cachegator.exception.InvalidConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
@Repository
public class JedisCacheEntryDaoImpl implements CacheEntryDao {

	
	@Autowired
	RedisConnectionManager connectionManager;

	/* (non-Javadoc)
	 * @see org.cachegator.cache.dao.CacheEntryDao#getAll(java.lang.String)
	 */
	@Override
	public List<CacheEntry> getAll(String group,String conName) {
		Jedis con = connectionManager.getConnection(conName).orElseThrow( ()-> new InvalidConnectionException(conName));
		List<CacheEntry> caches = new ArrayList<>();
		for(String key:con.keys(group+":*")){
			String ckey = key.split(":")[1];
			if(ckey==null || ckey.equals("")){
				//skip this entry key in wrong format.
				continue;
			}
				
			caches.add(new CacheEntry(ckey, con.get(key), group));
		}
		return caches;
	}

	/* (non-Javadoc)
	 * @see org.cachegator.cache.dao.CacheEntryDao#get(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public CacheEntry get(String group, String key, String conName) {
		Jedis con = connectionManager.getConnection(conName).orElseThrow( ()-> new InvalidConnectionException(conName));
		String value = con.get(group+":"+key);
		
		if(value==null)
			return null;
		
		return new CacheEntry(key, value, group);
	}

	/* (non-Javadoc)
	 * @see org.cachegator.cache.dao.CacheEntryDao#save(org.cachegator.beans.CacheEntry, java.lang.String)
	 */
	@Override
	public CacheEntry save(CacheEntry cacheEntry, String conName) {
		Jedis con = connectionManager.getConnection(conName).orElseThrow( ()-> new InvalidConnectionException(conName));
		con.set(cacheEntry.getGroup()+":"+cacheEntry.getKey(), cacheEntry.getValue());
		return this.get(cacheEntry.getGroup(), cacheEntry.getKey(), conName);
	}

	/* (non-Javadoc)
	 * @see org.cachegator.cache.dao.CacheEntryDao#remove(org.cachegator.beans.CacheEntry, java.lang.String)
	 */
	@Override
	public void remove(CacheEntry entry, String conName) {
		Jedis con = connectionManager.getConnection(conName).orElseThrow( ()-> new InvalidConnectionException(conName));
		con.del(entry.getGroup()+":"+entry.getKey());
	}

	/* (non-Javadoc)
	 * @see org.cachegator.cache.dao.CacheEntryDao#removeAll(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeAll(String group, String conName) {
		Jedis con = connectionManager.getConnection(conName).orElseThrow( ()-> new InvalidConnectionException(conName));
		for(String key:con.keys(group+":*")){
			con.del(group+":"+key);
		}
	}
	
}
