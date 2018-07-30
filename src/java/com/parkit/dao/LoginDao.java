/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkit.dao;

import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public interface LoginDao {
    public boolean check(String uname, String upass,String uPost) throws ClassNotFoundException,SQLException;
}
