package netgloo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import netgloo.repository.CarRepository;
import netgloo.services.CarServices;
import netgloo.models.Car;
import netgloo.models.Node;

@RestController
@RequestMapping("/car")
public class CarRestController {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CarServices carServices;
	//	@Autowired
	//	Car car;



	public CarRestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Car>> getAllCars(){
		return new ResponseEntity<>((Collection<Car>) carRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Car> getCarWithId(@PathVariable Long id) {
		return new ResponseEntity<>(carRepository.findOne(id),HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = {"brand"})
	public ResponseEntity<Collection<Car>> findCarByBrand(@RequestParam(value="brand") String Brand) {
		return new ResponseEntity<>((Collection<Car>)carServices.findByBrand(Brand), HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.GET, params = {"lastNode"})
//	public ResponseEntity<Collection<Car>> findCarWithLastNode(@RequestParam(value="lastNode") Node lastNode) {
//		return new ResponseEntity<>((Collection<Car>)carRepository.findBylastNode(lastNode), HttpStatus.OK);
//	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addCar(@RequestBody Car input) {
		return new ResponseEntity<>(carRepository.save(input), HttpStatus.CREATED);
	}


}
