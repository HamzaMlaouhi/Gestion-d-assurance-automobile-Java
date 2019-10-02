/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence.Services;

import Shared.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Skander
 */
public class ExpertDAO1 implements Crud {
    
      Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public ExpertDAO1() {
    }
    
    
    
      @Override
    public ResultSet selectAll(String table) {
        String req = "SELECT * FROM " + table+" where type='expert'";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
           
    }
        
    synchronized public int selectDisabledNumber() {
        int count = 0;
 
         try {
             String req = "SELECT * FROM user where type = 'expert' ";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
         //System.out.println("count");
        return count;
       
}
    

    @Override
    public void ajouter(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object select(String table, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
