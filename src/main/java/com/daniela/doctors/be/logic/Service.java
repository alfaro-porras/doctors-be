package com.daniela.doctors.be.logic;

import com.daniela.doctors.be.data.UserDao;
import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.login.Login;
import com.daniela.doctors.be.logic.patient.Patient;

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


    public Service() {
        try {
            userDao = new UserDao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}