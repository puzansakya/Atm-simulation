/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Dao.impl;

import com.puzan.atm.Connection.DBConnection;
import com.puzan.atm.Constants.SQLConstant;
import com.puzan.atm.Dao.AuthenticationDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author puzan
 */
public class AuthenticationImpl implements AuthenticationDAO {

    private DBConnection db = new DBConnection();

    @Override
    public boolean getClient(String username, String password) throws SQLException, ClassNotFoundException {

        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.LOGIN);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = db.query();
        if (rs.next()) {
            return true;
        }
        db.close();
        return false;
    }

}
