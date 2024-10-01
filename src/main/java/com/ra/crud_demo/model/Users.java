package com.ra.crud_demo.model;

import java.time.LocalDate;

public class Users {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;

    public Users() {
    }

    public Users(String name, int id, LocalDate dateOfBirth, String address, String phone) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getdateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

