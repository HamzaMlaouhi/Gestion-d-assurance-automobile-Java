package Courtier.Service;

import Courtier.PoliceEntity;
import Shared.Crud;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class CourtierServiceBD implements Crud {

    private Connection cn = Utils.Database.getInstance().getConnection();

    @Override
    public void ajouter(String table, Object obj) {
        PoliceEntity police = (PoliceEntity) obj;
        System.out.println(police.getDate_effet_police());
        String req = "INSERT INTO " + table + "(code_assure_id, agence_id, date_effet_police, date_echeance, statut, montant, classe, coef_classe, nature, usage_contrat) VALUES("
                + police.getCode_assure() + "," + police.getAgence_id() + ",'" + police.getDate_effet_police() + "','" + police.getDate_echeance() + "','" + police.getStatut_contrat() + "'," + police.getMontant() + "," + police.getClasse() + ","
                + police.getCoef_classe() + ",'" + police.getNature_contrat() + "','" + police.getUsage_contrat() + "')";
        System.out.println(req);
        try {
            Statement st = cn.createStatement();
            st.execute(req);

        } catch (SQLException ex) {
            Logger.getLogger(CourtierServiceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String table, Object obj) {
        PoliceEntity police = (PoliceEntity) obj;
        String req = "Delete FROM " + table + " WHERE id=" + String.valueOf(police.getId()) + ";";
        Statement st;
        try {
            st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void delete2(int id) {
        String req = "Delete FROM police WHERE id=" + id + ";";
        Statement st;
        try {
            st = cn.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public PoliceEntity select(String table, int id) {
        String req = "SELECT * FROM " + table + " WHERE id=" + id + "";
        System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet result = st.executeQuery(req);
            PoliceEntity police = result.getObject(0, PoliceEntity.class);
            return police;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public ResultSet selectAll(String table) {
        String req = "SELECT * FROM " + table;
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public void updatePolice(PoliceEntity police) throws SQLException {
        int id = police.getId();
        int code_assure = police.getCode_assure();
        int agence_id = police.getAgence_id();
        int classe = police.getClasse();
        java.util.Date date_effet_police = police.getDate_effet_police();
        java.util.Date date_echeance = police.getDate_echeance();
        String statut_contrat = police.getStatut_contrat();
        String nature_contrat = police.getNature_contrat();
        String usage_contrat = police.getUsage_contrat();
        double montant = police.getMontant();
        double coef_classe = police.getCoef_classe();

        String req = "UPDATE police SET code_assure_id='" + code_assure + "', agence_id='" + agence_id + "', date_effet_police = '" + date_effet_police + "', date_echeance='" + date_echeance + "', statut ='" + statut_contrat + "', montant='" + montant + "', classe='" + classe + "', coef_classe='" + coef_classe + "', nature='" + nature_contrat + "', usage_contrat='" + usage_contrat + "' WHERE id = " + id + "";
        System.out.println(req);

        Statement st = cn.createStatement();
        st.execute(req);

    }

}
