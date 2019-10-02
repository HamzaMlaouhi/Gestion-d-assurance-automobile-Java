/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure.ServiceAssure;

import Entities.Vehicule;
import Shared.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author azizi
 */
public class VehiculeService implements Crud{
 private Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    
    
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
     Vehicule r = (Vehicule) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(r.getChassis()) + ";";
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
            Vehicule r = result.getObject(0, Vehicule.class);
            return r;
        } catch (SQLException ex) {
            return null;
        }
    
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
    
     public ResultSet chercher(String critere){
        String req = "SELECT * FROM vehicule WHERE nom LIKE '%"+critere+"%'";
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
