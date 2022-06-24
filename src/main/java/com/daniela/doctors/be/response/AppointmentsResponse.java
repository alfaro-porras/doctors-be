
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.appointment.Appointment;
import java.util.ArrayList;


public class AppointmentsResponse {
    private boolean success;
    private String error;
    private ArrayList<Appointment> data;

    public AppointmentsResponse() {
    }

    public AppointmentsResponse(boolean success, String error, ArrayList<Appointment> data) {
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

    public ArrayList<Appointment> getData() {
        return data;
    }

    public void setData(ArrayList<Appointment> data) {
        this.data = data;
    }
    
    
}
