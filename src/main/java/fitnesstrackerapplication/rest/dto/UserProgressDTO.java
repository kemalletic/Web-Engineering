package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.UserProgress;

public class UserProgressDTO {

    private String id;
    private String weight;
    private String bodyFatPercentage;

    public UserProgressDTO(UserProgress userProgress) {
        this.id = userProgress.getId();
        this.weight = userProgress.getWeight();
        this.bodyFatPercentage = userProgress.getBodyFatPercentage();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(String bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }
}
