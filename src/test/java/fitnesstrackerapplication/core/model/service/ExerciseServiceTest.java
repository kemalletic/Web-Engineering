package fitnesstrackerapplication.core.model.service;

import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.repository.ExerciseRepository;
import fitnesstrackerapplication.core.service.ExerciseService;
import fitnesstrackerapplication.rest.dto.ExerciseRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class ExerciseServiceTest {

    @MockBean
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseService exerciseService;

    @Test
    public void shouldReturnExerciseWhenCreated() {
        Exercise exercise = new Exercise();
        exercise.setName("Bench Press");
        exercise.setDescription("description");
        exercise.setCategory("category");
        exercise.setManufacturer("manufacturer");
        exercise.setVideoUrl("videoUrl");

        Mockito.when(exerciseRepository.save(ArgumentMatchers.any(Exercise.class))).thenReturn(exercise);

        Exercise savedExercise = exerciseService.addExercise(new ExerciseRequestDTO(exercise));

        Assertions.assertThat(exercise.getName()).isEqualTo(savedExercise.getName());
        Assertions.assertThat(exercise.getDescription()).isEqualTo(savedExercise.getDescription());
        Assertions.assertThat(exercise.getCategory()).isEqualTo(savedExercise.getCategory());
    }

    @Test
    public void shouldReturnExerciseById() {
        Exercise exercise = new Exercise();
        exercise.setName("Bench Press");
        exercise.setDescription("description");
        exercise.setCategory("category");
        exercise.setManufacturer("manufacturer");
        exercise.setVideoUrl("videoUrl");

        Mockito.when(exerciseRepository.findById("someMongoId")).thenReturn(Optional.of(exercise));

        Exercise foundExercise = exerciseService.getExerciseByID("someMongoId");

        Assertions.assertThat(foundExercise.getName()).isEqualTo("Bench Press");
        Assertions.assertThat(foundExercise.getDescription()).isEqualTo("description");
        Assertions.assertThat(foundExercise.getCategory()).isEqualTo("category");
        Assertions.assertThat(foundExercise.getManufacturer()).isEqualTo("manufacturer");
        Assertions.assertThat(foundExercise.getVideoUrl()).isEqualTo("videoUrl");
    }


}
