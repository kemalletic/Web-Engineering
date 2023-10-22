package fitnesstrackerapplication.core.repository;



//import fitnesstrackerapplication.core.model.enums.Workout;
import fitnesstrackerapplication.core.model.Workout;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class WorkoutRepository {
    private List<Workout> workouts;



    public List<Workout> findAll() {
        return workouts;
    }

    public Workout findById(String id) {
        return workouts.stream().filter(workout -> workout.getId() == id).findFirst().orElse(null);
    }
}