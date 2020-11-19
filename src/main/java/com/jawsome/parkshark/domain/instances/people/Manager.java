package com.jawsome.parkshark.domain.instances.people;

public class Manager extends Person {
    private int id;
    private String phoneNumber;
    private Email email;

    public Manager(int id, String phoneNumber, Email email) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
