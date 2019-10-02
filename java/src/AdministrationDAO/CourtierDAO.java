/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrationDAO;


import Administration.SceneBuilder.AdminMailer;
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
 * @author Mahmoud
 */
public class CourtierDAO {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public CourtierDAO() {
    }
    
    public void AjoutCourtier(Entities.Courtier o)
    {
        String nomC; String local; String Uname; int flouss;String email; String commi;
        String carte;
        String userName; String type="courtier";
        nomC=o.getNom();
        local=o.getLieu();
        email=o.getMail();
        Uname=o.getUname();
        commi=o.getCommission();
        carte=o.getCin();
        try {
                flouss=Integer.parseInt(commi);
                String req="INSERT INTO user(username,email,nom,adresse,type,username_canonical,email_canonical,enabled,password,cin,commission)"
                        + "VALUES('"+Uname + "','"+email+"','"+nomC+"','"+local+"','"+type+"','"+Uname+"','"+email+"','1','12345','"+carte+"','"+flouss+"')";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
               // GestCourtier gstC = new GestCourtier();
                //gstC.setVisible(true);
            } catch (SQLException ex) {
               // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void ModifierCourtier(Entities.Courtier o)
    {
        String nomC; String local; String Uname; int flouss;String email; String commi;
        String carte;
                String type="courtier";
                String ID= o.getCin();
                nomC=o.getNom();
                local=o.getLieu();
                email=o.getMail();
                Uname=o.getUname();
                commi=o.getCommission();
                flouss=Integer.parseInt(commi);
         
          try {
                String req="UPDATE user set username='"+Uname + "',email='"+email+"',nom='"+nomC+"',adresse='"+local+"',commission='"+flouss+"'"
                        + "where id='"+ID+"'";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
               // GestCourtier gstC = new GestCourtier();
               // gstC.setVisible(true);
            } catch (SQLException ex) {
               // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void DeleteCourtier(String id)
    {
        try {
            Component frame = null;
            
//             TODO add your handling code here:


String query = "delete from user where cin = '"+id+"' and type = 'courtier' ";

                        st= cn.createStatement();
                        st.executeUpdate(query);

//ne9ssa Dialoge d'info
            JOptionPane.showMessageDialog(frame, "Deleted");
                 } catch (SQLException ex) {
                    Logger.getLogger(CourtierDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
     
                }

    public ResultSet selectAll() {
        String req = "SELECT * FROM user where type = 'courtier' and enabled=1";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet selectDisabled() {
        String req = "SELECT * FROM user where type = 'courtier' and enabled= 0";
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
             String req = "SELECT * FROM user where type = 'courtier' and enabled=0";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
        return count;
       
}
    
    public void SetEnabled(String id,String mail)
    {
        
         try {
             Component frame = null;
             String query = "UPDATE user SET enabled = 1 WHERE id = '"+id+"' and type = 'courtier'";
             
             st= cn.createStatement();
             st.executeUpdate(query);
             
             AdminMailer mailling = new AdminMailer();
             mailling.send(mail);
             
             
             //ne9ssa Dialoge d'info
             JOptionPane.showMessageDialog(frame, "Agent accepter et Un email Envoyer");
         } catch (SQLException ex) {
             Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     
          
    }
    
}

