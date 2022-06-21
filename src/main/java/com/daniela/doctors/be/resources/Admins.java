package com.daniela.doctors.be.resources;

import com.daniela.doctors.be.logic.Service;
import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.logic.login.Login;
import com.daniela.doctors.be.response.AdminResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author
 */
@Path("admins")
public class Admins {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Admin admin) {
        try {
            boolean success = Service.instance().createAdmin(admin);
            System.out.println("---success: " + success);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public AdminResponse adminLogin(Admin admin) {
        try {
            Admin loginAdmin = Service.instance().isAdminLogin(admin);
            if(loginAdmin ==  null) {
                return new AdminResponse(false, "Error", null);
            }
            
            return new AdminResponse(true, "", loginAdmin);
        } catch (Exception ex) {
            return new AdminResponse(false, ex.getMessage(), null);
        }
    }
}
