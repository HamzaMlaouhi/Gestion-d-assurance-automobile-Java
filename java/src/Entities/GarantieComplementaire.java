/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author BahaEddine
 */
public class GarantieComplementaire {
    private int id;
    private String nom;
    private double tarifDeBase;
    private double nivFranchise;
    private double primeDeBase;
    private double surprime;

    public GarantieComplementaire(String nom, double tarifDeBase, double nivFranchise, double primeDeBase, double surprime) {
        this.nom = nom;
        this.tarifDeBase = tarifDeBase;
        this.nivFranchise = nivFranchise;
        this.primeDeBase = primeDeBase;
        this.surprime = surprime;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTarifDeBase() {
        return tarifDeBase;
    }

    public void setTarifDeBase(double tarifDeBase) {
        this.tarifDeBase = tarifDeBase;
    }

    public double getNivFranchise() {
        return nivFranchise;
    }

    public void setNivFranchise(double nivFranchise) {
        this.nivFranchise = nivFranchise;
    }

    public double getPrimeDeBase() {
        return primeDeBase;
    }

    public void setPrimeDeBase(double primeDeBase) {
        this.primeDeBase = primeDeBase;
    }

    public double getSurprime() {
        return surprime;
    }

    public void setSurprime(double surprime) {
        this.surprime = surprime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
