/**
 *
 */
package org.cachegator.web.config;

import java.util.List;

import org.cachegator.beans.ConnectionDetails;
import org.cachegator.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m4ver1k
 * @since  13-Jan-2016
 * 
 */
@RestController
@RequestMapping("/api/config")
public class ConfigEndpoint {
	
	@Autowired
	private ConnectionService connectionService;
	
	@RequestMapping(value="/connection",method=RequestMethod.POST)
	public void addConnection(@RequestBody ConnectionDetails connectionDetails){
		connectionService.addConnection(connectionDetails);
	}
	
	@RequestMapping(value="/connection",method=RequestMethod.PUT)
	public void updateConnection(@RequestBody ConnectionDetails connectionDetails){
		connectionService.updateConnection(connectionDetails);
	}
	
	@RequestMapping(value="/connection",method=RequestMethod.GET)
	public List<ConnectionDetails> getconnections(){
		return connectionService.getAll();
		
	}
	
	@RequestMapping(value="/connection/{id}",method=RequestMethod.GET)
	public ConnectionDetails getconnection(@PathVariable("id") int id){
		return connectionService.get(id);
		
	}
}
