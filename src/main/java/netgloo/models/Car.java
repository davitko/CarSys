package netgloo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3478083415858828505L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String RegBr;
	@NotNull
	public String Brand;
	@OneToOne
	Node positionNode1;
	@OneToOne
	Node positionNode2;
	@OneToOne
	Node lastNode;
	
	
	public Car() {
		super();
	}
	public Car(long id) {
		super();
		this.id = id;
	}
	public Car(String regBr, String brand, Node positionNode1, Node positionNode2, Node lastNode) {
		super();
		RegBr = regBr;
		Brand = brand;
		this.positionNode1 = positionNode1;
		this.positionNode2 = positionNode2;
		this.lastNode = lastNode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRegBr() {
		return RegBr;
	}
	public void setRegBr(String regBr) {
		RegBr = regBr;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public Node getPositionNode1() {
		return positionNode1;
	}
	public void setPositionNode1(Node positionNode1) {
		this.positionNode1 = positionNode1;
	}
	public Node getPositionNode2() {
		return positionNode2;
	}
	public void setPositionNode2(Node positionNode2) {
		this.positionNode2 = positionNode2;
	}
	public Node getLastNode() {
		return lastNode;
	}
	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}
	
	
	
	

}
