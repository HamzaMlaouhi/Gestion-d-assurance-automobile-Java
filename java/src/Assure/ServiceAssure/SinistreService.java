/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;

import Entities.Sinistre;
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
public class SinistreService implements Crud{
  private Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    
    

    public void ajoutersinistre(Entities.Sinistre r) {
   
    Date date_declaration;
    String lieu_sinistre;
    String dommage_corps;
    String cin_conducteur;
    String dommage_materiel;
    int contrat_id;
    String modele_id;
    
   date_declaration =r.getDate_declaration();
           lieu_sinistre=r.getLieu_sinistre();
           dommage_corps=r.getDommage_corps();
                   cin_conducteur=r.getCin_conducteur();
                   dommage_materiel=r.getDommage_materiel();
                           contrat_id=r.getContrat_id();
                           modele_id=r.getModele_id();
         
            try {
                
                String req="INSERT INTO sinistre(date_declaration,lieu_sinistre,dommage_corps,cin_conducteur,dommage_materiel,contrat_id,modele_id)"
                        + "VALUES('"+date_declaration + "','"+lieu_sinistre+"','"+dommage_corps+"','"+cin_conducteur+"','"+dommage_materiel+"','1','gzf')";
                System.out.println(req);
                st = cn.createStatement();
                
               st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(SinistreService.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectAll(String table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
