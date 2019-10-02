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
public class Compagnie {
    private String nomCompagnie;
    private String id;
    private String adresse;
    private String fixe;
    private String fax;
    private String site;
    private String Uname;
    private String mail;

    public Compagnie(String nomCompagnie,  String adresse, String fixe, String fax, String site, String Uname, String mail) {
        this.nomCompagnie = nomCompagnie;
        this.adresse = adresse;
        this.fixe = fixe;
        this.fax = fax;
        this.site = site;
        this.Uname = Uname;
        this.mail = mail;
    }

    public Compagnie(String nomCompagnie, String id, String adresse, String fixe, String fax, String site, String Uname, String mail) {
        this.nomCompagnie = nomCompagnie;
        this.id = id;
        this.adresse = adresse;
        this.fixe = fixe;
        this.fax = fax;
        this.site = site;
        this.Uname = Uname;
        this.mail = mail;
    }

    public Compagnie(String string, String string0, String string1, String string2, String string3, String string4) {
        this.id=string;
        this.nomCompagnie=string0;
        this.adresse=string1;
        this.fixe=string2;
        this.fax=string3;
        this.site=string4;
                
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

    



    public Compagnie() {
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    
    
    
}
