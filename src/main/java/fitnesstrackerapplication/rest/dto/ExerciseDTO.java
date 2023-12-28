package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.Exercise;

public class ExerciseDTO {

    private String id;
    private String name;
    private String description;
    private String category;
    private String manufacturer;
    private String videoUrl;


    public ExerciseDTO(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.description = exercise.getDescription();
        this.category = exercise.getCategory();
        this.manufacturer = exercise.getManufacturer();
        this.videoUrl = exercise.getVideoUrl();
    }

    public ExerciseDTO() {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
