package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.model.WorkoutType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkoutTypeRepository extends MongoRepository<WorkoutType, String> {
    // You can add custom query methods if needed

    Optional<WorkoutType> findByCategory(String category);
}
