package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "node_type")
public class NodeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String Name;
	public NodeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NodeType(String name) {
		super();
		Name = name;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	

}
