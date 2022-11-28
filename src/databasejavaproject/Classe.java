/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejavaproject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 1
 */
public class Classe {
    SimpleStringProperty className,startTime,teacher;
    SimpleIntegerProperty classID,period,Rid,ssn;

    public Classe(String className, String startTime,String teacher, Integer classID, Integer period, Integer Rid, Integer ssn) {
        this.className = new SimpleStringProperty(className);
        this.startTime = new SimpleStringProperty(startTime);
        this.classID = new SimpleIntegerProperty(classID);
        this.period = new SimpleIntegerProperty(period);
        this.Rid = new SimpleIntegerProperty(Rid);
        this.ssn = new SimpleIntegerProperty(ssn);
        this.teacher = new SimpleStringProperty(teacher);
    }

    public void setClassName(String className) {
        this.className = new SimpleStringProperty(className);
    }
    public void setTeacher(String teacher) {
        this.teacher = new SimpleStringProperty(teacher);
    }
    public void setStartTime(String startTime) {
        this.startTime = new SimpleStringProperty(startTime);
    }

    public void setClassID(Integer classID) {
        this.classID = new SimpleIntegerProperty(classID);
    }

    public void setPeriod(Integer period) {
        this.period =  new SimpleIntegerProperty(period);
    }

    public void setRid(Integer Rid) {
        this.Rid = new SimpleIntegerProperty(Rid);
    }

    public void setSsn(Integer ssn) {
        this.ssn = new SimpleIntegerProperty(ssn);
    }

    public String getClassName() {
        return className.get();
    }

    public String getStartTime() {
        return startTime.get();
    }

    public Integer getClassID() {
        return classID.get();
    }

    public Integer getPeriod() {
        return period.get();
    }

    public Integer getRid() {
        return Rid.get();
    }

    public Integer getSsn() {
        return ssn.get();
    }
    public String getTeacher() {
        return teacher.get();
    }
}
