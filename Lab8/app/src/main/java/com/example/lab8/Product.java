package com.example.lab8;

public class Product {
    private int photo;
    private String title;
    private String content;

    public Product(int photo, String title, String content) {
        this.photo = photo;
        this.title = title;
        this.content = content;
    }

    public int getPhoto() { return photo; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
}
