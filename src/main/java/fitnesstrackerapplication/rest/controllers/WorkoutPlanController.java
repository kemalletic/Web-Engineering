package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.service.WorkoutPlanService;
import fitnesstrackerapplication.rest.dto.WorkoutPlanRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutPlans/")
@SecurityRequirement(name = "JWT Security")
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<WorkoutPlan>> getAllPlans() {
        return ResponseEntity.ok(workoutPlanService.getAllPlans());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<WorkoutPlan> getPlanByID(@PathVariable String id) {
        return ResponseEntity.ok(workoutPlanService.getPlanById(id));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@RequestBody WorkoutPlanRequestDTO plan) {
        return ResponseEntity.ok(workoutPlanService.createWorkoutPlan(plan));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<WorkoutPlan> updateWorkoutPlan(@PathVariable String id, @RequestBody WorkoutPlanRequestDTO plan) {
        return ResponseEntity.ok(workoutPlanService.updateWorkoutPlan(id, plan));
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable String id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}