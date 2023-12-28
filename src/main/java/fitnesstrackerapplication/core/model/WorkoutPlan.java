package fitnesstrackerapplication.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "plans")
public class WorkoutPlan {
    @Id
    private String id;
    private String name;
    private String numberOfDays;
    private List<Exercise> exercises;

    public WorkoutPlan(String id, String name, String numberOfDays, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.numberOfDays = numberOfDays;
        this.exercises = exercises;
    }

    public WorkoutPlan(){}

    // Constructors, getters, and setters

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
