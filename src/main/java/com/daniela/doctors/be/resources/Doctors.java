package com.daniela.doctors.be.resources;

import com.daniela.doctors.be.logic.Service;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.login.Login;
import com.daniela.doctors.be.logic.patient.Patient;
import com.daniela.doctors.be.response.DoctorResponse;
import com.daniela.doctors.be.response.GenericResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author 
 */
@Path("doctors")
public class Doctors {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Doctor doctor) {
        try {
            boolean success = Service.instance().createDoctor(doctor);
            System.out.println("---success: " + success);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public DoctorResponse doctorLogin(Doctor doctor) {
        try {
            Doctor loginDoctor = Service.instance().isDoctorLogin(doctor);
            if(loginDoctor ==  null) {
                return new DoctorResponse(false, "Error", null);
            }
            
            return new DoctorResponse(true, "", loginDoctor);
        } catch (Exception ex) {
            return new DoctorResponse(false, ex.getMessage(), null);
        }
    }
 
    @POST
    @Path("{email}/patients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public GenericResponse addPatient(@PathParam("email") String email, Patient patient) {
        try {
            boolean success = Service.instance().addPatient(email, patient);
        
            if(!success) {
                return new GenericResponse(false, "Error");
            }
            
            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }
}