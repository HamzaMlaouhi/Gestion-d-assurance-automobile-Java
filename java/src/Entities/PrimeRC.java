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
public class PrimeRC {
    private String puissance;
    private String id;
    private String prix;

    public PrimeRC(String puissance, String id, String prix) {
        this.puissance = puissance;
        this.id = id;
        this.prix = prix;
    }

    public PrimeRC() {
    }

    public PrimeRC(String puissance, String prix) {
        this.puissance = puissance;
        this.prix = prix;
    }
    
    

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
    
}
