/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence.Services;

import Compagnie.Services.GCService;
import Entities.Vehicule;
import Shared.Crud;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Skander
 */
public class VehiculeDAO implements Crud {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public VehiculeDAO() {
    }

      @Override
    public ResultSet selectAll(String table) {
        String req = "SELECT * FROM " + table;
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
             String req = "SELECT * FROM vehicule";
             
             st = cn.createStatement();
             ResultSet xx = st.executeQuery(req);
             
             while (xx.next()) {
                 count++;
                 
             }
             
                     } catch (SQLException ex) {
             
         }
        return count;
       
}
    
    public int AjoutVehicule(Entities.Vehicule o){
        String chassis = o.getChassis() ; 
        int ref_contrat = o.getRef_contrat_id() ;
        Date date_circulation = o.getDate_circule() ; 
        int puissance = o.getPuissance() ; 
        String carburant = o.getCarburant() ; 
        String modele = o.getModele() ; 
        int nbrPneu = o.getNombre_pneu() ; 
        double Val_venale = o.getVal_venale(); 
        double primeRc = o.getPrime_rc_id(); 
            try {
                
                String req="INSERT INTO vehicule (chassis, date_circule, puissance, carburant, nombre_pneu, val_venale, prime_rc_id, modele)"
                        + "VALUES('"+chassis+"','"+date_circulation+"', '"+puissance+"','"+carburant+"','"+nbrPneu+"','"+Val_venale+"','7','"+modele+"' )";
                
                st = cn.createStatement();
                
               return st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(VehiculeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


  

    @Override
    public Object select(String table, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DeleteAction(String chassis) {
            Component frame = null;
         
            String query = "delete from vehicule where chassis = '"+chassis+"'";
             try {
            st= cn.createStatement();
            st.executeUpdate(query);
   
            //ne9ssa Dialoge d'info
            JOptionPane.showMessageDialog(frame, "Deleted");
     
            } catch (SQLException ex) {
            //Logger.getLogger(ResCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModifierVehicule(Vehicule vehicule) {
         Vehicule o = (Vehicule) vehicule;
        String req="UPDATE vehicule set modele='"+o.getModele()+"',puissance='"+o.getPuissance()+"',carburant='"+o.getCarburant()+"' ,nombre_pneu='"+o.getNombre_pneu()+"'  , val_venale='"+o.getVal_venale()+"'  where chassis ='"+o.getChassis()+"'";
                                                                                                                                                                                      
        try{
            st = cn.createStatement();
            st.execute(req);
        }catch(SQLException ex){
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
