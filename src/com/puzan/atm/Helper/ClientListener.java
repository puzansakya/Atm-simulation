/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.atm.Helper;

import com.puzan.atm.Dao.AuthenticationDAO;
import com.puzan.atm.Dao.TransactionsDAO;
import com.puzan.atm.Dao.impl.AuthenticationImpl;
import com.puzan.atm.Dao.impl.Transactionimpl;
import com.puzan.atm.Entities.statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 *
 * @author puzan
 */
public class ClientListener extends Thread {

    String username = "";

  private Socket socket;
    private BufferedReader reader;
    private PrintStream output;

    public ClientListener(Socket socket) throws IOException {

        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                output.println("Welcome to the Atm Simulation");
                login();
                //authentication code goes
                String line = "";
                displayMenu();
                TransactionsDAO transaction = new Transactionimpl();

                while (!(line = reader.readLine()).equalsIgnoreCase("4")) {

                    int num = Integer.parseInt(line);
                    switch (num) {
                        case 1:
                            do {
                                output.println("Enter amount");
                                line = reader.readLine();
                                if (line != null) {
                                    try {

                                        int amount = transaction.withdraw(username);
                                        int newAmount = Integer.parseInt(line);

                                        int diffAmount = amount - newAmount;
                                        if ((transaction.Update_Transaction(username, diffAmount)) > 0) {
                                            transaction.insertTransaction(newAmount, username);
                                            output.println("Transaction successful...");
                                            output.println("Another transaction?y/n...");
                                        }
                                    } catch (SQLException | ClassNotFoundException io) {
                                        io.getMessage();
                                    }

                                }
                            } while (!(line = reader.readLine()).equalsIgnoreCase("n"));

                            /* output.println("Press * to go to Main Menu ...");
                             if (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                             output.println("invalid input...");

                             }*/
                            displayMenu();
                            break;


                        /*  Actions action = ActionFactory.get(num);
                        
                         

                         if (line != null) {
                         // action.execute(username, Integer.parseInt(line));
                         transaction.withdraw(username, Integer.parseInt(line));
                         }*/
                        case 2:
                            try {

                                int amount = transaction.getCurrentBalance(username);
                                output.println("Your current amount is " + amount);
                                output.println("Press * to go to Main ...");
                                while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                    output.println("invalid input...");

                                }
                                displayMenu();
                                //break;

                                break;
                            } catch (IOException | SQLException | ClassNotFoundException io) {
                                io.getMessage();
                            }

                        case 3:
                            try {
                                output.println("You pressed 3");

                                displayNo3menu();

                                int input = Integer.parseInt(line = reader.readLine());

                                switch (input) {
                                    case 1:
                                        output.println("you pressed 1.");
                                        try {

                                            int amount = transaction.withdraw(username);
                                            int newAmount = 1000;

                                            if (newAmount > amount) {
                                                output.println("Not enough balance");
                                                break;
                                            } else {

                                                int diffAmount = amount - newAmount;
                                                if ((transaction.Update_Transaction(username, diffAmount)) > 0) {
                                                    transaction.insertTransaction(newAmount, username);
                                                    output.println("Transaction successful...");
                                                    break;
                                                }
                                            }

                                        } catch (SQLException | ClassNotFoundException io) {
                                            io.getMessage();
                                        }
                                        while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                            output.println("invalid input...");

                                        }
                                        /* output.println("Type exit to go to previous menu ...");
                                         
                                         displayNo3menu();*/
                                        break;
                                    case 2:
                                        try {

                                            int amount = transaction.withdraw(username);
                                            int newAmount = 2000;

                                            if (newAmount > amount) {
                                                output.println("Not enough balance");
                                                break;
                                            } else {

                                                int diffAmount = amount - newAmount;
                                                if ((transaction.Update_Transaction(username, diffAmount)) > 0) {
                                                    transaction.insertTransaction(newAmount, username);
                                                    output.println("Transaction successful...");
                                                    break;
                                                }
                                            }

                                        } catch (SQLException | ClassNotFoundException io) {
                                            io.getMessage();
                                        }
                                        while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                            output.println("invalid input...");

                                        }
                                        /* output.println("Type exit to go to previous menu ...");
                                         
                                         displayNo3menu();*/
                                        break;
                                    case 3:
                                        try {

                                            int amount = transaction.withdraw(username);
                                            int newAmount = 3000;

                                            if (newAmount > amount) {
                                                output.println("Not enough balance");
                                                break;
                                            } else {

                                                int diffAmount = amount - newAmount;
                                                if ((transaction.Update_Transaction(username, diffAmount)) > 0) {
                                                    transaction.insertTransaction(newAmount, username);
                                                    output.println("Transaction successful...");
                                                    break;
                                                }
                                            }

                                        } catch (SQLException | ClassNotFoundException io) {
                                            io.getMessage();
                                        }
                                        while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                            output.println("invalid input...");

                                        }
                                        /* output.println("Type exit to go to previous menu ...");
                                         
                                         displayNo3menu();*/
                                        break;
                                    case 4:
                                        try {

                                            int amount = transaction.withdraw(username);
                                            int newAmount = 4000;

                                            if (newAmount > amount) {
                                                output.println("Not enough balance");
                                                break;
                                            } else {

                                                int diffAmount = amount - newAmount;
                                                if ((transaction.Update_Transaction(username, diffAmount)) > 0) {
                                                    transaction.insertTransaction(newAmount, username);
                                                    output.println("Transaction successful...");
                                                    break;
                                                }
                                            }

                                        } catch (SQLException | ClassNotFoundException io) {
                                            io.getMessage();
                                        }
                                        while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                            output.println("invalid input...");

                                        }
                                        /* output.println("Type exit to go to previous menu ...");
                                         
                                         displayNo3menu();*/
                                        break;
                                }

                                output.println("Press * to go to Main ...");
                                while (!(line = reader.readLine()).equalsIgnoreCase("*")) {
                                    output.println("invalid input...");

                                }
                                displayMenu();
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                    }

                }

            }
        } catch (IOException ioe) {

        }
    }

    private void login() throws IOException {
        while (true) {
            output.println("Enter your username");
            username = reader.readLine();
            output.println("Enter your password");
            String password = reader.readLine();

            AuthenticationDAO auth = new AuthenticationImpl();

            try {
                if (auth.getClient(username, password)) {

                    output.println("welcome " + username);
                    break;
                } else {
                    output.println(" invalid  username and password.");

                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private void displayMenu() {
        output.println("1 withdraw >");
        output.println("2 Balance query >");
        output.println("3 Fast cash >");
        output.println("4 exit >");
    }

    private void displayNo3menu() {
        output.println("1->1000");
        output.println("2->2000");
        output.println("3->3000");
        output.println("4->4000");

    }
}
