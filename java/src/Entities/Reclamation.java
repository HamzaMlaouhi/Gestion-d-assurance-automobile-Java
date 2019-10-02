package Entities;

import java.util.Date;

/**
 *
 * @author HP
 */

public class Reclamation {
    private int code_rec;
    private String code_sinistre_id;
    private String commentaire_rec;
    private Date date_rap;
    private Date date_rec;
    private String detaille_rap;
    private String dtype;
    private String expert_id;
    private String image_name;
    private String lieu_rec;
    private String objet_rec;
    private String temp_rap;
    private String titre_rap;

    public Reclamation(int code_rec, String code_sinistre_id, String commentaire_rec, Date date_rap, Date date_rec, String detaille_rap, String dtype, String expert_id, String image_name, String lieu_rec, String objet_rec, String temp_rap, String titre_rap) {
        this.code_rec = code_rec;
        this.code_sinistre_id = code_sinistre_id;
        this.commentaire_rec = commentaire_rec;
        this.date_rap = date_rap;
        this.date_rec = date_rec;
        this.detaille_rap = detaille_rap;
        this.dtype = dtype;
        this.expert_id = expert_id;
        this.image_name = image_name;
        this.lieu_rec = lieu_rec;
        this.objet_rec = objet_rec;
        this.temp_rap = temp_rap;
        this.titre_rap = titre_rap;
    }

    public Reclamation(String code_sinistre_id, String commentaire_rec, Date date_rec, String lieu_rec, String objet_rec) {
        this.code_sinistre_id = code_sinistre_id;
        this.commentaire_rec = commentaire_rec;
        this.date_rec = date_rec;
        this.lieu_rec = lieu_rec;
        this.objet_rec = objet_rec;
    }

    public Reclamation(String commentaire_rec, Date date_rec, String lieu_rec, String objet_rec) {
        this.commentaire_rec = commentaire_rec;
        this.date_rec = date_rec;
        this.lieu_rec = lieu_rec;
        this.objet_rec = objet_rec;
    }
    

    
    public Reclamation() {
    }

  

    public int getCode_rec() {
        return code_rec;
    }

 

    public void setCode_rec(int code_rec) {
        this.code_rec = code_rec;
    }

    public String getCode_sinistre_id() {
        return code_sinistre_id;
    }

    public void setCode_sinistre_id(String code_sinistre_id) {
        this.code_sinistre_id = code_sinistre_id;
    }

    public String getCommentaire_rec() {
        return commentaire_rec;
    }

    public void setCommentaire_rec(String commentaire_rec) {
        this.commentaire_rec = commentaire_rec;
    }

    public Date getDate_rap() {
        return date_rap;
    }

    public void setDate_rap(Date date_rap) {
        this.date_rap = date_rap;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public String getDetaille_rap() {
        return detaille_rap;
    }

    public void setDetaille_rap(String detaille_rap) {
        this.detaille_rap = detaille_rap;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(String expert_id) {
        this.expert_id = expert_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getLieu_rec() {
        return lieu_rec;
    }

    public void setLieu_rec(String lieu_rec) {
        this.lieu_rec = lieu_rec;
    }

    public String getObjet_rec() {
        return objet_rec;
    }

    public void setObjet_rec(String objet_rec) {
        this.objet_rec = objet_rec;
    }

    public String getTemp_rap() {
        return temp_rap;
    }

    public void setTemp_rap(String temp_rap) {
        this.temp_rap = temp_rap;
    }

    public String getTitre_rap() {
        return titre_rap;
    }

    public void setTitre_rap(String titre_rap) {
        this.titre_rap = titre_rap;
    }

}
