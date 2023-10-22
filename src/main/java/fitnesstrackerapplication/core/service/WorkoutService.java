package fitnesstrackerapplication.core.service;

//import fitnesstrackerapplication.core.model.enums.Workout;
import fitnesstrackerapplication.core.model.Workout;
import fitnesstrackerapplication.core.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;


    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout findById(String id) {
        return workoutRepository.findById(id);
    }
}
