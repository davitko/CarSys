package netgloo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import netgloo.models.NodeType;

@Transactional
public interface NodeTypeRepository extends CrudRepository<NodeType, Long> {

}
