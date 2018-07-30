/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.util;

/**
 *
 * @author Dell
 */
public class DBQueries {

    public static final String INSERT_STAFF = "INSERT INTO " + DBTables.STAFF_TABLE + " (name,salary,phone_no,address,citizenship_no,password) VALUES(?,?,?,?,?,?)";
    public static final String GET_STAFF = "SELECT * FROM " + DBTables.STAFF_TABLE + " ORDER BY staff_id DESC";
    public static final String UPDATE_STAFF = "UPDATE " + DBTables.STAFF_TABLE + " set name=?, salary=?, phone_no=?, address=?, citizenship_no=?, password=? WHERE staff_id=?";
    public static final String GET_STAFF_BYID = "SELECT * FROM " + DBTables.STAFF_TABLE + " WHERE staff_id=?";
    public static final String DELETE_STAFF = "DELETE FROM " + DBTables.STAFF_TABLE + " WHERE staff_id=?";
    public static final String INSERT_MEMBER="INSERT INTO " + DBTables.MEMBER_TABLE + " (name,phone_no,type,vehicle_no,address,citizenship_no) VALUES(?,?,?,?,?,?)";
    public static final String GET_MEMBER="SELECT * FROM " + DBTables.MEMBER_TABLE + " ORDER BY member_id DESC";
    public static final String UPDATE_MEMBER="UPDATE "+ DBTables.MEMBER_TABLE+ " SET name=?, phone_no=?, type=?, vehicle_no=?, address=?, citizenship_no=? WHERE member_id=?";
    public static final String GET_MEMBER_BYID= "SELECT * FROM " + DBTables.MEMBER_TABLE + " WHERE member_id=?";
    public static final String DELETE_MEMBER="DELETE FROM " + DBTables.MEMBER_TABLE + " WHERE member_id=?";
}
