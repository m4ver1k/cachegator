/**
 *
 */
package org.cachegator.core.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.cachegator.beans.ConnectionDetails;
import org.cachegator.dao.ConnectionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

/**
 * @author m4ver1k
 * @since 13-Jan-2016
 * 
 */
@Component
public class RedisConnectionManager {

	@Autowired
	private ConnectionDao connectionDao;

	private Logger logger = LoggerFactory.getLogger(RedisConnectionManager.class.getName());
	
	private Map<String, Jedis> connections = new HashMap<>();

	public Optional<Jedis> getConnection(String name) {
		return Optional.ofNullable(connections.get(name));
	}

	public void addConnection(ConnectionDetails connectionDetail) {
		connections.put(connectionDetail.getName(),
				new Jedis(connectionDetail.getHost(), connectionDetail.getPort()));
		logger.info("Added new Connection " + connectionDetail);
	}

	public void updateConnection(ConnectionDetails connectionDetail) {
		connections.put(connectionDetail.getName(),
				new Jedis(connectionDetail.getHost(), connectionDetail.getPort()));
		logger.info("Updated Connection " + connectionDetail);
	}

	public void removeConnection(String name) {
		connections.remove(name);
	}

	@PostConstruct
	private void init() {
		for (ConnectionDetails connectionDetail : connectionDao.getAll()) {
			this.addConnection(connectionDetail);
		}
	}
}
