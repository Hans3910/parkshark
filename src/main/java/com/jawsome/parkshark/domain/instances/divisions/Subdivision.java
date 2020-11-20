package com.jawsome.parkshark.domain.instances.divisions;

import javax.persistence.*;

@Entity
@Table(name = "subdivisions")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subdivisions_subdivision_id_seq")
    @Column(name = "subdivision_id")
    private int id;
    @Column(name = "new_name")
    private String newName;
    @Column(name = "original_name")
    private String originalName;
    @Column(name = "director")
    private String director;
    @Column(name = "division_id")
    private int parentDivisionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParentDivisionId() {
        return parentDivisionId;
    }

    public void setParentDivisionId(int parentDivisionId) {
        this.parentDivisionId = parentDivisionId;
    }
}
