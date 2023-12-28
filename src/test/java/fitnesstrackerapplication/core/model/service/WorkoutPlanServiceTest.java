package fitnesstrackerapplication.core.model.service;

import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.repository.WorkoutPlanRepository;
import fitnesstrackerapplication.rest.dto.ExerciseRequestDTO;
import fitnesstrackerapplication.rest.dto.WorkoutPlanRequestDTO;
import fitnesstrackerapplication.core.service.WorkoutPlanService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class WorkoutPlanServiceTest {

    @MockBean
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @Test
    public void shouldReturnWorkoutPlanWhenCreated() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId("1");
        workoutPlan.setName("My Plan");
        workoutPlan.setNumberOfDays("7");
        workoutPlan.setExercises(Arrays.asList(new Exercise("1", "Exercise 1", "Description", "Category", "Manufacturer", "VideoUrl")));

        Mockito.when(workoutPlanRepository.save(ArgumentMatchers.any(WorkoutPlan.class))).thenReturn(workoutPlan);

        WorkoutPlan savedWorkoutPlan = workoutPlanService.createWorkoutPlan(new WorkoutPlanRequestDTO(workoutPlan));

        Assertions.assertThat(savedWorkoutPlan.getName()).isEqualTo("My Plan");
        Assertions.assertThat(savedWorkoutPlan.getNumberOfDays()).isEqualTo("7");
        Assertions.assertThat(savedWorkoutPlan.getExercises()).hasSize(1);
        System.out.println(savedWorkoutPlan.getId());
    }

    @Test
    public void shouldReturnWorkoutPlanById() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId("someMongoId");
        workoutPlan.setName("My Plan");
        workoutPlan.setNumberOfDays("7");
        workoutPlan.setExercises(Arrays.asList(new Exercise("1", "Exercise 1", "Description", "Category", "Manufacturer", "VideoUrl")));

        Mockito.when(workoutPlanRepository.findById("someMongoId")).thenReturn(Optional.of(workoutPlan));

        WorkoutPlan foundWorkoutPlan = workoutPlanService.getPlanById("someMongoId");

        Assertions.assertThat(foundWorkoutPlan.getName()).isEqualTo("My Plan");
        Assertions.assertThat(foundWorkoutPlan.getNumberOfDays()).isEqualTo("7");
        Assertions.assertThat(foundWorkoutPlan.getExercises()).hasSize(1);
    }


}
