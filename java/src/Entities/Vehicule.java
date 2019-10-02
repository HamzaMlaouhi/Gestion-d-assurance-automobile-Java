/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Skander
 */
public class Vehicule {
    private String chassis;
    private String modele;
    private int ref_contrat_id;
    private Date date_circule ; 
    private int puissance ; 
    private String carburant ;
    private int nombre_pneu;
    private double val_venale;
    private double prime_rc_id;

    public Vehicule() {
    }

   
    

    public Vehicule(String chassis, String modele, int ref_contrat_id, Date date_circule, int puissance, String carburant, int nombre_pneu, double val_venale, double prime_rc_id) {
        this.chassis = chassis;
        this.modele = modele;
        this.ref_contrat_id = ref_contrat_id;
        this.date_circule = date_circule;
        this.puissance = puissance;
        this.carburant = carburant;
        this.nombre_pneu = nombre_pneu;
        this.val_venale = val_venale;
        this.prime_rc_id = prime_rc_id;
    }

    public Vehicule(Date date_circule,String chassis ,int puissance, String carburant, int nombre_pneu, double val_venale, double prime_rc_id) {
        this.date_circule = date_circule;
        this.chassis=chassis;
        this.puissance = puissance;
        this.carburant = carburant;
        this.nombre_pneu = nombre_pneu;
        this.val_venale = val_venale;
        this.prime_rc_id = prime_rc_id;
    }

 

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getRef_contrat_id() {
        return ref_contrat_id;
    }

    public void setRef_contrat_id(int ref_contrat_id) {
        this.ref_contrat_id = ref_contrat_id;
    }

    public Date getDate_circule() {
        return date_circule;
    }

    public void setDate_circule(Date date_circule) {
        this.date_circule = date_circule;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public int getNombre_pneu() {
        return nombre_pneu;
    }

    public void setNombre_pneu(int nombre_pneu) {
        this.nombre_pneu = nombre_pneu;
    }

    public double getVal_venale() {
        return val_venale;
    }

    public void setVal_venale(double val_venale) {
        this.val_venale = val_venale;
    }

    public double getPrime_rc_id() {
        return prime_rc_id;
    }

    public void setPrime_rc_id(double prime_rc_id) {
        this.prime_rc_id = prime_rc_id;
    }




    

    
}
