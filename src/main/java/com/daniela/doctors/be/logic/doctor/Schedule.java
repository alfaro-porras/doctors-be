
package com.daniela.doctors.be.logic.doctor;

public class Schedule {
    private String start;
    private String end;
    private String day;
    private int active;
    private int dayId;
    private int doctorId;

    public Schedule() {
    }

    public Schedule(String start, String end, String day, int active, int dayId, int doctorId) {
        this.start = start;
        this.end = end;
        this.day = day;
        this.active = active;
        this.dayId = dayId;
        this.doctorId = doctorId;
    }
    
    public Schedule(String start, String end, String day, int active) {
        this.start = start;
        this.end = end;
        this.day = day;
        this.active = active;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    
}
