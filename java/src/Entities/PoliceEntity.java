package Entities;

import Courtier.*;
import java.util.Date;

/**
 *
 * @author Mohamed
 */
public class PoliceEntity {

    private int id;
    private int code_assure_id;
    private int agence_id;
    private int classe;
    private Date date_effet_police;
    private Date date_echeance;
    private String statut;
    private String nature_contrat;
    private String usage_contrat;
    private double montant;
    private double coef_classe;

    public PoliceEntity() {
    }

    public PoliceEntity(int id, int code_assure, int agence_id, int classe, Date date_effet_police, Date date_echeance, String statut, String nature_contrat, String usage_contrat, double montant, double coef_classe) {
        this.id = id;
        this.code_assure_id = code_assure;
        this.agence_id = agence_id;
        this.classe = classe;
        this.date_effet_police = date_effet_police;
        this.date_echeance = date_echeance;
        this.statut = statut;
        this.nature_contrat = nature_contrat;
        this.usage_contrat = usage_contrat;
        this.montant = montant;
        this.coef_classe = coef_classe;
    }

    public PoliceEntity(int id, int code_assure) {
        this.id = id;
        this.code_assure_id = code_assure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_assure_id() {
        return code_assure_id;
    }

    public void setCode_assure_id(int code_assure) {
        this.code_assure_id = code_assure;
    }

    public int getAgence_id() {
        return agence_id;
    }

    public void setAgence_id(int agence_id) {
        this.agence_id = agence_id;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public Date getDate_effet_police() {
        return date_effet_police;
    }

    public void setDate_effet_police(Date date_effet_police) {
        this.date_effet_police = date_effet_police;
    }

    public Date getDate_echeance() {
        return date_echeance;
    }

    public void setDate_echeance(Date date_echeance) {
        this.date_echeance = date_echeance;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut_contrat) {
        this.statut = statut_contrat;
    }

    public String getNature_contrat() {
        return nature_contrat;
    }

    public void setNature_contrat(String nature_contrat) {
        this.nature_contrat = nature_contrat;
    }

    public String getUsage_contrat() {
        return usage_contrat;
    }

    public void setUsage_contrat(String usage_contrat) {
        this.usage_contrat = usage_contrat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getCoef_classe() {
        return coef_classe;
    }

    public void setCoef_classe(double coef_classe) {
        this.coef_classe = coef_classe;
    }

}
