/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BahaEddine
 */
public class Database {
    private final String url = "jdbc:mysql://localhost:3306/assurance"; //assurance || javapi
    private final String username = "root";
    private final String password = "";
    private Connection cnx;
    private static Database instance;
    
    private Database(){
        try {
            cnx = DriverManager.getConnection(url,username,password);
            System.out.println("connection établie");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return cnx;
    }
}
