package netgloo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Object;
import netgloo.repository.ObjectRepository;

@Service
@RequestMapping("/service/object")
public class ObjectServices {

	@Autowired
	ObjectRepository objectRepository;
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, Long distanceFromNode1, Long distanceFromNode2) {
		Object object = new Object();
		try {
			object = new Object(name, distanceFromNode1, distanceFromNode2);
			objectRepository.save(object);
		}
		catch (Exception ex) {
			return "Error creating the new Object: " + ex.toString();
		}
		return "User succesfully created new Object! (id = " + object.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Object object = new Object(id);
			objectRepository.delete(object);
		}
		catch (Exception ex) {
			return "Error deleting the Object: " + ex.toString();
		}
		return "Object succesfully deleted!";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String name, Long distanceFromNode1, Long distanceFromNode2) {
		try {
			Object object = new Object();
			object.setName(name);
			object.setDistanceFromNode1(distanceFromNode1);
			object.setDistanceFromNode2(distanceFromNode2);
			objectRepository.save(object);
		}
		catch (Exception ex) {
			return "Error updating the Object: " + ex.toString();
		}
		return "User succesfully updated!";
	}
}
