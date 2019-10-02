/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Mahmoud
 */
public class Expert {
     private String nom;
    private String id;
    private String prenom;
    private String zone;
    private String tel;
    private String cin;
    private String mail;
    private String Uname;
    private int enabled;

    
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Expert(String nom, String id, String prenom, String zone, String tel, String cin, String mail, String Uname, int enabled) {
        this.nom = nom;
        this.id = id;
        this.prenom = prenom;
        this.zone = zone;
        this.tel = tel;
        this.cin = cin;
        this.mail = mail;
        this.Uname = Uname;
        this.enabled = enabled;
    }
    
    

    public Expert(String nom, String id, String prenom, String zone, String tel, String cin, String mail, String Uname) {
        this.nom = nom;
        this.id = id;
        this.prenom = prenom;
        this.zone = zone;
        this.tel = tel;
        this.cin = cin;
        this.mail = mail;
        this.Uname = Uname;
    }

    public Expert(String nom, String prenom, String zone, String tel, String cin, String mail, String Uname) {
        this.nom = nom;
        this.prenom = prenom;
        this.zone = zone;
        this.tel = tel;
        this.cin = cin;
        this.mail = mail;
        this.Uname = Uname;
    }

    public Expert(String string, String string0, String string1, String string2,String string3,String string4) {
            this.cin =string ;
            this.nom = string0;
            this.prenom = string1;
            this.zone = string2;
            this.tel = string3;
            this.mail = string4;
    }
    
    public Expert(String string, String string0, String string1, String string2,String string3) {
            this.cin =string ;
            this.nom = string0;
            this.prenom = string1;
            this.zone = string2;
            this.tel = string3;
       
    }
    
    

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
    }

    

    public Expert() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
    
    
    
}
