/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrationDAO;

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
public class PrimeRC_DAO {
      Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public PrimeRC_DAO() {
    }
    
    public void AjoutPrimeRC(Entities.PrimeRC o)
    {
        String puissF=o.getPuissance();
        String price=o.getPrix();
        
         try {
                String req="INSERT INTO primerc(puissance_fiscale,prix)"
                        + "VALUES('"+puissF + "','"+price+"')";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
                //GestPrimeRC gstPrime = new GestPrimeRC();
                //gstPrime.setVisible(true);
            } catch (SQLException ex) {
                //Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    public void ModifierPrimeRC(Entities.PrimeRC o)       
    {
        String puissF=o.getPuissance();
        String price=o.getPrix();
        String ID  = o.getId();
        
        try {
                String req="UPDATE primerc set puissance_fiscale='"+puissF + "',prix='"+price+"'"
                        + "where id='"+ID+"'";
                st = cn.createStatement();
                st.executeUpdate(req);
                JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
                //GestPrimeRC gstPrime = new GestPrimeRC();
                //gstPrime.setVisible(true);
            } catch (SQLException ex) {
               // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void DeletePrimeRC(String pss)
    {
        Component frame = null;
        String query = "delete from primerc where id = '"+pss+"'";
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
        String req = "SELECT * FROM primerc";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
          
          public int selectDisabledNumber() {
        int count = 0;
 
         try {
             String req = "SELECT * FROM primerc";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
        return count;
       
}
}
