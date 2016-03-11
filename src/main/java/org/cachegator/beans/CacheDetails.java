/**
 *
 */
package org.cachegator.beans;

/**
 * @author m4ver1k
 * @since  31-Jan-2016
 * 
 */
public class CacheDetails {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int con_id;
	
	private String dbname;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the con_id
	 */
	public int getCon_id() {
		return con_id;
	}

	/**
	 * @param con_id the con_id to set
	 */
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	/**
	 * @return the dbname
	 */
	public String getDbname() {
		return dbname;
	}

	/**
	 * @param dbname the dbname to set
	 */
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CacheDetails [id=" + id + ", name=" + name + ", description=" + description + ", con_id=" + con_id
				+ ", dbname=" + dbname + "]";
	}
}
