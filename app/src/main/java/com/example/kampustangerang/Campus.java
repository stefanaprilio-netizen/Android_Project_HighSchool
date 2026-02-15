package com.example.kampustangerang;

public class Campus {
    private String name;
    private String location;
    private String description;
    private String imageUrl;
    private String facilities;
    private String registrationDate;

    public Campus(String name, String location, String description, String imageUrl, String facilities, String registrationDate) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.facilities = facilities;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }
}
