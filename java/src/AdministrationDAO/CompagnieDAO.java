/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrationDAO;

import Entities.Compagnie;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmoud
 */
public class CompagnieDAO {

    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public CompagnieDAO() {
    }

    public void AjoutCompagnie(Entities.Compagnie o) {
        String nomC;
        String adr;
        String Wsite;
        int num;
        int faxe;
        String email;
        String userName;
        String type = "compagnie";
        nomC = o.getNomCompagnie();
        adr = o.getAdresse();
        Wsite = o.getSite();

        email = o.getMail();
        userName = o.getUname();
//        if(this.fixe.getText().length()!=8 || this.fax.getText().length()!=8)
//            //Boîte du message d'erreur
//           JOptionPane.showMessageDialog(null, "taille tel ou fix invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
//        else{
        try {
            num = Integer.parseInt(o.getFixe());
            faxe = Integer.parseInt(o.getFax());
            String req = "INSERT INTO user(username,email,nom_compagnie,adresse,Fax,fixe,site,type,username_canonical,email_canonical,enabled,password)"
                    + "VALUES('" + userName + "','" + email + "','" + nomC + "','" + adr + "','" + faxe + "','" + num + "','" + Wsite + "','" + type + "','" + userName + "','" + email + "','1','12345')";
            st = cn.createStatement();
            st.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "Ajouter !!", "Information", JOptionPane.INFORMATION_MESSAGE);
            //GestCompagnie gstC = new GestCompagnie();
            // gstC.setVisible(true);
        } catch (SQLException ex) {
            // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ModifierCompagnie(Entities.Compagnie o) {
        String nomC;
        String adr;
        String Wsite;
        int num;
        int faxe;
        String email;
        String userName;
        String type = "compagnie";
        String ID = o.getId();
        nomC = o.getNomCompagnie();
        adr = o.getAdresse();
        Wsite = o.getSite();
        email = o.getMail();
        userName = o.getUname();
        try {
            num = Integer.parseInt(o.getFixe());
            faxe = Integer.parseInt(o.getFax());
            String req = "update user set username='" + userName + "',email='" + email + "',nom_compagnie='" + nomC + "',adresse='" + adr + "',Fax='" + faxe + "',fixe='" + num + "',site='" + Wsite + "' "
                    + "where id='" + ID + "'";
            st = cn.createStatement();
            st.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "Mettre a jour  !!", "Information", JOptionPane.INFORMATION_MESSAGE);
            //GestCompagnie gstC = new GestCompagnie();
            // gstC.setVisible(true);
        } catch (SQLException ex) {
            // Logger.getLogger(AddCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteAction(String nomC) {
        Component frame = null;

        String query = "delete from user where nom_compagnie = '" + nomC + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(query);

            //ne9ssa Dialoge d'info
            JOptionPane.showMessageDialog(frame, "Deleted");

        } catch (SQLException ex) {
            //Logger.getLogger(ResCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet selectAll() {
        String req = "SELECT * FROM user where type ='compagnie'";
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
            String req = "SELECT * FROM user where type ='compagnie'";

            st = cn.createStatement();
            ResultSet xx = st.executeQuery(req);

            while (xx.next()) {
                count++;

            }

        } catch (SQLException ex) {

        }
        return count;

    }

    public ObservableList<Entities.Compagnie> RechercheParAdresse(String recherche) {
        ObservableList<Entities.Compagnie> data = FXCollections.observableArrayList();

        try {
            String query = "select * from user WHERE adresse LIKE '%" + recherche + "%' and type = 'compagnie'";
            st = cn.createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Compagnie comp = new Compagnie();

                comp.setNomCompagnie(rest.getString("nom_compagnie"));
                comp.setAdresse(rest.getString("adresse"));
                comp.setFixe(rest.getString("Tel"));
                comp.setFax(rest.getString("Fax"));
                comp.setSite(rest.getString("site"));
                comp.setId(rest.getString("id"));
                
                data.add(comp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }
}
