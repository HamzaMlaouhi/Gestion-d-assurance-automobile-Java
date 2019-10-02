/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author BahaEddine
 */
public class Police{
    private int id;
    private int codeAssure;
    private String assure;
    private int agenceId;
    private String agence;
    private int classe;
    private double coef;
    private Date dateEffet;
    private Date dateEcheance;
    private String nature;
    private String usage_contrat;

    public Police(int codeAssure, int agenceId, Date dateEffet, Date dateEcheance, String nature) {
        this.codeAssure = codeAssure;
        this.agenceId = agenceId;
        this.dateEffet = dateEffet;
        this.dateEcheance = dateEcheance;
        this.nature = nature;
    }

    public int getCodeAssure() {
        return codeAssure;
    }

    public void setCodeAssure(int codeAssure) {
        this.codeAssure = codeAssure;
    }

    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(int agenceId) {
        this.agenceId = agenceId;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getUsage_contrat() {
        return usage_contrat;
    }

    public void setUsage_contrat(String usage_contrat) {
        this.usage_contrat = usage_contrat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssure() {
        return assure;
    }

    public void setAssure(String assure) {
        this.assure = assure;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
    
    
}
