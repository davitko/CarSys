package netgloo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Node;
import netgloo.models.Road;
import netgloo.repository.RoadRepository;

@Service
@RequestMapping("/service/road")
public class RoadServices {

//	@Autowired
//	Road road;
	@Autowired
	RoadRepository roadRepository;
	
	
	
	public RoadServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create(Node startNode, Node endNode, Integer weight, String directionType) {
		Road road = new Road();
		try {
			road = new Road(startNode, endNode, weight, directionType);
			roadRepository.save(road);
		}
		catch (Exception ex) {
			return "Error creating the new Road: " + ex.toString();
		}
		return "User succesfully created new Rad! (id = " + road.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Road road = new Road(id);
			roadRepository.delete(road);
		}
		catch (Exception ex) {
			return "Error deleting the Road: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, Node startNode, Node endNode, Integer weight, String directionType) {
		try { 
			Road road = new Road();
			road.setStartNode(startNode);
			road.setEndNode(endNode);
			road.setWeight(weight);
			road.setDirectionType(directionType);
			roadRepository.save(road);
		}
		catch (Exception ex) {
			return "Error updating the Road: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
}
