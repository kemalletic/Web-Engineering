package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.Machines;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachinesRepository extends MongoRepository<Machines, String> {
}
