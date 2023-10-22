package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.model.Workout;
import fitnesstrackerapplication.core.service.WorkoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> findAll() {
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public Workout findById(@PathVariable String id) {
        return workoutService.findById(id);
    }
}
