package fitnesstrackerapplication;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FitnessTrackerApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);


        String[] actual = {"Hello", "JUnit"};
        String[] expected = {"Hello", "JUnit"};
        assertArrayEquals(actual, expected);

        assertTrue(2 > 1);
        assertFalse(2 > 3);

        WorkoutPlan b = null;
        assertNull(b);

        b = new WorkoutPlan();
        assertNotNull(b);

        int[] array = {1, 2, 3};
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            int i = array[3];
        });
        assertEquals("Index 3 out of bounds for length 3", e.getMessage());
    }

}
