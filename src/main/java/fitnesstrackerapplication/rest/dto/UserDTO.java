package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.User;
import fitnesstrackerapplication.core.model.enums.UserType;

public class UserDTO {
    private String id;
    private UserType userType;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String address;
    private String age;
    private String weight;
    private String height;
    private String fitnessGoals;
    private String profilePhoto;



    public UserDTO(User user) {
        this.id = user.getId();
        this.userType = user.getUserType();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.age = user.getAge();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.fitnessGoals = user.getFitnessGoals();
        this.profilePhoto = user.getProfilePhoto();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
