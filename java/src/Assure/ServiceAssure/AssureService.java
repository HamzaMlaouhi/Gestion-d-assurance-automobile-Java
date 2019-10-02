/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;

import Entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author azizi
 */
public class AssureService {
        Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public  AssureService(){
        
    }
    
    public void AssureService(Entities.Assure a){
        String chassisA;
     String modeleA;
     String puissanceA;
     String essenceA;
     String diselA;
     String resetA;
     String envoyerA;
     String valeurA;
     String type = "assure";
     
     /*chassisA=a.getChassis();
     modeleA=a.getModele();
     puissanceA=a.getPuissance();
     essenceA=a.getEssence();
     diselA=a.getDisel();
     envoyerA=a.getEnvoyer();
     valeurA=a.getValeur();*/
        try {
           //chassisA=Integer.parseInt(a.getChassis());
           //valeurA=Integer.parseInt(a.getValeur());
           //String req="INSERT INTO vehicule(chassis,modele,puissance,valeur,)"
                       // + "VALUES('"+chassisA + "','"+modeleA+"','"+puissanceA+"','"+valeurA+"','"+faxe+"','"+num+"','"+Wsite+"','"+type+"','"+userName+"','"+email+"','1','12345')";
                st = cn.createStatement();
                //st.executeUpdate(req);

        } catch (SQLException e) {
        }
     
    }

    public void AjouterReclamtion(Reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
