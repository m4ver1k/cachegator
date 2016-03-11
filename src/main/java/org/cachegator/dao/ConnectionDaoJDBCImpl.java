/**
 *
 */
package org.cachegator.dao;

import java.util.List;

import org.cachegator.beans.ConnectionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * @author m4ver1k
 * @since  17-Jan-2016
 * 
 */
@Repository
public class ConnectionDaoJDBCImpl implements ConnectionDao{
	private final String insertSql="INSERT INTO cg_connections (name,host,port) values (:name,:host,:port)";
	private final String removeSql = "DELETE FROM cg_connections where name= :name";
	private final String readAllSql ="SELECT id,name,host,port FROM cg_connections";
	private final String readByIDSql ="SELECT id,name,host,port FROM cg_connections where id=?";
	private final String updateSql ="update cg_connections set name = :name,host=:host,port=:port where id= :id";
	@Autowired
	private NamedParameterJdbcTemplate nameParamJdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/* (non-Javadoc)
	 * @see org.cachegator.dao.config.ConnectionDao#add(org.cachegator.beans.ConnectionDetails)
	 */
	@Override
	public void insert(ConnectionDetails connectionDetails) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(connectionDetails);
		nameParamJdbcTemplate.update(insertSql,params);
		
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.config.ConnectionDao#remove(java.lang.String)
	 */
	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.config.ConnectionDao#get(java.lang.String)
	 */
	@Override
	public ConnectionDetails get(int id) {
		return jdbcTemplate.queryForObject(readByIDSql,new BeanPropertyRowMapper<ConnectionDetails>(ConnectionDetails.class),Integer.toString(id));
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.config.ConnectionDao#getAll()
	 */
	@Override
	public List<ConnectionDetails> getAll() {
		return jdbcTemplate.query(readAllSql,new BeanPropertyRowMapper<ConnectionDetails>(ConnectionDetails.class));
		
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.config.ConnectionDao#update(org.cachegator.beans.ConnectionDetails)
	 */
	@Override
	public void update(ConnectionDetails connectionDetails) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(connectionDetails);
		nameParamJdbcTemplate.update(updateSql,params);
	}

}
