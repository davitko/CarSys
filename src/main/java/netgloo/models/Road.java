package netgloo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "road")
public class Road implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7106010082109304435L;
	
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 
	long id;
	@OneToOne
	Node startNode;
	@OneToOne
	Node endNode;
	Integer weight;
	String directionType;
	
	
	
	public Road() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Road(long id) {
		super();
		this.id = id;
	}
	public Road(Node startNode, Node endNode, Integer weight, String directionType) {
		super();
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
		this.directionType = directionType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Node getStartNode() {
		return startNode;
	}
	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}
	public Node getEndNode() {
		return endNode;
	}
	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDirectionType() {
		return directionType;
	}
	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}
	
	
	
}
