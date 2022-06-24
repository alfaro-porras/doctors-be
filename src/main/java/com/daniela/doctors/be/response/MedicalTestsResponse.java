package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.patient.MedicalTest;
import java.util.ArrayList;


public class MedicalTestsResponse {
      private boolean success;
    private String error;
    private ArrayList<MedicalTest> data;

    public MedicalTestsResponse() {
    }

    public MedicalTestsResponse(boolean success, String error, ArrayList<MedicalTest> data) {
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

    public ArrayList<MedicalTest> getData() {
        return data;
    }

    public void setData(ArrayList<MedicalTest> data) {
        this.data = data;
    }
}
