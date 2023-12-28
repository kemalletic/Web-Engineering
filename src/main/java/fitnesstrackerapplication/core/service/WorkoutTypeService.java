// WorkoutService.java

package fitnesstrackerapplication.core.service;

import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.WorkoutType;
import fitnesstrackerapplication.core.repository.WorkoutTypeRepository;
import fitnesstrackerapplication.rest.dto.WorkoutTypeRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutTypeService {
    private final WorkoutTypeRepository workoutTypeRepository;

    public WorkoutTypeService(WorkoutTypeRepository workoutTypeRepository) {
        this.workoutTypeRepository = workoutTypeRepository;
    }

    public List<WorkoutType> getAllWorkoutTypes() {
        return workoutTypeRepository.findAll();
    }

    public WorkoutType getWorkoutTypeById(String id) {
        Optional<WorkoutType> optionalWorkout = workoutTypeRepository.findById(id);
        if (optionalWorkout.isEmpty()) {
            throw new ResourceNotFoundException("Workout with the given ID does not exist.");
        }
        return optionalWorkout.get();
    }

    public WorkoutType createWorkoutType(WorkoutTypeRequestDTO workoutRequest) {
        WorkoutType workoutType = workoutTypeRepository.save(workoutRequest.toEntity());
        return workoutType;
    }

    public WorkoutType updateWorkout(String id, WorkoutTypeRequestDTO workoutRequest) {
        Optional<WorkoutType> optionalWorkout = workoutTypeRepository.findById(id);
        if (optionalWorkout.isEmpty()) {
            throw new ResourceNotFoundException("Workout with the given ID does not exist.");
        }
        WorkoutType existingWorkoutType = optionalWorkout.get();
        WorkoutType updatedWorkoutType = workoutRequest.toEntity();
        updatedWorkoutType.setId(existingWorkoutType.getId());
        updatedWorkoutType = workoutTypeRepository.save(updatedWorkoutType);
        return updatedWorkoutType;
    }

    public void deleteWorkoutType(String id) {
        Optional<WorkoutType> optionalWorkout = workoutTypeRepository.findById(id);
        optionalWorkout.ifPresent(workoutTypeRepository::delete);
    }
}
