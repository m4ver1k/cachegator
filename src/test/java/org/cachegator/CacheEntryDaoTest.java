/**
 *
 */
package org.cachegator;

import redis.clients.jedis.Jedis;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
public class CacheEntryDaoTest {
	public static void main(String[] args) {
		Jedis con = new Jedis("localhost",6379);
		con.select(1);
		con.set("product:p101","{name:'yoyo'}");
		con.set("product:p102","{name:'hoyo'}");
		con.set("product:p103","{name:'gogo'}");
		con.set("product:p104","{name:'foyo'}");
		
		
		for(String key:con.keys("product:*")){
			System.out.println(con.get(key));
		}
		
		con.close();
		//con.get
		
	}
}
