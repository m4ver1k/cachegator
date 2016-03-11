/**
 *
 */
package org.cachegator.web;

import java.util.List;

import org.cachegator.beans.CacheDetails;
import org.cachegator.service.CacheDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m4ver1k
 * @since  31-Jan-2016
 * 
 */
@RestController
@RequestMapping("/api/cache")
public class CacheEndpoint {
	@Autowired
	private CacheDetailService cacheDetailService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody CacheDetails cacheDetails){
		cacheDetailService.add(cacheDetails);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void update(@RequestBody CacheDetails cacheDetails){
		cacheDetailService.update(cacheDetails);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CacheDetails> getAll(){
		return cacheDetailService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public CacheDetails get(@PathVariable("id")int id){
		return cacheDetailService.get(id);
	}
}
