package netgloo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import netgloo.models.Car;
import netgloo.models.Node;
import netgloo.services.CarServices;
import netgloo.services.NodeServices;

@RestController
@RequestMapping("/carSys")
public class CarSysRestController {
	
	@Autowired
	NodeServices nodeServices;
	@Autowired
	CarServices carServices;
	
//	@RequestMapping(method = RequestMethod.GET, value = "/info")
//	public ResponseEntity<Collection<Node>> recommendedNodes(){
//		
//		
//		
//		
//		return new ResponseEntity<>((Collection<Node>) nodeServices.findAll(), HttpStatus.OK);
//	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/logIn")
	public ResponseEntity<?> carOnSystem(@RequestBody String regBr, String brand) {
		if (carServices.isRegistered(regBr)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			carServices.carRegistration(regBr, brand);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/startNavigation")
	public ResponseEntity<Collection<Node>> recommendedNodes(@RequestBody String regBr, String startNode1, String startNode1Type, Long distanceNode1, String startNode2, String startNode2Type, Long distanceNode2, String desiredObject) {
//		Node startN1 = new Node();
		Node startN = nodeServices.findOne(startNode1, startNode1Type);
		Node endN = nodeServices.findOne(startNode2, startNode2Type);
		
		Car inputCar = carServices.findOne(regBr);
		carServices.updateCar(inputCar.getId(), inputCar.getRegBr(), inputCar.getBrand(), startN, endN, null);
		
		
		
		return new ResponseEntity<>((Collection<Node>) nodeServices.findAll(), HttpStatus.OK);
	}

}
