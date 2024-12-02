package com.example.alertsnotificationsystem.model;

import java.util.List;

public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private int age;
    private List<String> otherPersonsAtAddress;

    // Constructor
    public ChildAlertDTO(String firstName, String lastName, int age, List<String> otherPersonsAtAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.otherPersonsAtAddress = otherPersonsAtAddress;
    }

    // Getters and setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getOtherPersonsAtAddress() {
        return otherPersonsAtAddress;
    }

    public void setOtherPersonsAtAddress(List<String> otherPersonsAtAddress) {
        this.otherPersonsAtAddress = otherPersonsAtAddress;
    }
}
