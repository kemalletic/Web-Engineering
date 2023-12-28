package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.model.WorkoutType;
import fitnesstrackerapplication.core.service.WorkoutTypeService;
import fitnesstrackerapplication.rest.dto.WorkoutTypeRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workouttypes")
@SecurityRequirement(name = "JWT Security")
public class WorkoutTypeController {

    private final WorkoutTypeService workoutTypeService;

    public WorkoutTypeController(WorkoutTypeService workoutTypeService) {
        this.workoutTypeService = workoutTypeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<WorkoutType>> getAllWorkoutTypes() {
        return ResponseEntity.ok(workoutTypeService.getAllWorkoutTypes());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<WorkoutType> getWorkoutTypeById(@PathVariable String id) {
        return ResponseEntity.ok(workoutTypeService.getWorkoutTypeById(id));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<WorkoutType> createWorkoutType(@RequestBody WorkoutTypeRequestDTO workoutTypeRequest) {
        return ResponseEntity.ok(workoutTypeService.createWorkoutType(workoutTypeRequest));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<WorkoutType> updateWorkoutType(@PathVariable String id, @RequestBody WorkoutTypeRequestDTO workoutTypeRequest) {
        return ResponseEntity.ok(workoutTypeService.updateWorkout(id, workoutTypeRequest));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteWorkoutType(@PathVariable String id) {
        workoutTypeService.deleteWorkoutType(id);
        return ResponseEntity.noContent().build();
    }
}
