package com.daniela.doctors.be.data;

import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.doctor.Schedule;
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
}
