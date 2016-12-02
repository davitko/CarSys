package netgloo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import netgloo.models.Object;

@Transactional
public interface ObjectRepository extends CrudRepository<Object, Long>{

}
