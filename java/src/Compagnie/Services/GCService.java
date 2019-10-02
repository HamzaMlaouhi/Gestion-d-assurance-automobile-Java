/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Services;

import Entities.GarantieComplementaire;
import Shared.Crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BahaEddine
 */
public class GCService implements Crud {

    Connection cn = Utils.Database.getInstance().getConnection();

    @Override
    public void ajouter(String table, Object obj) {
        GarantieComplementaire gc = (GarantieComplementaire) obj;

        try {
            String req = "INSERT INTO " + table + "(tarif_de_base,niv_franchise,prime_de_base,nom,surprime) VALUES(" + gc.getTarifDeBase() + "," + gc.getNivFranchise() + "," + gc.getPrimeDeBase() + ",'" + gc.getNom() + "'," + gc.getSurprime() + ")";
            Statement st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String table, Object obj) {
        GarantieComplementaire gc = (GarantieComplementaire) obj;
        String req = "UPDATE "+table+" set "+
                "nom = "+gc.getNom()+","+
                "tarif_de_base = "+gc.getTarifDeBase()+","+
                "niv_franchise = "+gc.getNivFranchise()+","+
                "prime_de_base = "+gc.getPrimeDeBase()+","+
                "surprime = "+gc.getSurprime()+";";
        try{
            Statement st = cn.createStatement();
            st.execute(req);
        }catch(SQLException ex){
            Logger.getLogger(GCService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String table, Object obj) {
        GarantieComplementaire gc = (GarantieComplementaire) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(gc.getId()) + ";";
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
            GarantieComplementaire gc = result.getObject(0, GarantieComplementaire.class);
            return gc;
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
        String req = "SELECT * FROM garantie_complementaire WHERE nom LIKE '%"+critere+"%'";
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
}
