/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Services;

import Entities.Agence;
import Shared.Crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 *
 * @author BahaEddine
 */
public class AgenceService implements Crud{

    private Connection cn = Utils.Database.getInstance().getConnection();

    @Override
    public void ajouter(String table, Object obj) {
        Agence agence = (Agence) obj;
        String id = Preferences.userRoot().node("user").get("id", "");
        try {
            String req = "INSERT INTO " + table + "(compagnie_id,zone,telephone,nbr_employer,fax) VALUES("+id+",'"+ agence.getZone() + "'," + agence.getTel() + "," + agence.getNbrEmp() + ",'" + agence.getFax() + "')";
            Statement st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String table, Object obj) {
        Agence agence = (Agence) obj;
        String req = "UPDATE "+table+" set "+
                "zone = '"+agence.getZone()+"',"+
                "telephone = '"+agence.getTel()+"',"+
                "nbr_employer = '"+agence.getNbrEmp()+"',"+
                "fax = "+agence.getFax()+" where id = "+agence.getId();
        try{
            Statement st = cn.createStatement();
            st.execute(req);
        }catch(SQLException ex){
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String table, Object obj) {
        Agence agence = (Agence) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(agence.getId()) + ";";
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
            Agence gc = result.getObject(0, Agence.class);
            return gc;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public ResultSet selectAll(String table) {
        String id = Preferences.userRoot().node("user").get("id", "");
        String req = "SELECT * FROM " + table + " WHERE compagnie_id="+id;
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercher(String critere){
        String id = Preferences.userRoot().node("user").get("id", "");
        String req = "SELECT * FROM agence WHERE zone LIKE '%"+critere+"%' and compagnie_id="+id;
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
}
