package fitnesstrackerapplication.core.model;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


import java.util.ArrayList;
import java.util.Date;

public class ExerciseTest {

    @Test
    void shouldCreateNewExercise() {
        Exercise exercise = new Exercise(
                "someId",
                "Bench",
                "Bench Press",
                "Mass",
                "Fitness",
                "videoUrl"
        );

        Assertions.assertEquals("Bench", exercise.getName());
        Assertions.assertEquals("Bench Press", exercise.getDescription());
    }

    @Test
    void shouldUpdateExercise() {
        Exercise exercise = new Exercise();
        exercise.setName("New Exercise");
        Assertions.assertEquals("New Exercise", exercise.getName());
    }

    @Test
    void shouldCompareTwoExercises() {
        Exercise exercise1 = new Exercise(
                "someId",
                "Bench",
                "Bench Press",
                "Mass",
                "Fitness",
                "videoUrl"
        );

        Exercise exercise2 = new Exercise(
                "someId",
                "Bench",
                "Bench Press",
                "Mass",
                "Fitness",
                "videoUrl"
        );
        AssertionsForInterfaceTypes
                .assertThat(exercise1)
                .usingRecursiveComparison()
                .isEqualTo(exercise2);
    }
}