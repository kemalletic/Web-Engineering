package fitnesstrackerapplication.rest.controllers;


import com.jayway.jsonpath.JsonPath;
import fitnesstrackerapplication.core.model.WorkoutType;
import fitnesstrackerapplication.core.service.JwtService;
import fitnesstrackerapplication.core.service.UserService;
import fitnesstrackerapplication.core.service.WorkoutTypeService;
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

import java.util.List;

@AutoConfigureMockMvc
@WebMvcTest(WorkoutTypeController.class)
@Import(SecurityConfiguration.class)
public class WorkoutTypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WorkoutTypeService workoutTypeService;

    @MockBean
    JwtService jwtService;

    @MockBean
    UserService userService;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @Test
    void shouldReturnAllWorkoutTypes() throws Exception {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setId("1");
        workoutType.setName("My Type");
        workoutType.setCategory("Category");
        workoutType.setNotes("Notes");

        Mockito.when(workoutTypeService.getAllWorkoutTypes()).thenReturn(List.of(workoutType));

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/workouttypes/")
                        .header("JWT Security Bearer ", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrZW1hbGxldGljIiwiaWF0IjoxNzAzMDY3MjkyLCJleHAiOjE3MDMwNjg3MzJ9.13lajJYIBbf0ZxMIqrHX9s0a_nGXxJPMbMvbML_f7yc")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andReturn();

        String response = result.getResponse().getContentAsString();


        Assertions.assertEquals(1, (Integer) JsonPath.read(response, "$.length()"));
        Assertions.assertEquals("My Type", JsonPath.read(response, "$.[0].name"));


        System.out.println(response);
    }


}
