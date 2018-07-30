/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.dao.daoImpl;

import com.parkit.dao.StaffDao;
import com.parkit.model.Staff;
import com.parkit.util.DBFunc;
import com.parkit.util.DBQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dell
 */
public class StaffDaoImpl implements StaffDao {

    private DBFunc db = new DBFunc();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_STAFF);
        pstm.setString(1, s.getName());
        pstm.setInt(2, s.getSalary());
        pstm.setString(3, s.getPhone_no());
        pstm.setString(4, s.getAddress());
        pstm.setString(5, s.getCitizenship_no());
        pstm.setString(6, s.getPassword());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_STAFF);
        pstm.setString(1, s.getName());
        pstm.setInt(2, s.getSalary());
        pstm.setString(3, s.getPhone_no());
        pstm.setString(4, s.getAddress());
        pstm.setString(5, s.getCitizenship_no());
         pstm.setString(6, s.getPassword());
        pstm.setInt(7, s.getStaff_id());
       
        if (db.update() == 1) {
            return 1;
        }

        db.close();
        return 0;
    }

    @Override
    public int deleteStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_STAFF);
        pstm.setInt(1, s.getStaff_id());
        if (db.update() == 1) {
            return 1;
        }

        db.close();
        return 0;
    }

    @Override
    public List<Staff> allStaffs() throws ClassNotFoundException, SQLException {
        List<Staff> allStaffs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_STAFF);
        rs = db.retrieve();
        while (rs.next()) {
            Staff s = new Staff();
            s.setStaff_id(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSalary(rs.getInt(3));
            s.setPhone_no(rs.getString(4));
            s.setAddress(rs.getString(5));
            s.setCitizenship_no(rs.getString(6));
            s.setPassword(rs.getString(7));

            allStaffs.add(s);
        }
        db.close();
        return allStaffs;
    }

    @Override
    public List<Staff> getStaffById(int id) throws ClassNotFoundException, SQLException {
        List<Staff> allStaffs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_STAFF_BYID);
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Staff s = new Staff();
            s.setStaff_id(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSalary(rs.getInt(3));
            s.setPhone_no(rs.getString(4));
            s.setAddress(rs.getString(5));
            s.setCitizenship_no(rs.getString(6));
            s.setPassword(rs.getString(7));
            allStaffs.add(s);
        }
        db.close();
        return allStaffs;
    }

}
