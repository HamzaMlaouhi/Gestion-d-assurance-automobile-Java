/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azizi
 */
public class Temoin {
//    private int sinistre_id;
    private String CinT;
    private String NomT;
    private String PrenomT;
    private String TelT;
    private String Description;

    public Temoin(String NomT, String PrenomT, String TelT, String Description) {
        this.NomT = NomT;
        this.PrenomT = PrenomT;
        this.TelT = TelT;
        this.Description = Description;
    }

    public Temoin(String CinT, String NomT, String PrenomT, String TelT, String Description) {
        this.CinT = CinT;
        this.NomT = NomT;
        this.PrenomT = PrenomT;
        this.TelT = TelT;
        this.Description = Description;
    }

    public Temoin() {
    }

    public String getCinT() {
        return CinT;
    }

    public void setCinT(String CinT) {
        this.CinT = CinT;
    }

    public String getNomT() {
        return NomT;
    }

    public void setNomT(String NomT) {
        this.NomT = NomT;
    }

    public String getPrenomT() {
        return PrenomT;
    }

    public void setPrenomT(String PrenomT) {
        this.PrenomT = PrenomT;
    }

    public String getTelT() {
        return TelT;
    }

    public void setTelT(String TelT) {
        this.TelT = TelT;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

   
    }
 
 