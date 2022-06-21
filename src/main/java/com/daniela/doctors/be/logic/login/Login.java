
package com.daniela.doctors.be.logic.login;

public class Login {
    private String email;
    private String password;
    private int admin;

    public Login() {
    }

    public Login(String email, String password, int admin) {
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }



    
}
