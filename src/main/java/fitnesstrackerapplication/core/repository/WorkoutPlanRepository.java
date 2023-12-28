package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, String> {
    //nothing for now

    Optional<WorkoutPlan> findByName(String name);
}
