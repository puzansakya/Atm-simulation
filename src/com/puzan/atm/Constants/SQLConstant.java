/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Constants;

/**
 *
 * @author puzan
 */
public class SQLConstant {

    public static String LOGIN = "SELECT * FROM `tbl_user` WHERE `username` =? AND `password` = ?";
    public static String UPDATE_TRANSACTOIN = "update tbl_account set amount=? where username = ?";
    public static String WITHDRAW = "SELECT `amount` FROM `tbl_account` WHERE `username` =?";
    public static String INSERT_TRANSACTION = "INSERT INTO `tbl_transaction`(`transaction_username`, `transactoin_amount`) VALUES (?,?)";
    public static String GET_CURRENT_BALANCE = "SELECT  `amount` FROM `tbl_account` WHERE `username` =?";
    public static String VIEW_STATEMENT = "SELECT  `transactoin_amount`,'date'  FROM `tbl_transaction` WHERE `transaction_username` =?";
}
