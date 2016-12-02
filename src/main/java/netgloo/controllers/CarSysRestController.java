package netgloo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import netgloo.models.Car;
import netgloo.models.Node;
import netgloo.services.NodeServices;

@RestController
@RequestMapping("/carSys")
public class CarSysRestController {
	
	@Autowired
	NodeServices nodeServices;
	
	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public ResponseEntity<Collection<Node>> recommendedNodes(){
		
		
		
		
		return new ResponseEntity<>((Collection<Node>) nodeServices.findAll(), HttpStatus.OK);
	}

}
