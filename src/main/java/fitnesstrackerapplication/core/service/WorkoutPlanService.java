package fitnesstrackerapplication.core.service;

import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.WorkoutPlan;
import fitnesstrackerapplication.core.repository.WorkoutPlanRepository;
import fitnesstrackerapplication.rest.dto.WorkoutPlanRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    public List<WorkoutPlan> getAllPlans() {
        return workoutPlanRepository.findAll();
    }

    public WorkoutPlan getPlanById(String id) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findById(id);
        if (workoutPlan.isEmpty()) {
            throw new ResourceNotFoundException("Workout plan with the given ID does not exist.");
        }
        return workoutPlan.get();
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlanRequestDTO plan) {
        WorkoutPlan workoutPlan = plan.toEntity();
        return workoutPlanRepository.save(workoutPlan);
    }

    public WorkoutPlan updateWorkoutPlan(String id, WorkoutPlanRequestDTO plan) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findById(id);
        if (workoutPlan.isEmpty()) {
            throw new ResourceNotFoundException("Training plan with the given ID does not exist.");
        }
        WorkoutPlan updatedPlan = plan.toEntity();
        updatedPlan.setId(workoutPlan.get().getId());
        return workoutPlanRepository.save(updatedPlan);
    }

    public void deleteWorkoutPlan(String id) {
        workoutPlanRepository.deleteById(id);
    }
}