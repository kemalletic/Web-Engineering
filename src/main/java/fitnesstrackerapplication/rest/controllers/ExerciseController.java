package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.service.ExerciseService;
import fitnesstrackerapplication.rest.dto.ExerciseRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exercise")
@SecurityRequirement(name = "JWT Security")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    //@PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<List<Exercise>> getExercise() {
        return ResponseEntity.ok(exerciseService.getExercise());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Exercise> getExerciseByID(@PathVariable String id) {
        return ResponseEntity.ok(exerciseService.getExerciseByID(id));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<Exercise> addExercise(@RequestBody ExerciseRequestDTO exercise) {
        return ResponseEntity.ok(exerciseService.addExercise(exercise));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Exercise> updateExercise(@PathVariable String id, @RequestBody ExerciseRequestDTO exercise) {
        return ResponseEntity.ok(exerciseService.updateExercise(id, exercise));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
