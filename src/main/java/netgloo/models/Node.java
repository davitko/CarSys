package netgloo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "node")
public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -796884698615643293L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String Name;
	Integer xCoordinate;
	Integer yCoordinate;
	@OneToOne
	NodeType nodeType;
//	@OneToOne
//	Integer nodeTypeID;
//	Node connectedNode1;
//	Node connectedNode2;
	@ManyToMany(targetEntity=Node.class)
	@JsonIgnore
	List<Node> connected;
//	@ManyToMany(targetEntity=Node.class)
//	List<Integer> connected;
	
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(long id) {
		super();
		this.id = id;
	}
	
	
	
	public Node(String name, Integer xCoordinate, Integer yCoordinate, NodeType nodeType, List<Node> connected) {
		super();
		Name = name;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.nodeType = nodeType;
		this.connected = connected;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public Integer getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public List<Node> getConnected() {
		return connected;
	}
	public void setConnected(List<Node> connected) {
		this.connected = connected;
	}
	public NodeType getNodeType() {
		return nodeType;
	}
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}
	
//	public Integer getNodeTypeID() {
//		return nodeTypeID;
//	}
//	public void setNodeTypeID(Integer nodeTypeID) {
//		this.nodeTypeID = nodeTypeID;
//	}
	
	
	
	
}
