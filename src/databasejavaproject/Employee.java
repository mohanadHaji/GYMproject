package databasejavaproject;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class Employee {
    SimpleStringProperty name,DOB,gender,address,phone,since,end,jobtitle;
    SimpleIntegerProperty ssn,salary;

    public Employee(String name, String DOB, String gender, 
            String address, String phone, String since, 
            String end,  String jobtitle, Integer ssn, Integer salary) {
        this.name = new SimpleStringProperty(name);
        this.DOB = new SimpleStringProperty(DOB);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
        this.since = new SimpleStringProperty(since);
        this.end = new SimpleStringProperty(end);
        this.jobtitle = new SimpleStringProperty(jobtitle);
        this.ssn = new SimpleIntegerProperty(ssn);
        this.salary = new SimpleIntegerProperty(salary);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setDOB(String DOB) {
        this.DOB = new SimpleStringProperty(DOB);
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public void setPhone(String phone) {
        this.phone = new SimpleStringProperty(phone);
    }

    public void setSince(String since) {
        this.since = new SimpleStringProperty(since);
    }

    public void setEnd(String end) {
        this.end = new SimpleStringProperty(end);
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = new SimpleStringProperty(jobtitle);
    }

    public void setSsn(Integer ssn) {
        this.ssn = new SimpleIntegerProperty(ssn);
    }

    public void setSalary(Integer salary) {
        this.salary = new SimpleIntegerProperty(salary);
    }

    public String getName() {
        return name.get();
    }

    public String getDOB() {
        return DOB.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getSince() {
        return since.get();
    }

    public String getEnd() {
        return end.get();
    }

    public String getJobtitle() {
        return jobtitle.get();
    }

    public Integer getSsn() {
        return ssn.get();
    }

    public Integer getSalary() {
        return salary.get();
    }
    
}
