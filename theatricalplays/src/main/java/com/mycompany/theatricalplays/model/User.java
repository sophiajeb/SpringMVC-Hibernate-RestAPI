/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "user")

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Size(min = 3, max = 50)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 3, max = 50)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min = 3, max = 50)
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Size(min = 3, max = 50)
    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "mobile_phone", nullable = false)
    private String mobile_phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role")
    private String role;
    
    @Column(name = "photo")
    private String photo;
    
    @Column(name = "google_id")
    private String google_id;

    public User() {
        this.role = "USER";
    }

    //------------------- Getters - Setters --------------------
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public String getGoogleId() {
        return google_id;
    }

    public void setGoogleId(String googleId) {
        this.google_id = googleId;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", mobile_phone=" + mobile_phone + ", email=" + email + ", role=" + role + ", photo=" + photo + ", google_id=" + google_id + '}';
    }
}
