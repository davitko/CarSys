package netgloo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import netgloo.repository.CarRepository;
import netgloo.models.Car;
import netgloo.models.Node;

@Service
@RequestMapping("/service/car")
public class CarServices {

	@Autowired
	CarRepository carRepository;
	
	public CarServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String regBr, String brand, Node positionNode1, Node positionNode2, Node lastNode) {
		Car car = null;
		try {
			car = new Car(regBr, brand, positionNode1, positionNode2, lastNode);
			carRepository.save(car);
		}
		catch (Exception ex) {
			return "Error creating the new Car: " + ex.toString();
		}
		return "User succesfully created new Car! (id = " + car.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Car car = new Car(id);
			carRepository.delete(car);
		}
		catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateCar(long id, String regBr, String brand, Node positionNode1, Node positionNode2, Node lastNode) {
		try {
			Car car = new Car();
			car = carRepository.findOne(id);
			car.setRegBr(regBr);
			car.setBrand(brand);
			car.setPositionNode1(positionNode1);
			car.setPositionNode2(positionNode2);
			car.setLastNode(lastNode);
			carRepository.save(car);
		}
		catch (Exception ex) {
			return "Error updating the car: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
	public List<Car> findByBrand(String brand) {
		Iterable<Car> allCars = carRepository.findAll();
		List<Car> resultCars = new ArrayList<>();
		
		for (Car itr : allCars) {
			if (itr.getBrand() == brand)
				resultCars.add(itr);
		}
		return resultCars;
	}
}
