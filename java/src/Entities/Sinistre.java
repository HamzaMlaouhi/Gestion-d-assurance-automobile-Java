/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author azizi
 */
public class Sinistre {
  private int code;
    private int contrat_id;
    private String chassis_number;
    private String modele_id;
    private int reclamation_id;
    private Date date_declaration;
    private Date date_sinistre;
    private String lieu_sinistre;
    private String dommage_corps;
    private String cin_conducteur;
    private String dommage_materiel;

    public Sinistre(int code, int contrat_id, String chassis_number, String modele_id, int reclamation_id, Date date_declaration, Date date_sinistre, String lieu_sinistre, String dommage_corps, String cin_conducteur, String dommage_materiel) {
        this.code = code;
        this.contrat_id = contrat_id;
        this.chassis_number = chassis_number;
        this.modele_id = modele_id;
        this.reclamation_id = reclamation_id;
        this.date_declaration = date_declaration;
        this.date_sinistre = date_sinistre;
        this.lieu_sinistre = lieu_sinistre;
        this.dommage_corps = dommage_corps;
        this.cin_conducteur = cin_conducteur;
        this.dommage_materiel = dommage_materiel;
    }

    public Sinistre(int contrat_id, String chassis_number, String modele_id, int reclamation_id, Date date_declaration, Date date_sinistre, String lieu_sinistre, String dommage_corps, String cin_conducteur, String dommage_materiel) {
        this.contrat_id = contrat_id;
        this.chassis_number = chassis_number;
        this.modele_id = modele_id;
        this.reclamation_id = reclamation_id;
        this.date_declaration = date_declaration;
        this.date_sinistre = date_sinistre;
        this.lieu_sinistre = lieu_sinistre;
        this.dommage_corps = dommage_corps;
        this.cin_conducteur = cin_conducteur;
        this.dommage_materiel = dommage_materiel;
    }

    public Sinistre(int contrat_id, String modele_id, Date date_sinistre, String lieu_sinistre, String dommage_corps, String cin_conducteur, String dommage_materiel) {
        this.contrat_id = contrat_id;
        this.modele_id = modele_id;
        this.date_sinistre = date_sinistre;
        this.lieu_sinistre = lieu_sinistre;
        this.dommage_corps = dommage_corps;
        this.cin_conducteur = cin_conducteur;
        this.dommage_materiel = dommage_materiel;
    }

    public Sinistre() {
    }
 
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getContrat_id() {
        return contrat_id;
    }

    public void setContrat_id(int contrat_id) {
        this.contrat_id = contrat_id;
    }

    public String getChassis_number() {
        return chassis_number;
    }

    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public String getModele_id() {
        return modele_id;
    }

    public void setModele_id(String modele_id) {
        this.modele_id = modele_id;
    }

    public int getReclamation_id() {
        return reclamation_id;
    }

    public void setReclamation_id(int reclamation_id) {
        this.reclamation_id = reclamation_id;
    }

    public Date getDate_declaration() {
        return date_declaration;
    }

    public void setDate_declaration(Date date_declaration) {
        this.date_declaration = date_declaration;
    }

    public Date getDate_sinistre() {
        return date_sinistre;
    }

    public void setDate_sinistre(Date date_sinistre) {
        this.date_sinistre = date_sinistre;
    }

    public String getLieu_sinistre() {
        return lieu_sinistre;
    }

    public void setLieu_sinistre(String lieu_sinistre) {
        this.lieu_sinistre = lieu_sinistre;
    }

    public String getDommage_corps() {
        return dommage_corps;
    }

    public void setDommage_corps(String dommage_corps) {
        this.dommage_corps = dommage_corps;
    }

    public String getCin_conducteur() {
        return cin_conducteur;
    }

    public void setCin_conducteur(String cin_conducteur) {
        this.cin_conducteur = cin_conducteur;
    }

    public String getDommage_materiel() {
        return dommage_materiel;
    }

    public void setDommage_materiel(String dommage_materiel) {
        this.dommage_materiel = dommage_materiel;
    }
    
   
}
