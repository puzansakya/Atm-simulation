/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Actions;

import java.util.HashMap;

/**
 *
 * @author puzan
 */
public class ActionFactory {

    private static HashMap<String, Actions> action = initCommands();

    private static HashMap<String, Actions> initCommands() {
        HashMap<String, Actions> cmds = new HashMap<>();
        cmds.put("1", new withdraw());
       
        return cmds;
    }

    public static Actions get(int param) {
       
        return (action.containsKey(param)) ? action.get(param) : null;
    }
}
