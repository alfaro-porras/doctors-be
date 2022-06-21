package com.daniela.doctors.be.logic.doctor;

import java.util.ArrayList;

public class Doctor {
    private String name;
    private String lastname;
    private String email;
    private String id;
    private String picture;
    private String password;
    private String specialty;
    private String location;
    private double fee;
    private int frequency;
    private int active;
    private int specialtyId;
    private int locationId;
    private ArrayList<Schedule> schedule;

    public Doctor() {
        this.schedule = new ArrayList<>();
    }

    public Doctor(String name, String lastname, String email, String id, String picture, String specialty, String location) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.picture = picture;
        this.specialty = specialty;
        this.location = location;
    }
    
     public Doctor(String name, String lastname, String email, String id, String picture, String specialty, String location, int active) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.picture = picture;
        this.specialty = specialty;
        this.location = location;
        this.active = active;
    }
    
    

    public Doctor(String name, String lastname, String email, String id, String picture, String password, String specialty, String location, double fee, int frequency, int active, int specialtyId, int locationId, ArrayList<Schedule> schedule) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.picture = picture;
        this.password = password;
        this.specialty = specialty;
        this.location = location;
        this.fee = fee;
        this.frequency = frequency;
        this.active = active;
        this.specialtyId = specialtyId;
        this.locationId = locationId;
        this.schedule = schedule;
    }
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }
    
    
}
