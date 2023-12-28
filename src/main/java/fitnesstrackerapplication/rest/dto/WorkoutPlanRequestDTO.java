package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.Exercise;
import fitnesstrackerapplication.core.model.WorkoutPlan;

import java.util.List;

public class WorkoutPlanRequestDTO {
    private String id;
    private String name;
    private String numberOfDays;
    private List<Exercise> exercises;

    public WorkoutPlanRequestDTO() {}

    public WorkoutPlanRequestDTO(WorkoutPlan workoutPlan) {
        this.id = workoutPlan.getId();
        this.name = workoutPlan.getName();
        this.numberOfDays = workoutPlan.getNumberOfDays();
        this.exercises = workoutPlan.getExercises();
    }

    public WorkoutPlan toEntity() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId(id);
        workoutPlan.setName(name);
        workoutPlan.setNumberOfDays(numberOfDays);
        workoutPlan.setExercises(exercises);
        return workoutPlan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}