/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert.PrivateEntity;

/**
 *
 * @author HP
 */
public class RatingEntity {
    private int id_compagnie;
    private String nom_compagnie;
    private double rating;

    public RatingEntity(int id_compagnie,String nom, double rating) {
        this.id_compagnie = id_compagnie;
        this.rating = rating;
        this.nom_compagnie = nom;
    }

    public int getId_compagnie() {
        return id_compagnie;
    }

    public void setId_compagnie(int id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getNom_compagnie() {
        return nom_compagnie;
    }

    public void setNom_compagnie(String nom_compagnie) {
        this.nom_compagnie = nom_compagnie;
    }
    
    
}
