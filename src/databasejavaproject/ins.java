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
public class ins {
    SimpleStringProperty producer,Iname;
    SimpleIntegerProperty Iid,Rid;

    public ins(String producer, String Iname, Integer Iid, Integer Rid) {
        this.producer = new SimpleStringProperty(producer);
        this.Iname = new SimpleStringProperty(Iname);
        this.Iid = new SimpleIntegerProperty(Iid);
        this.Rid = new SimpleIntegerProperty(Rid);
    }

    public void setProducer(String producer) {
        this.producer = new SimpleStringProperty(producer);
    }

    public void setIname(String Iname) {
        this.Iname = new SimpleStringProperty(Iname);
    }

    public void setIid(Integer Iid) {
        this.Iid = new SimpleIntegerProperty(Iid);
    }

    public void setRid(Integer Rid) {
        this.Rid = new SimpleIntegerProperty(Rid);
    }

    public String getProducer() {
        return producer.get();
    }

    public String getIname() {
        return Iname.get();
    }

    public Integer getIid() {
        return Iid.get();
    }

    public Integer getRid() {
        return Rid.get();
    }
    
}
