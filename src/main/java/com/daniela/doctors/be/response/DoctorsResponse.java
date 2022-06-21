
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.doctor.Doctor;
import java.util.ArrayList;

public class DoctorsResponse {
    private boolean success;
    private String error;
    private ArrayList<Doctor> data;

    public DoctorsResponse() {
    }

    public DoctorsResponse(boolean success, String error, ArrayList<Doctor> data) {
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

    public ArrayList<Doctor> getData() {
        return data;
    }

    public void setData(ArrayList<Doctor> data) {
        this.data = data;
    }
}
