/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.dao.daoImpl;

import com.parkit.dao.MemberDao;
import com.parkit.model.Member;
import com.parkit.util.DBFunc;
import com.parkit.util.DBQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class MemberDaoImpl implements MemberDao {

    private DBFunc db = new DBFunc();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_MEMBER);
        pstm.setString(1, m.getName());
        pstm.setString(2, m.getPhone_no());
        pstm.setString(3, m.getType());
        pstm.setString(4, m.getVehicle_no());
        pstm.setString(5, m.getAddress());
        pstm.setString(6, m.getCitizenship_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_MEMBER);
        pstm.setString(1, m.getName());
        pstm.setString(2, m.getPhone_no());
        pstm.setString(3, m.getType());
        pstm.setString(4, m.getVehicle_no());
        pstm.setString(5, m.getAddress());
        pstm.setString(6, m.getCitizenship_no());
        pstm.setInt(7, m.getMember_id());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int deleteMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_MEMBER);
        pstm.setInt(1, m.getMember_id());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public List<Member> allMembers() throws ClassNotFoundException, SQLException {
        List<Member> allMembers = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_MEMBER);
        rs = db.retrieve();
        while (rs.next()) {
            Member m = new Member();
            m.setMember_id(rs.getInt(1));
            m.setName(rs.getString(2));
            m.setVehicle_no(rs.getString(3));
            m.setType(rs.getString(4));
            m.setPhone_no(rs.getString(5));
            m.setAddress(rs.getString(6));
            m.setCitizenship_no(rs.getString(7));
            allMembers.add(m);
        }
        db.close();
        return allMembers;
    }

    @Override
    public List<Member> getMemberById(int id) throws ClassNotFoundException, SQLException {
       List<Member> allMembers = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_MEMBER_BYID);
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Member m = new Member();
            m.setMember_id(rs.getInt(1));
            m.setName(rs.getString(2));
            m.setVehicle_no(rs.getString(3));
            m.setType(rs.getString(4));
            m.setPhone_no(rs.getString(5));
            m.setAddress(rs.getString(6));
            m.setCitizenship_no(rs.getString(7));
            allMembers.add(m);
        }
        db.close();
        return allMembers;
    }

}
