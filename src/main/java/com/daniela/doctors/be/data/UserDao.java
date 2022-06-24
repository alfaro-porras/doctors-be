package com.daniela.doctors.be.data;

import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.appointment.Appointment;
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

    public Doctor getDoctor(String pEmail) {
        try {
            String sql = "{call getDoctor(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            ResultSet rs = db.executeQuery(stm);

            if (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String id = rs.getString("id");
                String picture = rs.getString("picture");
                String specialty = rs.getString("specialty");
                String location = rs.getString("location");
                int frequency = rs.getInt("frequency");
                int active = rs.getInt("active");

                ArrayList<Schedule> scheduleList = getSchedule(email);

                Doctor doctor = new Doctor(name, lastname, email, id, picture, specialty, location, frequency, active, scheduleList);
                return doctor;
            }

            return null;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: createDoctor: " + e.getMessage());
            return null;
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

    public boolean addAppointment(String doctorEmail, String patientEmail, Appointment appointment) {
        try {
            String sql = "{call addAppointment(?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, patientEmail);
            stm.setString(2, doctorEmail);
            stm.setString(3, appointment.getTime());
            stm.setString(4, appointment.getDate());
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

    public boolean updateAppointment(String appointmentId, Appointment appointment) {
        try {
            String sql = "{call updateAppointment(?,?,?,?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(appointmentId));
            stm.setString(2, appointment.getNotes());
            stm.setString(3, appointment.getDiagnosis());
            stm.setString(4, appointment.getPrescription());
            int count = db.executeUpdate(stm);

            return count > 0;
        } catch (SQLException | Error e) {
            System.out.println("ERROR: updateAppointment: " + e.getMessage());
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

    public ArrayList<Appointment> getAppointments(String pEmail) {
        try {
            String sql = "{call getAppointments(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<Appointment> appointmentList = new ArrayList<>();

            while (rs.next()) {
                String time = rs.getString("time");
                String date = rs.getString("date");
                String notes = rs.getString("notes");
                String diagnosis = rs.getString("diagnosis");
                String prescription = rs.getString("prescription");
                String state = rs.getString("state");
                String patientName = rs.getString("patientName");
                String medicalTestName = rs.getString("medicalTestName");
                int appointmentId = rs.getInt("appointmentId");

                Appointment appointment = new Appointment(time, date, notes, diagnosis, prescription, state, patientName, medicalTestName, appointmentId);
                appointmentList.add(appointment);
            }

            return appointmentList;
        } catch (SQLException e) {
            System.out.println("ERROR: getAppointments: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Appointment getAppointment(String pAppointmentId) {
        try {
            String sql = "{call getAppointment(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(pAppointmentId));
            ResultSet rs = db.executeQuery(stm);

            if (rs.next()) {
                String time = rs.getString("time");
                String date = rs.getString("date");
                String notes = rs.getString("notes");
                String diagnosis = rs.getString("diagnosis");
                String prescription = rs.getString("prescription");
                String state = rs.getString("state");
                String patientName = rs.getString("patientName");
                String medicalTestName = rs.getString("medicalTestName");
                int appointmentId = rs.getInt("appointmentId");

                Appointment appointment = new Appointment(time, date, notes, diagnosis, prescription, state, patientName, medicalTestName, appointmentId);
                return appointment;
            }

            return null;
        } catch (SQLException e) {
            System.out.println("ERROR: getAppointment: " + e.getMessage());
            return null;
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
                int frequency = rs.getInt("frequency");
                int active = rs.getInt("active");

                ArrayList<Schedule> scheduleList = getSchedule(email);

                Doctor user = new Doctor(name, lastname, email, id, picture, specialty, location, frequency, active, scheduleList);
                doctorList.add(user);
            }

            return doctorList;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<MedicalTest> getMedicalTestList(String pEmail) {
        try {
            String sql = "{call getMedicalTestList(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, pEmail);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<MedicalTest> medicalTestList = new ArrayList<>();

            while (rs.next()) {
                String description = rs.getString("description");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String pdf = rs.getString("pdf");

                MedicalTest medicalTest = new MedicalTest(description, name, date, pdf, 1);
                medicalTestList.add(medicalTest);
            }

            return medicalTestList;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<Schedule> getSchedule(String email) {
        try {
            String sql = "{call getSchedule(?)}";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = db.executeQuery(stm);

            ArrayList<Schedule> scheduleList = new ArrayList<>();

            while (rs.next()) {
                String start = rs.getString("start");
                String end = rs.getString("end");
                String day = rs.getString("day");
                int active = rs.getInt("active");

                Schedule schedule = new Schedule(start, end, day, active);
                scheduleList.add(schedule);
            }

            return scheduleList;
        } catch (SQLException e) {
            System.out.println("ERROR: getRecords: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
