package netgloo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import netgloo.models.Road;

@Transactional
public interface RoadRepository extends CrudRepository<Road, Long>{

}
