/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert.Service;



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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ReclamationDAO implements Crud {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    public ReclamationDAO() {
    }
    
    public int AjoutRapport(Entities.Reclamation o){
        String titre_rap, detaille_rap;
       Date date_rap;
        date_rap=o.getDate_rap();
        titre_rap=o.getTitre_rap();
        detaille_rap=o.getDetaille_rap();
            try {
                
                String req="INSERT INTO reclamation(date_rap,titre_rap,detaille_rap)"
                        + "VALUES('"+date_rap + "','"+titre_rap+"','"+detaille_rap+"')";
                
                st = cn.createStatement();
                
               return st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }


   // @Override
    public void update(Object obj) {
        Reclamation gc = (Reclamation) obj;
        String req = "UPDATE reclamation set titre_rap = '"+gc.getTitre_rap()+"',detaille_rap='"+gc.getDetaille_rap()+"'";
        try{
            Statement st = cn.createStatement();
            st.execute(req);
           
        }catch(SQLException ex){
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @Override
    public void delete(String table, Object obj) {
         Reclamation r = (Reclamation) obj;
        String req = "Delete FROM reclamation WHERE detaille_rap='" + r.getDetaille_rap()+ "'";
        System.out.println(req);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void ajouter(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet chercher(String table, String code) {
        String req = "SELECT * FROM reclamation where code_rec ='"+code+"'";
         Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
         
   }
    public ObservableList<Entities.Reclamation> RechercheParLieu(String recherche) {
        ObservableList<Entities.Reclamation> data = FXCollections.observableArrayList();

        try {
            String query = "select * from reclamation WHERE lieu_rec LIKE '%" + recherche + "%' ";
            st = cn.createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Reclamation comp = new Reclamation();

                comp.setCode_rec(rest.getInt("Code_rec"));
                comp.setDate_rec(rest.getDate("date_rec"));
                comp.setLieu_rec(rest.getString("lieu_rec"));
                comp.setObjet_rec(rest.getString("objet_rec"));
                comp.setCommentaire_rec(rest.getString("commentaire_rec"));
                data.add(comp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

    @Override
    public void update(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}