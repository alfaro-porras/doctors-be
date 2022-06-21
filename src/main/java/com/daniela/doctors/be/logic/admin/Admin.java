
package com.daniela.doctors.be.logic.admin;

public class Admin {
    private String name;
    private String lastname;
    private String email;
    private String id;
    private String picture;
    private String password;
    private int active;

    public Admin() {
    }

    public Admin(String name, String lastname, String email, String id, String picture, String password, int active) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.picture = picture;
        this.password = password;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    
}
