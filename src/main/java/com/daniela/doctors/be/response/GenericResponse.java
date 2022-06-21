package com.daniela.doctors.be.response;

public class GenericResponse {
    private boolean success;
    private String error;

    public GenericResponse() {
    }

    public GenericResponse(boolean success, String error) {
        this.success = success;
        this.error = error;
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
    
    
    
    
}
