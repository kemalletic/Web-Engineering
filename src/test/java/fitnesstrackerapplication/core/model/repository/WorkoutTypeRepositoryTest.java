package fitnesstrackerapplication.core.model.repository;

import fitnesstrackerapplication.core.model.WorkoutType;
import fitnesstrackerapplication.core.repository.WorkoutTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WorkoutTypeRepositoryTest {

    @Autowired
    private WorkoutTypeRepository workoutTypeRepository;

    @Test
    public void shouldReturnAllWorkoutTypes() {
        List<WorkoutType> workoutTypes = workoutTypeRepository.findAll();

        Assertions.assertEquals(1, workoutTypes.size());
        Assertions.assertEquals("Mass", workoutTypes.get(0).getCategory());
    }

    @Test
    public void shouldFindWorkoutTypeByTitle() {
        Optional<WorkoutType> workoutType = workoutTypeRepository.findByCategory("Mass");
        Assertions.assertNotNull(workoutType.orElse(null));
    }
}
