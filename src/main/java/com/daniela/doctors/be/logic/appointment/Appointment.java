
package com.daniela.doctors.be.logic.appointment;


public class Appointment {
    private String time;
    private String date;
    private String notes;
    private String diagnosis;
    private String prescription;
    private String state;
    private String patientName;
    private String medicalTestName;
    private int appointmentId;

    public Appointment() {
    }

    public Appointment(String time, String date, String notes, String diagnosis, String prescription, String state, String patientName, String medicalTestName, int appointmentId) {
        this.time = time;
        this.date = date;
        this.notes = notes;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.state = state;
        this.patientName = patientName;
        this.medicalTestName = medicalTestName;
        this.appointmentId = appointmentId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalTestName() {
        return medicalTestName;
    }

    public void setMedicalTestName(String medicalTestName) {
        this.medicalTestName = medicalTestName;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    
    
    
}
