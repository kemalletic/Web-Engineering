package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.WorkoutType;

public class WorkoutTypeRequestDTO {
    private String name;
    private String description;
    private String category;
    private String notes;

    public WorkoutTypeRequestDTO() {
        // Default constructor
    }

    public WorkoutTypeRequestDTO(WorkoutType workoutType) {
        this.name = workoutType.getName();
        this.description = workoutType.getDescription();
        this.category = workoutType.getCategory();
        this.notes = workoutType.getNotes();
    }

    public WorkoutType toEntity() {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setName(name);
        workoutType.setDescription(description);
        workoutType.setCategory(category);
        workoutType.setNotes(notes);
        return workoutType;
    }

    // Getters and setters for all properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
