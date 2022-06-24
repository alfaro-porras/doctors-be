package com.daniela.doctors.be.resources;

import com.daniela.doctors.be.logic.Service;
import com.daniela.doctors.be.logic.appointment.Appointment;
import com.daniela.doctors.be.logic.doctor.Doctor;
import com.daniela.doctors.be.logic.patient.MedicalTest;
import com.daniela.doctors.be.logic.patient.Patient;
import com.daniela.doctors.be.response.AppointmentResponse;
import com.daniela.doctors.be.response.AppointmentsResponse;
import com.daniela.doctors.be.response.DoctorResponse;
import com.daniela.doctors.be.response.DoctorsResponse;
import com.daniela.doctors.be.response.GenericResponse;
import com.daniela.doctors.be.response.PatientResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public DoctorsResponse getDoctors() {
        try {
            ArrayList<Doctor> doctorList = Service.instance().getDoctors();
            if (doctorList == null || doctorList.isEmpty()) {
                return new DoctorsResponse(false, "Error", null);
            }

            return new DoctorsResponse(true, "", doctorList);
        } catch (Exception ex) {
            return new DoctorsResponse(false, ex.getMessage(), null);
        }
    }

    @GET
    @Path("{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public DoctorResponse getDoctor(@PathParam("email") String email) {
        try {
            Doctor doctor = Service.instance().getDoctor(email);
            if (doctor == null) {
                return new DoctorResponse(false, "Error", null);
            }

            return new DoctorResponse(true, "", doctor);
        } catch (Exception ex) {
            return new DoctorResponse(false, ex.getMessage(), null);
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public DoctorResponse doctorLogin(Doctor doctor) {
        try {
            Doctor loginDoctor = Service.instance().isDoctorLogin(doctor);
            if (loginDoctor == null) {
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

            if (!success) {
                return new GenericResponse(false, "Error");
            }

            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }

    @GET
    @Path("{email}/patients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public PatientResponse getPatients(@PathParam("email") String email) {
        try {
            ArrayList<Patient> patientList = Service.instance().getPatients(email);
            if (patientList == null || patientList.isEmpty()) {
                return new PatientResponse(false, "Error", null);
            }

            return new PatientResponse(true, "", patientList);
        } catch (Exception ex) {
            return new PatientResponse(false, ex.getMessage(), null);
        }
    }

    @GET
    @Path("{email}/appointments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public AppointmentsResponse getAppointments(@PathParam("email") String email) {
        try {
            ArrayList<Appointment> appointmentList = Service.instance().getAppointments(email);
            if (appointmentList == null || appointmentList.isEmpty()) {
                return new AppointmentsResponse(false, "Error", null);
            }

            return new AppointmentsResponse(true, "", appointmentList);
        } catch (Exception ex) {
            return new AppointmentsResponse(false, ex.getMessage(), null);
        }
    }
   
    @GET
    @Path("appointments/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public AppointmentResponse getAppointment(@PathParam("appointmentId") String appointmentId) {
        try {
            Appointment appointment = Service.instance().getAppointment(appointmentId);
            if (appointment == null) {
                return new AppointmentResponse(false, "Error", null);
            }

            return new AppointmentResponse(true, "", appointment);
        } catch (Exception ex) {
            return new AppointmentResponse(false, ex.getMessage(), null);
        }
    }

    @PUT
    @Path("appointments/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public GenericResponse updateAppointment(@PathParam("appointmentId") String appointmentId, Appointment appointment) {
        try {
            boolean success = Service.instance().updateAppointment(appointmentId, appointment);
            if (!success) {
                return new GenericResponse(false, "Error");
            }

            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }

    @POST
    @Path("patients/{email}/medicaltest")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public GenericResponse addMedicalTest(@PathParam("email") String email, MedicalTest medicalTest) {
        try {
            boolean success = Service.instance().addMedicalTest(email, medicalTest);

            if (!success) {
                return new GenericResponse(false, "Error");
            }

            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }

    @PUT
    @Path("{email}/activate")
    @Produces({MediaType.APPLICATION_JSON})
    public GenericResponse activateDoctor(@PathParam("email") String email) {
        try {
            boolean success = Service.instance().activateDoctor(email);

            if (!success) {
                return new GenericResponse(false, "Error");
            }

            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }

    @POST
    @Path("{doctorEmail}/patients/{patientEmail}/appointment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public GenericResponse addAppointment(@PathParam("doctorEmail") String doctorEmail, @PathParam("patientEmail") String patientEmail, Appointment appointment) {
        try {
            System.out.println("----doctorEmail" + doctorEmail);
            System.out.println("----patientEmail" + patientEmail);
            boolean success = Service.instance().addAppointment(doctorEmail, patientEmail, appointment);

            if (!success) {
                return new GenericResponse(false, "Error");
            }

            return new GenericResponse(true, "");
        } catch (Exception ex) {
            return new GenericResponse(false, ex.getMessage());
        }
    }
}
