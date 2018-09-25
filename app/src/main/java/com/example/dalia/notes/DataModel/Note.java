package com.example.dalia.notes.DataModel;

/**
 * Created by dina on 7/31/2017.
 */
public class Note {
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
    public String getImageroww() {
        return imageroww ;
    }

    public void setImageroww(String imageroww) {
        this.imageroww = imageroww;
    }
    public Note(String name, String description, String imageroww) {
        this.name = name;
        this.description = description;
        this.imageroww=imageroww;
    }

    private String name ;
    private String description;
    private String imageroww;
}

