/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;


import Entities.Reclamation;
import Shared.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azizi
 */
public class ReclamationService implements Crud{
     private Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    
    public ReclamationService(){
        
    }
    public void AjouterReclamtion(Entities.Reclamation r){
         
          String code_sinistre_id;
          Date date_rec; 
          String lieu_rec;
          String objet_rec;
          String commentaire_rec;
         
         code_sinistre_id =r.getCode_sinistre_id();
         date_rec =r.getDate_rec();
         lieu_rec=r.getLieu_rec();
         objet_rec=r.getObjet_rec();
         commentaire_rec=r.getCommentaire_rec();
         
            try {
                
                String req="INSERT INTO reclamation(date_rec,lieu_rec,objet_rec,commentaire_rec,code_sinistre_id)"
                        + "VALUES('"+date_rec + "','"+lieu_rec+"','"+objet_rec+"','"+commentaire_rec+"','1')";
                System.out.println(req);
                st = cn.createStatement();
                
               st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
    Reclamation r = (Reclamation) obj;
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
        }
    }
      
    public ResultSet chercher(String critere){
        String req = "SELECT * FROM reclamation WHERE lieu_rec LIKE '%"+critere+"%'";
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
     
    public int selectcountr() {
        
           int count = 0;
      
        try {
             String req ="SELECT * FROM reclamation  " ;
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
    
    }
    
    
    
    
    
    
    
