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
@WebServlet(name = "MemberUpdater", urlPatterns = {"/MemberUpdater"})
public class MemberUpdater extends HttpServlet {
    Member s = new Member();
    MemberDao memberDao = new MemberDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    try {
                int id = Integer.parseInt(request.getParameter("memberid"));
                request.setAttribute("memberbyid", memberDao.getMemberById(id));
              
            } catch (ClassNotFoundException | SQLException ex) {
                 response.sendRedirect("404.jsp");
                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
            }
                RequestDispatcher rd = request.getRequestDispatcher("editmember.jsp");
                rd.forward(request, response);
    }

    

}
