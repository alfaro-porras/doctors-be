/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.patient.Patient;

/**
 *
 * @author bryan.alfaro
 */
public class PatientResponse {
    private boolean success;
    private String error;
    private Patient data;

    public PatientResponse() {
    }
    
    

    public PatientResponse(boolean success, String error, Patient data) {
        this.success = success;
        this.error = error;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Patient getData() {
        return data;
    }

    public void setData(Patient data) {
        this.data = data;
    }
}
