/**
 *
 */
package org.cachegator.service;

import java.util.List;

import org.cachegator.beans.CacheDetails;
import org.cachegator.dao.CacheDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author m4ver1k
 * @since  31-Jan-2016
 * 
 */
@Service
public class CacheDetailService {

	@Autowired
	private CacheDetailDao cacheDetailDao;
	
	@Autowired
	private ConnectionService connectionService;
	
	@Transactional
	public void add(CacheDetails cacheDetails){
		cacheDetailDao.insert(cacheDetails);
	}
	
	public List<CacheDetails> getAll(){
		return cacheDetailDao.getAll();
		
	}
	
	public CacheDetails get(int id){
		return cacheDetailDao.get(id);
	}
	
	@Transactional
	public void update(CacheDetails cacheDetails){
		cacheDetailDao.update(cacheDetails);
	}
	
	public String getConnectionName(int cacheID){
		return connectionService.get(this.get(cacheID).getCon_id()).getName();
	}
}

