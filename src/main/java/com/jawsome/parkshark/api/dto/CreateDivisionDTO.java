package com.jawsome.parkshark.api.dto;


public class CreateDivisionDTO {

    private String newName;
    private String originalName;
    private String director;

    public CreateDivisionDTO(String newName, String originalName, String director) {
        this.newName = newName;
        this.originalName = originalName;
        this.director = director;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
