/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejavaproject;

/**
 *
 * @author hp
 */
public class memberclass {
    int id;
    String name;
    String gender;
    String address;
    String date;
    int weight;

    public memberclass( String name,int id, String gender, String address, String date, int weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.weight = weight;
    }
   
 public memberclass( int id)
 {
   this.id = id;   
 }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return ""+id;
    }
    
    
}
