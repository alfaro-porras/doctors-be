
package com.daniela.doctors.be.logic.patient;

import java.util.ArrayList;


public class Patient {
    private String name;
    private String lastname;
    private String email;
    private String id;
    private int age;
    private String gender;
    private String phone;
    private int active;
    private ArrayList<Record> records;

    public Patient() {
    }

    public Patient(String name, String lastname, String email, String id, int age, String gender, String phone, int active, ArrayList<Record> records) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.active = active;
        this.records = records;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }
}
