/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence.Services;

import Compagnie.Services.GCService;
import Entities.Agent;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Skander
 */
public class AgentDAO {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public AgentDAO() {
    }
    
    public int AjoutAgent(Entities.Agent o){
        String cin = o.getCin(); 
        String nom = o.getNom() ;
        String prenom = o.getPrenom() ; 
        String Tel = o.getTel() ; 
        String Adresse = o.getAdresse() ; 
        String Uname = o.getUname() ; 
        String email = o.getEmail() ; 
        Integer enabled = o.getEnabled() ;
        
      
            try {
                
                String req="INSERT INTO user (cin,nom , prenom, Tel, Adresse, username, username_canonical, email, email_canonical, enabled, password, roles, type)"
                        + "VALUES('"+cin + "','"+nom+"', '"+prenom + "','"+Tel+"','"+Adresse+"','"+Uname + "','"+Uname+"', '"+email+ "','"+email+"','1' , '12345', 'a:1:{i:0;s:18:\"ROLE_AGENT_GENERAL\";}', 'agent' )";
                
                st = cn.createStatement();
                
               return st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(AgentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
    
        
    synchronized public int selectDisabledNumber() {
        int count = 0;
 
         try {
             String req = "SELECT * FROM user where type = 'agent' ";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
        return count;
       
}
    
     public void ModifierAgent(Object obj)
                
{
        Agent o = (Agent) obj;
        String req="UPDATE user set username='"+o.getUname() + "',email='"+o.getEmail()+"',nom='"+o.getNom()+"',prenom='"+o.getPrenom()+"' ,Tel='"+o.getTel()+"', adresse='"+o.getAdresse()+"' where cin ='"+o.getCin()+"'";
                        
        try{
            st = cn.createStatement();
            st.execute(req);
        }catch(SQLException ex){
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              
               //String req="UPDATE user set username='"+Uname + "',email='"+email+"',nom='"+nom+"',prenom='"+prenom+"' ,Tel='"+Tel+"', adresse='"+Adresse+"' "
                       // + "where cin ='"+cin+"' and type='agent'";
                    
    
     public ResultSet selectAll() {
        String req = "SELECT * FROM user where type ='agent'";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
     
     
      
      public void DeleteAction(String cin){
           Component frame = null;
         
            String query = "delete from user where cin = '"+cin+"'";
             try {
            st= cn.createStatement();
            st.executeUpdate(query);
   
            //ne9ssa Dialoge d'info
            JOptionPane.showMessageDialog(frame, "Deleted");
     
            } catch (SQLException ex) {
            //Logger.getLogger(ResCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}






