/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Program;


import com.puzan.atm.Helper.ClientListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author puzan
 */
public class AtmSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 9000;
        try {
            ServerSocket server = new ServerSocket(port);
           
            System.out.println("Server is running at " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Got Connection from " + socket.getInetAddress().getHostAddress());
                ClientListener listener = new ClientListener(socket);
                listener.start();

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
