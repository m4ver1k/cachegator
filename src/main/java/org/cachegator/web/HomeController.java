package org.cachegator.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m4ver1k
 * @since  06-Dec-2015
 */
@RestController
@RequestMapping("/api")
public class HomeController {
	@RequestMapping("/home")
	public Map<String, Object> getData(){
		Map<String, Object> model = new HashMap<>();
		model.put("Name", "Gator");
		model.put("Version", "0.1");
		return model;
	}
}
