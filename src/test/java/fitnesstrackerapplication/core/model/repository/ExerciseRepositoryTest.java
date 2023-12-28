package fitnesstrackerapplication.core.model.repository;

import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.repository.ExerciseRepository;
import fitnesstrackerapplication.core.repository.ExerciseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ExerciseRepositoryTest {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Test
    public void shouldReturnAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();

        Assertions.assertEquals(1, exercises.size());
        Assertions.assertEquals("Bench Press", exercises.get(0).getName());
    }

    @Test
    public void shouldFindExerciseByName() {
        Optional<Exercise> exercise = exerciseRepository.findByName("Bench Press");
        Assertions.assertNotNull(exercise.orElse(null));
        Assertions.assertEquals("Bench Press", exercise.get().getName());
    }



}

