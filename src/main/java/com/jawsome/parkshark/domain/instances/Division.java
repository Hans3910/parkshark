package com.jawsome.parkshark.domain.instances;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "division_division_id_seq")
    @Column(name = "division_id")
    private int id;
    @Column(name = "new_name")
    private String newName;
    @Column(name = "original_name")
    private String originalName;
    @Column(name = "director")
    private String director;

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
    //    public Division(String newName, String originalName, String director) {
//        this.newName = newName;
//        this.originalName = originalName;
//        this.director = director;
//    }
//
//    public Division() {
//
//    }
}

//As a Manager I want to create a division.
//
//ParkShark became the company it is by doing takeovers of competing companies. These companies were never fully merged with ParkShark, they became divisions.
//
//A division has a name, an original name (the original name of the bought company) and a director
//TODO: Check edge cases: null fields, and repeated new name
