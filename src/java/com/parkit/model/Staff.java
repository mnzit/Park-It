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
public class Staff {
//    private String name,position;
//    private int salary,staff_id;

    private int staff_id, salary;
    private String name, address, citizenship_no,phone_no,password;

    public Staff() {

    }

    public Staff(int staff_id, int salary, String name, String address, String citizenship_no, String phone_no, String password) {
        this.staff_id = staff_id;
        this.salary = salary;
        this.name = name;
        this.address = address;
        this.citizenship_no = citizenship_no;
        this.phone_no = phone_no;
        this.password = password;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
