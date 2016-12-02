package netgloo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "object")
public class Object implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3681419487480460951L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String Name;
	Long distanceFromNode1;
	Long distanceFromNode2;
	
	
	public Object() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Object(long id) {
		super();
		this.id = id;
	}
	public Object(String name, Long distanceFromNode1, Long distanceFromNode2) {
		super();
		Name = name;
		this.distanceFromNode1 = distanceFromNode1;
		this.distanceFromNode2 = distanceFromNode2;
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
	public Long getDistanceFromNode1() {
		return distanceFromNode1;
	}
	public void setDistanceFromNode1(Long distanceFromNode1) {
		this.distanceFromNode1 = distanceFromNode1;
	}
	public Long getDistanceFromNode2() {
		return distanceFromNode2;
	}
	public void setDistanceFromNode2(Long distanceFromNode2) {
		this.distanceFromNode2 = distanceFromNode2;
	}

}
