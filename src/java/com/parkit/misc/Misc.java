/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.misc;
import com.parkit.model.Park;
import com.parkit.model.Staff;
import com.parkit.util.DBFunc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Dell
 */
public class Misc {

    private DBFunc db = new DBFunc();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
//------------generatetime-----------------------------------------------------------------------------------------------

    public String timer() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm: a");
        return sdf.format(date);
    }
//-------------------generatedate---------------------------------------------------------------------------------------

    public String date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
//----------------------------Add to parking area-------------------------------------------------------------------------

    public int addParking(String vehicleno, int location) throws ClassNotFoundException, SQLException {
        String currTime = timer();
        String currDate = date();
        boolean status = false;
        int count = 0;
        db.connect();
        pstm = db.preparedStm("SELECT * FROM member WHERE vehicle_no=?");
        pstm.setString(1, vehicleno);
        rs = db.retrieve();
        while (rs.next()) {
        count++;
        }
        if(count>0){
            vehicleno+=" (M)";
        }
        db.close();
        String text = "none";
        db.connect();
        pstm = db.preparedStm("INSERT INTO parking (vehicle_no,time_parked,time_returned,location,date) VALUES(?,?,?,?,?)");
        pstm.setString(1, vehicleno);
        pstm.setString(2, currTime);
        pstm.setString(3, text);
        pstm.setInt(4, location);
        pstm.setString(5, currDate);
        if (db.update() == 1) {
            pstm = db.preparedStm("UPDATE location SET status=? WHERE location_id=?");
            pstm.setBoolean(1, status);
            pstm.setInt(2, location);
            db.update();
            return 1;
        }
        db.close();
        return 0;
    }
//-------------------getAllParking list-------------------------------------------------------------------------------------

    public List<Park> getParkList() throws ClassNotFoundException, SQLException {
        db.connect();
        List<Park> allParks = new ArrayList<>();

        pstm = db.preparedStm("SELECT * FROM parking ORDER BY park_id DESC");
//        pstm = db.preparedStm("SELECT p.park_id,p.vehicle_no,p.time_parked,p.time_returned,p.location,p.date FROM parking p INNER JOIN location l ON p.location = l.location_id WHERE l.status = 0");
        rs = db.retrieve();
        while (rs.next()) {
            Park p = new Park();
            p.setPark_id(rs.getInt(1));
            p.setVehicle_no(rs.getString(2));
            p.setTime_parked(rs.getString(3));
            p.setTime_returned(rs.getString(4));
            p.setLocation_id(rs.getInt(5));
            p.setDate(rs.getString(6));
            allParks.add(p);
        }
        db.close();
        return allParks;
    }
//-------------------set checkbox status-------------------------------------------------------------------------------------

    public Map<Integer, Integer> getChecked() throws SQLException, ClassNotFoundException {
        db.connect();
        pstm = db.preparedStm("select location_id,status from location ORDER BY location_id");
        rs = db.retrieve();
        Map<Integer, Integer> map = new TreeMap<>();
        while (rs.next()) {
            map.put(rs.getInt(1), rs.getInt(2));
        }
        return map;
    }
//    ---------------change checkbox status---------------------------------------------------------------------------------------

    public int removeSpace(int location_id, int parkid) throws SQLException, ClassNotFoundException {
        db.connect();
        String currTime = timer();
        pstm = db.preparedStm("UPDATE location set status=? WHERE location_id=?");
        pstm.setBoolean(1, true);
        pstm.setInt(2, location_id);
        if (db.update() == 1) {
            pstm = db.preparedStm("UPDATE parking set time_returned=? WHERE park_id=?");
            pstm.setString(1, currTime);
            pstm.setInt(2, parkid);
            db.update();
            return 1;
        }
        db.close();
        return 0;
    }
// -------------------------Staff login check-----------------------------------------------------------------------------------------
    public int checkMember(int id, String password) throws SQLException, ClassNotFoundException{
        db.connect();
        pstm = db.preparedStm("SELECT * FROM staff WHERE staff_id=? AND password=?");
        pstm.setInt(1, id);
        pstm.setString(2, password);
        rs = db.retrieve();
        while (rs.next()) {
        return 1;
        }
        return 0;
    }
}
