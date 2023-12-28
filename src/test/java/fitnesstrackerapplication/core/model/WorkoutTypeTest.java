package fitnesstrackerapplication.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkoutTypeTest {

    @Test
    void shouldCreateNewWorkoutType() {
        WorkoutType workoutType = new WorkoutType(
                "someId",
                "WorkoutName",
                "WorkoutDescription",
                "WorkoutCategory",
                "WorkoutNotes"
        );

        Assertions.assertEquals("WorkoutName", workoutType.getName());
        Assertions.assertEquals("WorkoutCategory", workoutType.getCategory());

    }

    @Test
    void shouldUpdateWorkoutType() {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setName("NewWorkoutType");
        Assertions.assertEquals("NewWorkoutType", workoutType.getName());
    }

    @Test
    void shouldCompareTwoWorkoutTypes() {
        WorkoutType workoutType1 = new WorkoutType(
                "someId",
                "WorkoutName",
                "WorkoutDescription",
                "WorkoutCategory",
                "WorkoutNotes"
        );

        WorkoutType workoutType2 = new WorkoutType(
                "someId",
                "WorkoutName",
                "WorkoutDescription",
                "WorkoutCategory",
                "WorkoutNotes"
        );

        AssertionsForInterfaceTypes.assertThat(workoutType1).usingRecursiveComparison().isEqualTo(workoutType2);
    }
}
