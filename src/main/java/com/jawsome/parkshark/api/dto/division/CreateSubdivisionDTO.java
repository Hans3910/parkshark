package com.jawsome.parkshark.api.dto.division;

public class CreateSubdivisionDTO {
    private String newName;
    private String originalName;
    private String director;
    private String parentDivisionNewName;

    public CreateSubdivisionDTO(String newName, String originalName, String director, String parentDivisionNewName) {
        this.newName = newName;
        this.originalName = originalName;
        this.director = director;
        this.parentDivisionNewName = parentDivisionNewName;
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

    public String getParentDivisionNewName() {
        return parentDivisionNewName;
    }

    public void setParentDivisionNewName(String parentDivisionNewName) {
        this.parentDivisionNewName = parentDivisionNewName;
    }
}
