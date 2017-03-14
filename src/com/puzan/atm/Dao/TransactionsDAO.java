/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Dao;

import com.puzan.atm.Entities.statement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author puzan
 */
public interface TransactionsDAO {

    int withdraw(String name) throws SQLException, ClassNotFoundException;

    int insertTransaction(int amount, String name) throws SQLException, ClassNotFoundException;

    int getCurrentBalance(String username) throws SQLException, ClassNotFoundException;

    int Update_Transaction(String username, int amount) throws SQLException, ClassNotFoundException;
    
    List<statement> viewStatement(String username) throws SQLException,ClassNotFoundException;

}
