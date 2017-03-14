/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Dao.impl;

import com.puzan.atm.Connection.DBConnection;
import com.puzan.atm.Constants.SQLConstant;
import com.puzan.atm.Dao.TransactionsDAO;
import com.puzan.atm.Entities.statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author puzan
 */
public class Transactionimpl extends DBConnection implements TransactionsDAO {

    private DBConnection db = new DBConnection();

    @Override
    public int withdraw(String name) throws SQLException, ClassNotFoundException {
        int amount = 0;
        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.WITHDRAW);
        stmt.setString(1, name);
        ResultSet rs = db.query();
        if (rs.next()) {
            amount = rs.getInt("amount");
        }
        db.close();
        return amount;
    }

    @Override
    public int insertTransaction(int amount, String name) throws SQLException, ClassNotFoundException {
        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.INSERT_TRANSACTION);
        stmt.setString(1, name);
        stmt.setInt(2, amount);
        int res = db.update();
        db.close();
        return res;

    }

    @Override
    public int getCurrentBalance(String username) throws SQLException, ClassNotFoundException {
        int amount = 0;
        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.GET_CURRENT_BALANCE);
        stmt.setString(1, username);
        ResultSet rs = db.query();
        if (rs.next()) {
            amount = rs.getInt("amount");
        }
        return amount;

    }

    @Override
    public int Update_Transaction(String username, int amount) throws SQLException, ClassNotFoundException {
        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.UPDATE_TRANSACTOIN);
        stmt.setInt(1, amount);
        stmt.setString(2, username);
        int res = db.update();
        db.close();
        return res;

    }

    @Override
    public List<statement> viewStatement(String username) throws SQLException, ClassNotFoundException {
        List<statement> statementList = null;
        statementList = new ArrayList<>();

        db.connect();
        PreparedStatement stmt = db.initStatement(SQLConstant.VIEW_STATEMENT);
        stmt.setString(1, username);
        ResultSet rs = db.query();
        while (rs.next()) {
            statement stat = new statement();
            //stat.setDate(rs.getDate("date"));
            stat.setAmount(rs.getInt("transactoin_amount"));
        }
        db.close();

        return statementList;

    }

}
