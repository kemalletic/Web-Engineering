package fitnesstrackerapplication.core.service;

import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.repository.ExerciseRepository;
import fitnesstrackerapplication.rest.dto.ExerciseRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;





    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getExercise() {
        List<Exercise> exercise = exerciseRepository.findAll();
        // List<Exercise> users = exerciseRepository.findAllCustom();

        return exercise;

    }

    public Exercise getExerciseByID(String id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        return exercise.get();
    }

    public Exercise addExercise(ExerciseRequestDTO payload) {
        Exercise exercise = exerciseRepository.save(payload.toEntity());
        return exercise;
    }

    public Exercise updateExercise(String id, ExerciseRequestDTO payload) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        Exercise updatedExercise = payload.toEntity();
        updatedExercise.setId(exercise.get().getId());
        updatedExercise = exerciseRepository.save(updatedExercise);
        return updatedExercise;
    }

    public void deleteExercise(String id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        exercise.ifPresent(exerciseRepository::delete);
    }


}


