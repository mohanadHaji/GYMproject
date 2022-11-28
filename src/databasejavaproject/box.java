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
public class box {
    int idb;
    int capacityb;

    public box(int idb, int capacityb) {
        this.idb = idb;
        this.capacityb = capacityb;
    }

    public box(int idb) {
        this.idb = idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public void setCapacityb(int capacityb) {
        this.capacityb = capacityb;
    }

    @Override
    public String toString() {
        return ""+idb ;
    }
    
    
    
}
