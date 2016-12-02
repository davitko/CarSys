package netgloo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import netgloo.models.Car;
import netgloo.models.Node;
import netgloo.models.User;

@Transactional
public interface CarRepository extends CrudRepository<Car, Long>{

//	public Car findByregBr(Node reg_br);
//	public Car findBylastNode(Node last_node);
////	public Car findBybrand(String brand);
//	public Car findByPositionNode1(Node positionNode1);
}
