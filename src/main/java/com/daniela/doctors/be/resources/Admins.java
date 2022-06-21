package com.daniela.doctors.be.resources;

import com.daniela.doctors.be.logic.Service;
import com.daniela.doctors.be.logic.admin.Admin;
import com.daniela.doctors.be.response.AdminResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author
 */
@Path("admins")
public class Admins {

    String location = "C:/AAA/images/";

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
            if (loginAdmin == null) {
                return new AdminResponse(false, "Error", null);
            }

            return new AdminResponse(true, "", loginAdmin);
        } catch (Exception ex) {
            return new AdminResponse(false, ex.getMessage(), null);
        }
    }

//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Path("{email}/imagen")
//    public void addImage(@PathParam("email") String email, @FormDataParam("imagen") InputStream in) {
//
//        OutputStream out;
//        try {
//            out = new FileOutputStream(new File(location + email));
//            in.transferTo(out);
//            out.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    @GET
//    @Path("{email}/imagen")
//    @Produces("image/png")
//    public Response getImge(@PathParam("email") String email) throws IOException {
//        System.out.println(email);
//        File file = new File(location + email);
//        Response.ResponseBuilder response = Response.ok((Object) file);
//        return response.build();
//    }
}
