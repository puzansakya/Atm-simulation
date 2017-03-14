/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Dao;

import java.sql.SQLException;

/**
 *
 * @author puzan
 */
public interface AuthenticationDAO {

    boolean getClient(String username, String password) throws SQLException, ClassNotFoundException;

}
