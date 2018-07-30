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
public class Member {
    private int member_id;
    private String name,vehicle_no,type,phone_no,address,citizenship_no,password;
    public Member(){
        
    }

    public Member(int member_id, String name, String vehicle_no, String type, String phone_no, String address, String citizenship_no) {
        this.member_id = member_id;
        this.name = name;
        this.vehicle_no = vehicle_no;
        this.type = type;
        this.phone_no = phone_no;
        this.address = address;
        this.citizenship_no = citizenship_no;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenship_no() {
        return citizenship_no;
    }

    public void setCitizenship_no(String citizenship_no) {
        this.citizenship_no = citizenship_no;
    }
    
}
