/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;

import Entities.Constat;
import Entities.Reclamation;
import Shared.Crud;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author azizi
 */
public class ConstatService implements Crud{
    
     Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    
    public ConstatService(){
        
    }
   
    public int AjouterConstat(Entities.Constat c){
     int code_rec;
     String Croquis;
     String Matricule_autrui;
     
     code_rec =c.getCode_rec();
     Croquis = c.getCroquis();
     Matricule_autrui=c.getMatricule_autrui();
     
       
            try {
                
                String req="INSERT INTO constat(code_rec,Croquis,Matricule_autrui)"
                        + "VALUES('10','"+Croquis+"','"+Matricule_autrui+"')";
                
                st = cn.createStatement();
                
               return st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ConstatService.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        return 0;
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
        Constat r = (Constat) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(r.getCode_rec()) + ";";
        Statement st;
        try {
            st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public Object select(String table, int id) {
String req = "SELECT * FROM " + table + " WHERE id=" + String.valueOf(id) + ";";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet result = st.executeQuery(req);
            Reclamation r = result.getObject(0, Reclamation.class);
            return r;
        } catch (SQLException ex) {
            return null;
        }
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
        }    }
    
}
