package Courtier;

/**
 *
 * @author Mohamed
 */
public class GarantieComplementaire {
    private int id;
    private String nom_compagnie;
    private double tarif_de_base;
    private double prime_de_base;
    private String nom_garantie;

    public GarantieComplementaire() {
    }

    public GarantieComplementaire(int id, String nom_compagnie, double tarif_de_base, double prime_de_base, String nom_garantie) {
        this.id = id;
        this.nom_compagnie = nom_compagnie;
        this.tarif_de_base = tarif_de_base;
        this.prime_de_base = prime_de_base;
        this.nom_garantie = nom_garantie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_compagnie() {
        return nom_compagnie;
    }

    public void setNom_compagnie(String nom_compagnie) {
        this.nom_compagnie = nom_compagnie;
    }

    public double getTarif_de_base() {
        return tarif_de_base;
    }

    public void setTarif_de_base(double tarif_de_base) {
        this.tarif_de_base = tarif_de_base;
    }

    public double getPrime_de_base() {
        return prime_de_base;
    }

    public void setPrime_de_base(double prime_de_base) {
        this.prime_de_base = prime_de_base;
    }

    public String getNom_garantie() {
        return nom_garantie;
    }

    public void setNom_garantie(String nom_garantie) {
        this.nom_garantie = nom_garantie;
    }
    
    
}
