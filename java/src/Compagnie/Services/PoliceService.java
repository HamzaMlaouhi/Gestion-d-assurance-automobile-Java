/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Services;

import Entities.Assure;
import Entities.GarantieComplementaire;
import Entities.Police;
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
public class PoliceService implements Crud{
Connection cn = Utils.Database.getInstance().getConnection();

    @Override
    public void ajouter(String table, Object obj) {
        Police p = (Police) obj;

        try {
            String req = "INSERT INTO " + table + "(tarif_de_base,niv_franchise,prime_de_base,nom,surprime) VALUES(";
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
        Assure p = (Assure) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(p.getId()) + ";";
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
            Police gc = result.getObject(0, Police.class);
            return gc;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public ResultSet selectAll(String table) {
        String id = Preferences.userRoot().node("user").get("id", "");
        String req = "SELECT p.id,a.nom as assure,a.id as code_assure_id,ag.zone as agence,ag.id as agence_id,p.date_effet_police,p.date_echeance,p.statut,p.montant,p.classe,p.coef_classe,p.nature,p.usage_contrat FROM agence ag,user a,police p WHERE ag.id=p.agence_id and a.id=p.code_assure_id and p.agence_id IN (SELECT id FROM agence where compagnie_id="+String.valueOf(id)+")";
        System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public ResultSet getSubscriptionDemands(){
        String id = Preferences.userRoot().node("user").get("id", "");
        String req = "SELECT id,username,email,cin,adresse,Tel,Gender,Profession,birthdate,Date_enreg FROM user WHERE id IN(SELECT code_assure_id from police where agence_id IN(SELECT id FROM agence WHERE compagnie_id="+id+")) and enabled = 0";
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void accept(Assure a){
        String req = "UPDATE user SET enabled = 1 WHERE id=" + String.valueOf(a.getId()) + ";";
        Statement st;
        try {
            st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public ResultSet chercher(String critere){
        String id = Preferences.userRoot().node("user").get("id", "");
        String req = "SELECT * FROM police WHERE date_effet_police Like '"+critere+"%' and agence_id IN (SELECT id from agence where compagnie_id="+id+")";
        System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }
}
