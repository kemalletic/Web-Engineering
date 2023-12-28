package fitnesstrackerapplication.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class UserProgress {
    @Id
    private String id;

    private String weight;
    private String bodyFatPercentage;


    public UserProgress(String id, String weight, String bodyFatPercentage) {
        this.id = id;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;

    }

    public UserProgress(){}

    // Constructors, getters, and setters

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
