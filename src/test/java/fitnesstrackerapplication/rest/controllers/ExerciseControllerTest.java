package fitnesstrackerapplication.rest.controllers;


import com.jayway.jsonpath.JsonPath;
import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.service.ExerciseService;
import fitnesstrackerapplication.core.service.JwtService;
import fitnesstrackerapplication.core.service.UserService;
import fitnesstrackerapplication.rest.configuration.SecurityConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

import java.util.List;

@AutoConfigureMockMvc
@WebMvcTest(ExerciseController.class)
@Import(SecurityConfiguration.class)
public class ExerciseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExerciseService exerciseService;

    @MockBean
    JwtService jwtService;

    @MockBean
    UserService userService;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @Test
    public void shouldReturnAllExercises() throws Exception {
        Exercise exercise = new Exercise();
        exercise.setName("Bench Press");
        exercise.setDescription("description");
        exercise.setCategory("category");
        exercise.setManufacturer("manufacturer");
        exercise.setVideoUrl("videoUrl");

        Mockito.when(exerciseService.getExercise()).thenReturn(List.of(exercise));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/exercise/").header("JWT Security Bearer ", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrZW1hbGxldGljIiwiaWF0IjoxNzAzMDY3MjkyLCJleHAiOjE3MDMwNjg3MzJ9.13lajJYIBbf0ZxMIqrHX9s0a_nGXxJPMbMvbML_f7yc").contentType(MediaType.APPLICATION_JSON)).andReturn();

        String response = result.getResponse().getContentAsString();
        System.out.println(response);

        Assertions.assertEquals("Bench Press", JsonPath.read(response, "$.[0].name"));
        Assertions.assertEquals(1, (Integer) JsonPath.read(response, "$.length()"));





    }
}
