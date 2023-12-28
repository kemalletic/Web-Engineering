package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.Exercise;

public class ExerciseRequestDTO {

    private String name;
    private String description;
    private String category;
    private String manufacturer;
    private String videoUrl;
    public ExerciseRequestDTO(Exercise exercise) {
        this.name = exercise.getName();
        this.description = exercise.getDescription();
        this.category = exercise.getCategory();
        this.manufacturer = exercise.getManufacturer();
        this.videoUrl = exercise.getVideoUrl();
    }

    public ExerciseRequestDTO(){}
    public Exercise toEntity(){
        Exercise exercise =new Exercise();
        exercise.setName(name);
        exercise.setDescription(description);
        exercise.setCategory(category);
        exercise.setManufacturer(manufacturer);
        exercise.setVideoUrl(videoUrl);
        return exercise;
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

