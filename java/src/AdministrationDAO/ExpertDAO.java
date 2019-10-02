/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrationDAO;


import Administration.SceneBuilder.AdminMailer;
import Entities.Compagnie;
import Entities.Expert;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmoud
 */
public class ExpertDAO {
     Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public ExpertDAO() {
    }
    
    public void AjouterExpert(Entities.Expert o)
    {
        String nomExp; String local; String Uname; String prenomExp; String email; String tel;
        String carte;
        String type="expert";
        nomExp=o.getNom();
        prenomExp=o.getPrenom();
        local=o.getZone();
        email=o.getMail();
        Uname=o.getUname();
        tel=o.getTel();
        carte=o.getCin();
        
        try {
               int telExp=Integer.parseInt(tel);
                String req="INSERT INTO user(username,email,nom_exp,zone_exp,type,username_canonical,email_canonical,enabled,password,cin_exp,prenom_exp,tel_exp)"
                        + "VALUES('"+Uname + "','"+email+"','"+nomExp+"','"+local+"','"+type+"','"+Uname+"','"+email+"','1','12345','"+carte+"','"+prenomExp+"','"+telExp+"')";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
                //GestExpert gstE = new GestExpert();
               // gstE.setVisible(true);
            } catch (SQLException ex) {
               // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public void ModifierExpert(Entities.Expert o)
    {
        String nomExp; String local; String Uname; String prenomExp; String email; String tel;
        String carte;
        String type="expert";
        nomExp=o.getNom();
        prenomExp=o.getPrenom();
        local=o.getZone();
        email=o.getMail();
        Uname=o.getUname();
        tel=o.getTel();
        carte=o.getCin();
        String ID = o.getId();
        
        try {
               int telExp=Integer.parseInt(tel);
                String req="UPDATE user set username='"+Uname + "',email='"+email+"',nom_exp='"+nomExp+"',zone_exp='"+local+"',cin_exp='"+carte+"',prenom_exp='"+prenomExp+"',tel_exp='"+telExp+"'"
                        + "where id ='"+ID+"'";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
               // GestExpert gstE = new GestExpert();
               // gstE.setVisible(true);
            } catch (SQLException ex) {
              //  Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void DeleteExpert(String Cin)
    {
        
        Component frame = null;
            String query = "delete from user where cin_exp = '"+Cin+"' and type='expert' ";
             try {
            st= cn.createStatement();
            st.executeUpdate(query);
   
            //ne9ssa Dialoge d'info
            JOptionPane.showMessageDialog(frame, "Deleted");
     
            } catch (SQLException ex) {
            //Logger.getLogger(ResCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet selectAll() {
        String req = "SELECT * FROM user where type ='expert' and enabled=1";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet selectDisabled() {
        String req = "SELECT * FROM user where type ='expert' and enabled=0";
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
             String req = "SELECT * FROM user where type = 'expert' and enabled=0";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
        return count;
       
}

    
    public void SetEnabled(String Cin,String mail)
    {
        
         try {
             Component frame = null;
             String query = "UPDATE user SET enabled = 1 WHERE cin_exp = '"+Cin+"'and type = 'expert'";
             
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

   

    public ObservableList<Expert> RechercheParZone(String recherche) {
        ObservableList<Entities.Expert> data = FXCollections.observableArrayList();

        try {
            String query = "select * from user WHERE zone_exp LIKE '%" + recherche + "%' and type = 'expert' and enabled='1'" ;
            st = cn.createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Expert expert = new Expert();

                expert.setNom(rest.getString("nom_exp"));
                expert.setPrenom(rest.getString("prenom_exp"));
                expert.setZone(rest.getString("zone_exp"));
                expert.setTel(rest.getString("tel_exp"));
                expert.setCin(rest.getString("cin_exp"));
                data.add(expert);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
    
