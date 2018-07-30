/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.model;

/**
 *
 * @author Dell
 */
public class Park {
    private int park_id,location_id;
    private String vehicle_no,time_parked,time_returned,date;
    public Park(){
        
    }

    public Park(int park_id, int location_id, String vehicle_no, String time_parked, String time_returned, String date) {
        this.park_id = park_id;
        this.location_id = location_id;
        this.vehicle_no = vehicle_no;
        this.time_parked = time_parked;
        this.time_returned = time_returned;
        this.date = date;
    }

    public int getPark_id() {
        return park_id;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getTime_parked() {
        return time_parked;
    }

    public void setTime_parked(String time_parked) {
        this.time_parked = time_parked;
    }

    public String getTime_returned() {
        return time_returned;
    }

    public void setTime_returned(String time_returned) {
        this.time_returned = time_returned;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
