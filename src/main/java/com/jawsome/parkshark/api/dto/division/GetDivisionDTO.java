package com.jawsome.parkshark.api.dto.division;

public class GetDivisionDTO {
    private String newName;
    private String originalName;
    private String director;

    public String getNewName() {
        return newName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
