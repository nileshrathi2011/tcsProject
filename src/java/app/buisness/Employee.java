package app.buisness;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nilesh rathi
 */
public class Employee implements Serializable {
    private String name;
    private String dob;
    private String college;
    private String email;
    private String resume;
    private String password;
    
    public Employee(String name, String dob, String college, String email, String password, String resume) {
        this.name = name;
        this.dob = dob;
        this.college = college;
        this.email = email;
        this.password = password;
        this.resume=resume;
    }
    

    public Employee() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    
    
    
}
