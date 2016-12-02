package netgloo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import netgloo.models.Node;
import netgloo.models.Road;

@Controller
public class FillDataBase {
	
	@Autowired
	NodeServices nodeServices;
	
	 

	public void fillRoads() {
		Node node1 = nodeServices.findOne("Parka Svetog Save", "Roundabout");
		Node node2 = nodeServices.findOne("Parka Svetog Save", "Intersection");
		Road newRoad = new Road(node1, node2, 0, "bidirectional");
		
	}
}
