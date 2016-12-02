package netgloo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.repository.NodeRepository;
import netgloo.com.java.Array.ArrayFn;
import netgloo.models.*;

@Service
@RequestMapping("/service/node")
public class NodeServices {
	
	@Autowired
	NodeRepository nodeRepository;
	@Autowired
	ArrayFn arrayFn;
//	@Autowired
//	Node node;
	
	

	public NodeServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@RequestMapping("/findAll")
//	@ResponseBody
//	public List<Node> findAll() {
//		List<Node> listOfNode = new ArrayList<Node>();
//		Iterable<Node> itNode = nodeRepository.findAll();
//		itNode.forEach(listOfNode::add);
//		return listOfNode;
//	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Node> findAll() {
		List<Node> listOfNode = new ArrayList<Node>();
		listOfNode = arrayFn.IterableToList(nodeRepository.findAll());
		return listOfNode;
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, Integer xCoordinate, Integer yCoordinate, NodeType nodeType, List<Node> connected) {
		Node node = new Node();
		try {
			node = new Node(name, xCoordinate, yCoordinate, nodeType, connected);
			nodeRepository.save(node);
		}
		catch (Exception ex) {
			return "Error creating the new Node: " + ex.toString();
		}
		return "User succesfully created new Node! (id = " + node.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Node node = new Node(id);
			nodeRepository.delete(node);
		}
		catch (Exception ex) {
			return "Error deleting the Node: " + ex.toString();
		}
		return "Node succesfully deleted!";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String name, Integer xCoordinate, Integer yCoordinate) {
		try {
			Node node = nodeRepository.findOne(id);
			node.setName(name);
			node.setxCoordinate(xCoordinate);
			node.setyCoordinate(yCoordinate);
		
			nodeRepository.save(node);
		}
		catch (Exception ex) {
			return "Error updating the Node: " + ex.toString();
		}
		return "Node succesfully updated!";
	}
	
}
