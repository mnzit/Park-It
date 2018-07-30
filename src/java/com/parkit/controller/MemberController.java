/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.controller;

import com.parkit.dao.MemberDao;
import com.parkit.dao.daoImpl.MemberDaoImpl;
import com.parkit.model.Member;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "MemberController", urlPatterns = {"/MemberController"})
public class MemberController extends HttpServlet {

    Member m = new Member();
    MemberDao memberDao = new MemberDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String member_id = request.getParameter("memberid");
        m.setName(request.getParameter("name"));
        m.setVehicle_no(request.getParameter("vehicleNo"));
        m.setType(request.getParameter("state"));
        m.setAddress(request.getParameter("address"));
        m.setPhone_no(request.getParameter("phone_no"));
        m.setCitizenship_no(request.getParameter("citizenship_no"));
        try {
            if (member_id == null || member_id.isEmpty()) {
                if (memberDao.createMember(m) == 1) {
                    response.sendRedirect("MemberController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                m.setMember_id(Integer.parseInt(member_id));
                try {
                    if (memberDao.updateMember(m) == 1) {
                        response.sendRedirect("MemberController");
                    } else {
                        response.sendRedirect("404.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("404.jsp");
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Member Class not found" + ex);
            response.sendRedirect("404.jsp");
        } catch (SQLException ex) {
            System.out.println("SQLException in Member" + ex);
            response.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("memberlist", memberDao.allMembers());
            RequestDispatcher rd = request.getRequestDispatcher("member.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("404.jsp");
            System.out.println(ex);
        }

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("memberid"));
                m.setMember_id(id);
                if (memberDao.deleteMember(m) == 1) {
                } else {
                    response.sendRedirect("404.jsp");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("404.jsp");
                System.out.println(ex);
            }
        }

    }
}
