/**
 *
 */
package org.cachegator.dao;

import java.util.List;

import org.cachegator.beans.CacheDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author m4ver1k
 * @since  31-Jan-2016
 * 
 */
@Repository
public class CacheDetailDaoJDBCImpl implements CacheDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String insertSql = "insert into cg_caches (name,description,dbname,con_id) values(:name,:description,:dbname,:con_id)";
	private final String updateSql = "update cg_caches set name=:name,description=:description,dbname=:dbname,con_id=:con_id where id=:id";
	private final String readAllSql = "select id,name,description,dbname,con_id from cg_caches";
	private final String readByIdSql = "select id,name,description,dbname,con_id from cg_caches where id=?";
	
	
	/* (non-Javadoc)
	 * @see org.cachegator.dao.CacheDetailDao#insert(org.cachegator.beans.CacheDetails)
	 */
	@Override
	public void insert(CacheDetails cacheDetails) {
			namedParameterJdbcTemplate.update(insertSql, new BeanPropertySqlParameterSource(cacheDetails));
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.CacheDetailDao#getAll()
	 */
	@Override
	public List<CacheDetails> getAll() {
		return jdbcTemplate.query(readAllSql,new BeanPropertyRowMapper<CacheDetails>(CacheDetails.class));
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.CacheDetailDao#get(int)
	 */
	@Override
	public CacheDetails get(int id) {
		return jdbcTemplate.queryForObject(readByIdSql,new BeanPropertyRowMapper<CacheDetails>(CacheDetails.class),Integer.toString(id));
	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.CacheDetailDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.cachegator.dao.CacheDetailDao#update(org.cachegator.beans.CacheDetails)
	 */
	@Override
	public void update(CacheDetails cacheDetails) {
		namedParameterJdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(cacheDetails));
	}

}
