package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.model.WorkoutPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    Optional<Exercise> findByName(String name);
}
