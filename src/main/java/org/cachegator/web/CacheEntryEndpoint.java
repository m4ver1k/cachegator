/**
 *
 */
package org.cachegator.web;

import java.util.List;

import org.cachegator.beans.CacheEntry;
import org.cachegator.service.CacheEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m4ver1k
 * @since  04-Mar-2016
 * 
 */
@RestController
@RequestMapping("/api/cache/{id}/value")
public class CacheEntryEndpoint {
	
	@Autowired
	private CacheEntryService cacheEntryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CacheEntry> getAll(@PathVariable("id") int cacheId){
		return cacheEntryService.getAll(cacheId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{key}")
	public CacheEntry get(@PathVariable("id") int cacheId,@PathVariable("key") String cacheEntryKey){
		return cacheEntryService.get(cacheId, cacheEntryKey);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{key}")
	public CacheEntry update(@RequestBody CacheEntry cacheEntry,@PathVariable("id") int cacheId,@PathVariable("key") String cacheEntryKey){
		return cacheEntryService.insert(cacheEntry, cacheId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public CacheEntry insert(@RequestBody CacheEntry cacheEntry,@PathVariable("id") int cacheId){
		return cacheEntryService.insert(cacheEntry, cacheId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{key}")
	public void delete(@PathVariable("key") String cacheKey ,@PathVariable("id") int cacheId){
		cacheEntryService.remove(cacheKey, cacheId);
	}
	
	
}
