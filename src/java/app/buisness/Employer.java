/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.buisness;

import java.io.Serializable;

/**
 *
 * @author nilesh rathi
 */
public class Employer implements Serializable {
    
    private int id;
    private String name;
    private String company;
    private String email;
    private String website;
    private String profile;
    private String skills;
    private String password;

    public Employer(String name, String company, String email, String website, String profile, String skills, String password) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.website = website;
        this.profile = profile;
        this.skills = skills;
        this.password = password;
    }

    public Employer(int id, String name, String company, String email, String website, String profile, String skills, String password) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.website = website;
        this.profile = profile;
        this.skills = skills;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
