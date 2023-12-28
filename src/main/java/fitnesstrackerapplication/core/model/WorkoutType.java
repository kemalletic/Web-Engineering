package fitnesstrackerapplication.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkoutType {
    @Id
    private String id;
    private String name; // Name of the workout

    private String description; // Description of the workout
    private String category; // Category of the workout (e.g., cardio, strength)
    private String notes; // Any additional notes

    public WorkoutType(String id, String name, String description, String category, String notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.notes = notes;
    }

    public WorkoutType(){}




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
