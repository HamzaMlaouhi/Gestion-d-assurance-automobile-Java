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
public class Agence {
    private int id;
    private String zone;
    private int tel;
    private int fax;
    private int nbrEmp;

    public Agence(String zone, int tel, int fax, int nbrEmp) {
        this.zone = zone;
        this.tel = tel;
        this.fax = fax;
        this.nbrEmp = nbrEmp;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public int getNbrEmp() {
        return nbrEmp;
    }

    public void setNbrEmp(int nbrEmp) {
        this.nbrEmp = nbrEmp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
