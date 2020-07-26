package com.mongodb.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    
    @Id
    private String id;
    private String username,password,role,name,email;
    private Boolean active;
    private DetailUser detailUser;
    


    public User() {
    }

    public User(String id, String username, String password, String role, String name, String email, DetailUser detailUser, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.detailUser = detailUser;
        this.active = active;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DetailUser getDetailUser() {
        return this.detailUser;
    }

    public void setDetailUser(DetailUser detailUser) {
        this.detailUser = detailUser;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User id(String id) {
        this.id = id;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User role(String role) {
        this.role = role;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User detailUser(DetailUser detailUser) {
        this.detailUser = detailUser;
        return this;
    }

    public User active(Boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", detailUser='" + getDetailUser() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }

}