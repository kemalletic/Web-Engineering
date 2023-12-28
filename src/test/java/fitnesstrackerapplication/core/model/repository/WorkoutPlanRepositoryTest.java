package fitnesstrackerapplication.core.model.repository;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.repository.WorkoutPlanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WorkoutPlanRepositoryTest {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Test
    public void shouldReturnAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();

        Assertions.assertEquals(1, workoutPlans.size());
        Assertions.assertEquals("PushPullLegs", workoutPlans.get(0).getName());
    }

    @Test
    public void shouldFindWorkoutPlanByTitle() {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findByName("PushPullLegs");
        Assertions.assertNotNull(workoutPlan.orElse(null));
    } 


}
