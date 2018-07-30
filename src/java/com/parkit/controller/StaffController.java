/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.controller;

import com.parkit.dao.StaffDao;
import com.parkit.dao.daoImpl.StaffDaoImpl;
import com.parkit.model.Staff;
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
@WebServlet(name = "StaffController", urlPatterns = {"/StaffController"})
public class StaffController extends HttpServlet {

    Staff s = new Staff();
    StaffDao staffDao = new StaffDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String staff_id = request.getParameter("staff_id");
        s.setName(request.getParameter("name"));
        s.setSalary(Integer.parseInt(request.getParameter("salary")));
        s.setPhone_no(request.getParameter("phone_no"));
        s.setAddress(request.getParameter("address"));
        s.setCitizenship_no(request.getParameter("citizenship_no"));
        s.setPassword(request.getParameter("password"));
        try {
            if (staff_id == null || staff_id.isEmpty()) {
                if (staffDao.createStaff(s) == 1) {
                    response.sendRedirect("StaffController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                s.setStaff_id(Integer.parseInt(staff_id));
                try {
                    if (staffDao.updateStaff(s) == 1) {
                        response.sendRedirect("StaffController");
                    } else {
                        response.sendRedirect("404.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("404.jsp");
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Staff Class not found" + ex);
            response.sendRedirect("404.jsp");
        } catch (SQLException ex) {
            System.out.println("SQLException in staff" + ex);
            response.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("stafflist", staffDao.allStaffs());
            RequestDispatcher rd = request.getRequestDispatcher("staff.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("404.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("404.jsp");
        }

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("staffid"));
                s.setStaff_id(id);
                if (staffDao.deleteStaff(s) == 1) {
                } else {
                    response.sendRedirect("404.jsp");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("404.jsp");
            }
        }

    }
}
