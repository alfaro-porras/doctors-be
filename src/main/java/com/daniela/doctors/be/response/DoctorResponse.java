
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.doctor.Doctor;

public class DoctorResponse {
    private boolean success;
    private String error;
    private Doctor data;

    public DoctorResponse() {
    }
    
    

    public DoctorResponse(boolean success, String error, Doctor data) {
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

    public Doctor getData() {
        return data;
    }

    public void setData(Doctor data) {
        this.data = data;
    }
    
    
    
    
}
