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
//	Node connectedNode1;
//	Node connectedNode2;
	@ManyToMany(targetEntity=Node.class)
	List<Node> connected;
	
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(long id) {
		super();
		this.id = id;
	}
	
	public Node(String name, Integer xCoordinate, Integer yCoordinate, List<Node> connected) {
		super();
		Name = name;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
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
	
	
}
