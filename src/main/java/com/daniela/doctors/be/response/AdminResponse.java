
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.admin.Admin;

public class AdminResponse {
    private boolean success;
    private String error;
    private Admin data;
    
    public AdminResponse() {
    }

    public AdminResponse(boolean success, String error, Admin data) {
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

    public Admin getData() {
        return data;
    }

    public void setData(Admin data) {
        this.data = data;
    }
    
    

    
    
}
