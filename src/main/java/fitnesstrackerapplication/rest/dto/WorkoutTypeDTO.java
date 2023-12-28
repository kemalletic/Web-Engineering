package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.WorkoutType;

public class WorkoutTypeDTO {
    private String id;
    private String name;
    private String description;
    private String category;
    private String notes;

    public WorkoutTypeDTO(WorkoutType workoutType) {
        this.id = workoutType.getId();
        this.name = workoutType.getName();
        this.description = workoutType.getDescription();
        this.category = workoutType.getCategory();
        this.notes = workoutType.getNotes();
    }

    // Getters and setters for all properties

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
