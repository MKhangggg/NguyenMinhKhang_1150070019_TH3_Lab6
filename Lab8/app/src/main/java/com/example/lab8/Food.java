package com.example.lab8;

public class Food {
    private int image;
    private String name;
    private String description;

    public Food(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() { return image; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String desc) { this.description = desc; }
}
