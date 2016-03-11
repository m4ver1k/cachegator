/**
 *
 */
package org.cachegator.beans;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
public class CacheEntry {
	
	private String key;
	
	private String value;
	
	private String group;
	
	/**
	 * 
	 */
	public CacheEntry() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	public CacheEntry(String key,String value,String group) {
		this.key=key;
		this.value=value;
		this.group=group;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
}
