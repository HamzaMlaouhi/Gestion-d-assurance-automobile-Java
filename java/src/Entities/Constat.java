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
public class Constat {
    private int code_rec ;
    private String Croquis;
    private String Matricule_autrui;

    public Constat(int code_rec, String Croquis, String Matricule_autrui) {
        this.code_rec = code_rec;
        this.Croquis = Croquis;
        this.Matricule_autrui = Matricule_autrui;
    }

    public Constat() {
 
    }

 



    public int getCode_rec() {
        return code_rec;
    }

    public void setCode_rec(int code_rec) {
        this.code_rec = code_rec;
    }

    public String getCroquis() {
        return Croquis;
    }

    public void setCroquis(String Croquis) {
        this.Croquis = Croquis;
    }

    public String getMatricule_autrui() {
        return Matricule_autrui;
    }

    public void setMatricule_autrui(String Matricule_autrui) {
        this.Matricule_autrui = Matricule_autrui;
    }
    
   
}


