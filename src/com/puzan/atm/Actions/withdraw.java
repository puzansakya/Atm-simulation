/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Actions;

import com.puzan.atm.Dao.TransactionsDAO;
import com.puzan.atm.Dao.impl.Transactionimpl;

/**
 *
 * @author puzan
 */
public class withdraw extends Actions {

    TransactionsDAO transaction = new Transactionimpl();

    @Override
    public void execute(String username, int amount) {
       // transaction.withdraw(username, amount);

    }

}
