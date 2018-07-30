/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.controller;

import com.parkit.misc.Misc;
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
@WebServlet(name = "ParkingController", urlPatterns = {"/ParkingController"})
public class ParkingController extends HttpServlet {

    Misc m = new Misc();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            try {
                request.setAttribute("checklist", m.getChecked());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("parking.jsp");
            rd.forward(request, response);         
        }
        try {
            request.setAttribute("parklist", m.getParkList());
            RequestDispatcher rd = request.getRequestDispatcher("parking.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
             response.sendRedirect("404.jsp");
        }

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("checked")) {
            int location = Integer.parseInt(request.getParameter("checkedbox"));
            String vehicleno = request.getParameter("vehicleno");

            try {
                m.addParking(vehicleno, location);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
                 response.sendRedirect("404.jsp");
            }
        } else if (action.equalsIgnoreCase("removed")) {
            int location = Integer.parseInt(request.getParameter("location_id"));
            int parkid = Integer.parseInt(request.getParameter("parkid"));
            try {
                m.removeSpace(location,parkid);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
                 response.sendRedirect("404.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
