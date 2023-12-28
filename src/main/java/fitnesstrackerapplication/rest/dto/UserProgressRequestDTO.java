package fitnesstrackerapplication.rest.dto;
import fitnesstrackerapplication.core.model.User;
import fitnesstrackerapplication.core.model.UserProgress;

public class UserProgressRequestDTO {
    private String id;
    private String weight;
    private String bodyFatPercentage;

    public UserProgressRequestDTO() {
        // Default constructor
    }

    public UserProgressRequestDTO(String userId, String weight, String bodyFatPercentage) {
        this.id = userId;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public UserProgress toEntity() {
        UserProgress userProgress = new UserProgress();
        User user = new User();
        user.setId(id);

        userProgress.setWeight(weight);
        userProgress.setBodyFatPercentage(bodyFatPercentage);

        return userProgress;
    }


    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
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

