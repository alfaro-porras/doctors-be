package com.daniela.doctors.be.logic;

import com.daniela.doctors.be.data.UserDao;
import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.appointment.Appointment;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.patient.MedicalTest;
import com.daniela.doctors.be.logic.patient.Patient;
import java.util.ArrayList;

public class Service {

    // Singleton implementation
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    UserDao userDao;

    public boolean getUser() {
        return userDao.test();
    }
 
    public boolean createAdmin(Admin admin) {
        return userDao.createAdmin(admin);
    }
 
    public boolean createDoctor(Doctor doctor) {
        return userDao.createDoctor(doctor);
    }
 
    public Admin isAdminLogin(Admin admin) {
        return userDao.isAdminLogin(admin);
    }
 
    public Doctor isDoctorLogin(Doctor doctor) {
        return userDao.isDoctorLogin(doctor);
    }
   
    public boolean addPatient(String email, Patient patient) {
        return userDao.addPatient(email, patient);
    }
   
    public ArrayList<Patient> getPatients(String email) {
        return userDao.getPatients(email);
    }
 
    public Appointment getAppointment(String appointmentId) {
        return userDao.getAppointment(appointmentId);
    }
   
    public ArrayList<Appointment> getAppointments(String email) {
        return userDao.getAppointments(email);
    }
   
    public boolean activateDoctor(String email) {
        return userDao.activateDoctor(email);
    }
  
    public boolean updateAppointment(String appointmentId, Appointment appointment) {
        return userDao.updateAppointment(appointmentId, appointment);
    }

    public boolean addMedicalTest(String email, MedicalTest medicalTest) {
        return userDao.addMedicalTest(email, medicalTest);
    }
   
    public boolean addAppointment(String doctorEmail, String patientEmail, Appointment appointment) {
        return userDao.addAppointment(doctorEmail, patientEmail, appointment);
    }
    
    public ArrayList<Doctor> getDoctors() {
        return userDao.getDoctors();
    }
   
    public Doctor getDoctor(String email) {
        return userDao.getDoctor(email);
    }


    public Service() {
        try {
            userDao = new UserDao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}