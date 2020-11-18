package com.jawsome.parkshark.domain.instances;

public class Division {

    private String newName;
    private String originalName;
    private String director;

    public Division(String newName, String originalName, String director) {
        this.newName = newName;
        this.originalName = originalName;
        this.director = director;
    }
}

//As a Manager I want to create a division.
//
//ParkShark became the company it is by doing takeovers of competing companies. These companies were never fully merged with ParkShark, they became divisions.
//
//A division has a name, an original name (the original name of the bought company) and a director
