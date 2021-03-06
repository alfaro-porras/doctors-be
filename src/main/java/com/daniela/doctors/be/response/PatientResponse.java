package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.patient.Patient;
import java.util.ArrayList;

public class PatientResponse {
    private boolean success;
    private String error;
    private ArrayList<Patient> data;

    public PatientResponse() {
    }
    
    

    public PatientResponse(boolean success, String error, ArrayList<Patient> data) {
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

    public ArrayList<Patient> getData() {
        return data;
    }

    public void setData(ArrayList<Patient> data) {
        this.data = data;
    }
}
