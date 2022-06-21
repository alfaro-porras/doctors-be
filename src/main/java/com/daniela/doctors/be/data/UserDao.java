package com.daniela.doctors.be.data;

import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.doctor.Schedule;
import com.daniela.doctors.be.logic.patient.MedicalTest;
import com.daniela.doctors.be.logic.patient.Patient;
import com.daniela.doctors.be.logic.patient.Record;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    Database db;

    public UserDao() {
        db = Database.instance();
    }

    public boolean test() {
        return true;
    }

    public Admin isAdminLogin(Admin admin) {
        try {
            String sql = "{call isAdminLogin(?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, admin.getEmail());
            stm.setString(2, admin.getPassword());
            ResultSet rs = db.executeQuery(stm);

            if (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String id = rs.getString("id");
                String picture = rs.getString("picture");
                return new Admin(name, lastname, email, id, picture, "", 1);
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Doctor isDoctorLogin(Doctor doctor) {
        try {
            String sql = "{call isDoctorLogin(?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, doctor.getEmail());
            stm.setString(2, doctor.getPassword());
            ResultSet rs = db.executeQuery(stm);

            if (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String id = rs.getString("id");
                String picture = rs.getString("picture");
                String specialty = rs.getString("specialty");
                String location = rs.getString("location");
                return new Doctor(name, lastname, email, id, picture, specialty, location);
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean createAdmin(Admin admin) {
        try {
            String sql = "{call addAdmin(?,?,?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, admin.getName());
            stm.setString(2, admin.getLastname());
            stm.setString(3, admin.getEmail());
            stm.setString(4, admin.getId());
            stm.setString(5, admin.getPicture());
            stm.setString(6, admin.getPassword());
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException e) {
            System.out.println("ERROR: CreateAdmin: " + e.getMessage());
            return false;
        }
    }

    public boolean createDoctor(Doctor doctor) {
        try {
            String sql = "{call addDoctor(?,?,?,?,?,?,?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, doctor.getName());
            stm.setString(2, doctor.getLastname());
            stm.setString(3, doctor.getEmail());
            stm.setString(4, doctor.getId());
            stm.setString(5, doctor.getPicture());
            stm.setString(6, doctor.getPassword());
            stm.setDouble(7, doctor.getFee());
            stm.setInt(8, doctor.getFrequency());
            stm.setInt(9, doctor.getSpecialtyId());
            stm.setInt(10, doctor.getLocationId());
            int count = db.executeUpdate(stm);

            if (count > 0) {
                ArrayList<Schedule> scheduleList = doctor.getSchedule();
                for (Schedule schedule : scheduleList) {
                    addSchedule(doctor.getEmail(), schedule);
                }

                return true;
            }

            return false;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: createDoctor: " + e.getMessage());
            return false;
        }
    }

    public boolean addSchedule(String pEmail, Schedule schedule) {
        try {
            String sql = "{call addSchedule(?,?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            stm.setString(2, schedule.getDay());
            stm.setString(3, schedule.getStart());
            stm.setString(4, schedule.getEnd());
            stm.setInt(5, schedule.getActive());
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: addSchedule: " + e.getMessage());
            return false;
        }
    }

    public boolean addMedicalTest(String pEmail, MedicalTest medicalTest) {
        try {
            String sql = "{call addMedicalTest(?,?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            stm.setString(2, medicalTest.getDescription());
            stm.setString(3, medicalTest.getName());
            stm.setString(4, medicalTest.getDate());
            stm.setString(5, "");
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: addMedicalTest: " + e.getMessage());
            return false;
        }
    }

    public boolean addPatient(String pEmail, Patient patient) {
        try {
            String sql = "{call addPatient(?,?,?,?,?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            stm.setString(2, patient.getName());
            stm.setString(3, patient.getLastname());
            stm.setString(4, patient.getEmail());
            stm.setString(5, patient.getId());
            stm.setInt(6, patient.getAge());
            stm.setString(7, patient.getGender());
            stm.setString(8, patient.getPhone());
            int count = db.executeUpdate(stm);

            if (count > 0) {
                ArrayList<Record> recordList = patient.getRecords();
                for (Record record : recordList) {
                    addRecord(patient.getEmail(), record.getRecordId(), record.getEnabled());
                }

                return true;
            }

            return false;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: addPatient: " + e.getMessage());
            return false;
        }
    }

    public boolean addRecord(String email, int recordId, int enabled) {
        try {
            String sql = "{call addRecord(?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, email);
            stm.setInt(2, recordId);
            stm.setInt(3, enabled);
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: addRecord: " + e.getMessage());
            return false;
        }
    }
    
    public boolean activateDoctor(String email) {
        try {
            String sql = "{call activateDoctor(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, email);
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: activateDoctor: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Patient> getPatients(String pEmail) {
        try {
            String sql = "{call getPatients(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<Patient> patientList = new ArrayList<>();

            while (rs.next()) {
                String patientId = rs.getString("patientId");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String id = rs.getString("id");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                int active = rs.getInt("active");

                ArrayList<Record> recordList = getRecords(patientId);

                Patient patient = new Patient(name, lastname, email, id, age, gender, phone, active, recordList);
                patientList.add(patient);
            }

            return patientList;
        } catch (SQLException e) {
            System.out.println("ERROR: getPatients: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Record> getRecords(String pPatientId) {
        try {
            String sql = "{call getRecords(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pPatientId);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<Record> recordList = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                int recordId = rs.getInt("recordId");
                int enabled = rs.getInt("enabled");

                Record record = new Record(name, recordId, enabled);
                recordList.add(record);
            }

            return recordList;
        } catch (SQLException e) {
            System.out.println("ERROR: getRecords: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Doctor> getDoctors() {
        try {
            String sql = "{call getDoctors()}";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<Doctor> doctorList = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String id = rs.getString("id");
                String picture = rs.getString("picture");
                String specialty = rs.getString("specialty");
                String location = rs.getString("location");
                int active = rs.getInt("active");

                Doctor user = new Doctor(name, lastname, email, id, picture, specialty, location, active);
                doctorList.add(user);
            }

            return doctorList;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

}
