package fitnesstrackerapplication.core.model.service;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.model.WorkoutType;
import fitnesstrackerapplication.core.repository.WorkoutTypeRepository;
import fitnesstrackerapplication.core.service.WorkoutTypeService;
import fitnesstrackerapplication.rest.dto.WorkoutTypeRequestDTO;
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
public class WorkoutTypeServiceTest {
    @MockBean
    private WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    private WorkoutTypeService workoutTypeService;

    @Test
    public void shouldReturnWorkoutTypeWhenCreated() {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setId("1");
        workoutType.setName("My Type");
        workoutType.setDescription("This is Description");
        workoutType.setCategory("Category");
        workoutType.setNotes("Notes");

        Mockito.when(workoutTypeRepository.save(ArgumentMatchers.any(WorkoutType.class))).thenReturn(workoutType);

        WorkoutType savedWorkoutType = workoutTypeService.createWorkoutType(new WorkoutTypeRequestDTO(workoutType));

        Assertions.assertThat(savedWorkoutType.getName()).isEqualTo("My Type");
        Assertions.assertThat(savedWorkoutType.getDescription()).isEqualTo("This is Description");
        Assertions.assertThat(savedWorkoutType.getCategory()).isEqualTo("Category");
        Assertions.assertThat(savedWorkoutType.getNotes()).isEqualTo("Notes");

        System.out.println(savedWorkoutType.getId());
    }

    @Test
    public void shouldReturnWorkoutTypeById() {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setId("someMongoId");
        workoutType.setName("My Type");
        workoutType.setDescription("Description");

        Mockito.when(workoutTypeRepository.findById("someMongoId")).thenReturn(Optional.of(workoutType));

        WorkoutType foundWorkoutType = workoutTypeService.getWorkoutTypeById("someMongoId");

        Assertions.assertThat(foundWorkoutType.getName()).isEqualTo("My Type");
        Assertions.assertThat(foundWorkoutType.getDescription()).isEqualTo("Description");


    }
}
