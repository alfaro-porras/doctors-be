package com.daniela.doctors.be.logic.patient;


public class MedicalTest {
    private String description;
    private String name;
    private String date;
    private String pdf;
    private int active;

    public MedicalTest() {
    }

    public MedicalTest(String description, String name, String date, String pdf, int active) {
        this.description = description;
        this.name = name;
        this.date = date;
        this.pdf = pdf;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    
}
