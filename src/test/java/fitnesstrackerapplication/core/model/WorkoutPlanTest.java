package fitnesstrackerapplication.core.model;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


import java.util.ArrayList;
import java.util.Date;

public class WorkoutPlanTest {

    @Test
    void shouldCreateNewWorkoutPlan() {
        Exercise exercise = new Exercise();
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(exercise);


        WorkoutPlan workoutPlan = new WorkoutPlan(
                "someId",
                "testWorkoutPlan",
                "some number of days",
                exercises

        );

        Assertions.assertEquals("someId", workoutPlan.getId());
        Assertions.assertEquals("testWorkoutPlan", workoutPlan.getName());
        Assertions.assertEquals("some number of days", workoutPlan.getNumberOfDays());


    }

    @Test
    void shouldCompareTwoWorkoutPlans() {
        Exercise exercise = new Exercise();
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(exercise);

        WorkoutPlan workoutPlan1 = new WorkoutPlan(
              "someId",
              "testWorkoutPlan",
              "some number of days",
              exercises
        );

        WorkoutPlan workoutPlan2 = new WorkoutPlan(
                "someId",
                "testWorkoutPlan",
                "some number of days",
                exercises
        );

        AssertionsForInterfaceTypes.assertThat(workoutPlan1).usingRecursiveComparison().isEqualTo(workoutPlan2);
    }

}
