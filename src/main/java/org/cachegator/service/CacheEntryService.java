/**
 *
 */
package org.cachegator.service;

import java.util.List;

import org.cachegator.beans.CacheDetails;
import org.cachegator.beans.CacheEntry;
import org.cachegator.cache.dao.CacheEntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
@Service
public class CacheEntryService {
	
	@Autowired
	private CacheEntryDao cacheEntryDao;
	
	@Autowired
	private CacheDetailService cacheDetailService;

	
	public CacheEntry insert(CacheEntry cacheEntry,int cacheId){
		cacheEntry.setGroup(cacheDetailService.get(cacheId).getName());
		return cacheEntryDao.save(cacheEntry,cacheDetailService.getConnectionName(cacheId));
	}
	
	public List<CacheEntry> getAll(int cacheId){
		return this.cacheEntryDao.getAll(this.getCacheGroup(cacheId), cacheDetailService.getConnectionName(cacheId));
	}
	
	public CacheEntry get(int cacheId,String cacheEntryKey){
		return this.cacheEntryDao.get(this.getCacheGroup(cacheId), cacheEntryKey, cacheDetailService.getConnectionName(cacheId));
	}
	
	public void remove(String cacheKey,int cacheId){
		CacheEntry cacheEntry  = this.get(cacheId, cacheKey);
		if(cacheEntry==null){
			return;
		}
		this.cacheEntryDao.remove(cacheEntry, cacheDetailService.getConnectionName(cacheId));
	}
	
	public void removeAll(int cacheId){
		CacheDetails cacheDetails = cacheDetailService.get(cacheId);
		this.cacheEntryDao.removeAll(cacheDetails.getName()	, cacheDetailService.getConnectionName(cacheId));
	}
	private String getCacheGroup(int cacheId){
		return cacheDetailService.get(cacheId).getName();
	}
	
	
}
