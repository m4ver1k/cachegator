/**
 *
 */
package org.cachegator.service;

import java.util.List;

import org.cachegator.beans.ConnectionDetails;
import org.cachegator.core.connection.RedisConnectionManager;
import org.cachegator.dao.ConnectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author m4ver1k
 * @since  13-Jan-2016
 * 
 */
@Service
public class ConnectionService {
	
	@Autowired
	ConnectionDao connectionDao;
	@Autowired
	RedisConnectionManager connectionManager;
	
	@Transactional
	public void addConnection(ConnectionDetails connectionDetails){
		connectionDao.insert(connectionDetails);
		connectionManager.addConnection(connectionDetails);
	}
	
	@Transactional
	public void updateConnection(ConnectionDetails connectionDetails){
		connectionDao.update(connectionDetails);
		connectionManager.updateConnection(connectionDetails);
		
	}
	
	
	public List<ConnectionDetails> getAll(){
		return connectionDao.getAll();
	}
	
	public ConnectionDetails get(int id){
		return connectionDao.get(id);
	}
}
