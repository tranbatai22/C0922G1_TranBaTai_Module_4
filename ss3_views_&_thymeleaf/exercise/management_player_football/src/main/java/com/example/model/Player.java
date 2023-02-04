package com.example.model;

public class Player {
    private int id;
    private String name;
    private String dayOfBirth;
    public String position;
    private String experience;

    public Player() {
    }

    public Player(int id, String name, String dayOfBirth, String position, String experience) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.position = position;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}