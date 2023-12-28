package fitnesstrackerapplication.rest.controllers;

import com.jayway.jsonpath.JsonPath;
import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.service.JwtService;
import fitnesstrackerapplication.core.service.UserService;
import fitnesstrackerapplication.core.service.WorkoutPlanService;
import fitnesstrackerapplication.rest.configuration.SecurityConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@AutoConfigureMockMvc
@WebMvcTest(WorkoutPlanController.class)
@Import(SecurityConfiguration.class)
public class WorkoutPlanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WorkoutPlanService workoutPlanService;

    @MockBean
    JwtService jwtService;

    @MockBean
    UserService userService;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @Test
    void shouldReturnAllWorkoutPlans() throws Exception {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId("001");
        workoutPlan.setName("PushPullLegs");
        workoutPlan.setNumberOfDays("7");
        workoutPlan.setExercises(Arrays.asList(new Exercise("1", "Exercise 1", "Description", "Category", "Manufacturer", "VideoUrl")));

        Mockito.when(workoutPlanService.getAllPlans()).thenReturn(List.of(workoutPlan));

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/workoutPlans/")
                        .header("JWT Security Bearer ", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrZW1hbGxldGljIiwiaWF0IjoxNzAzMDY3MjkyLCJleHAiOjE3MDMwNjg3MzJ9.13lajJYIBbf0ZxMIqrHX9s0a_nGXxJPMbMvbML_f7yc")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andReturn();


        String response = result.getResponse().getContentAsString();


        Assertions.assertEquals(1, (Integer) JsonPath.read(response, "$.length()"));
        Assertions.assertEquals("PushPullLegs", JsonPath.read(response, "$.[0].name"));
        System.out.println(response);


    }
}



