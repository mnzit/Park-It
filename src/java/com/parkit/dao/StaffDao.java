/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.dao;

import com.parkit.model.Staff;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface StaffDao {
    int createStaff(Staff s)throws ClassNotFoundException,SQLException;
    int updateStaff(Staff s)throws ClassNotFoundException,SQLException;
    int deleteStaff(Staff s)throws ClassNotFoundException,SQLException;
    List<Staff> allStaffs()throws ClassNotFoundException,SQLException;
    List<Staff> getStaffById(int id)throws ClassNotFoundException,SQLException;
}
