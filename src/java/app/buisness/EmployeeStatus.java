/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.buisness;

/**
 *
 * @author nilesh rathi
 */
public class EmployeeStatus {
    
    String companyName;
    String status;

    public EmployeeStatus(String companyName, String status) {
        this.companyName = companyName;
        this.status = status;
    }

    public EmployeeStatus() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
