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
import java.io.PrintWriter;
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
@WebServlet(name = "StaffUpdater", urlPatterns = {"/StaffUpdater"})
public class StaffUpdater extends HttpServlet {
    Staff s = new Staff();
    StaffDao staffDao = new StaffDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    try {
                int id = Integer.parseInt(request.getParameter("staffid"));
                request.setAttribute("staffbyid", staffDao.getStaffById(id));
              
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
            }
                RequestDispatcher rd = request.getRequestDispatcher("editstaff.jsp");
                rd.forward(request, response);
    }

    

}
