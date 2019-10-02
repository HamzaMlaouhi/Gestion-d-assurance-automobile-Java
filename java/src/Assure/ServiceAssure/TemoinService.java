/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;

import Assure.ServiceAssure.TemoinService;
import Entities.Temoin;
import Shared.Crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azizi
 */
public class TemoinService implements Crud{
   private Connection cn = Utils.Database.getInstance().getConnection();
    @Override
    public void ajouter(String table, Object obj) {
    
        Temoin t=(Temoin)obj;
        
        try {
            String req = "INSERT INTO " + table + "(CinT,NomT,PrenomT,TelT,Description) VALUES('" +t.getCinT() + "','" + t.getNomT()+ "','" + t.getPrenomT() + "','" + t.getTelT() + "','" + t.getDescription() + "')";
            Statement st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(TemoinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
       String req = "SELECT * FROM " + table + " WHERE id=" + String.valueOf(id) + ";";
      
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet result = st.executeQuery(req);
            Temoin r = result.getObject(0, Temoin.class);
            return r;
        } catch (SQLException ex) {
            return null;
        }  
    }

    public int selectcount() {
        
           int count = 0;
      
        try {
             String req ="SELECT * FROM temoin  " ;
        Statement st;
            st = cn.createStatement();
            ResultSet xx = st.executeQuery(req);
             while (xx.next()) {
                 count++;
                 
             }
//            ResultSet resultc =st.executeQuery(req2);
//            Temoin r = resultc.getObject(0, Temoin.class);
//            return r;
        } catch (SQLException ex) {
        
        }  
        System.out.println(count);
            return count;
              
    }
    
    

   
    @Override
    public ResultSet selectAll(String table) {
           String req = "SELECT * FROM " + table;
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
