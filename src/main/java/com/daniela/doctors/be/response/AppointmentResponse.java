
package com.daniela.doctors.be.response;

import com.daniela.doctors.be.logic.appointment.Appointment;


public class AppointmentResponse {
      private boolean success;
    private String error;
    private Appointment data;

    public AppointmentResponse() {
    }

    public AppointmentResponse(boolean success, String error, Appointment data) {
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

    public Appointment getData() {
        return data;
    }

    public void setData(Appointment data) {
        this.data = data;
    }
    
    
}
