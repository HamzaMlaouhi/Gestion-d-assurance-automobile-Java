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
public class Courtier {
    private String nom;
    private String id;
    private String lieu;
    private String commission;
    private String cin;
    private String mail;
    private String Uname;

    public Courtier(String nom, String id, String lieu, String commission, String cin, String mail, String Uname) {
        this.nom = nom;
        this.id = id;
        this.lieu = lieu;
        this.commission = commission;
        this.cin = cin;
        this.mail = mail;
        this.Uname = Uname;
    }

  

    public Courtier(String nom, String lieu, String commission, String cin, String mail, String Uname) {
        this.nom = nom;
        this.lieu = lieu;
        this.commission = commission;
        this.cin = cin;
        this.mail = mail;
        this.Uname = Uname;
    }

    public Courtier(String string, String string0, String string1, String string2, String string3) {
        this.id=string;
        this.nom=string0;
        this.lieu=string1;
        this.commission=string2;
        this.mail = string3;
    }
    
    public Courtier(String string, String string0, String string1, String string2) {
        this.id=string;
        this.nom=string0;
        this.lieu=string1;
        this.commission=string2;
    
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
    }

    

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Courtier() {
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }
    
  
    
}
