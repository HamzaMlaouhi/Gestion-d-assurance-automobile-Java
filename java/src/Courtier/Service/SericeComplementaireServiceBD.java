package Courtier.Service;

import Courtier.PoliceEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mohamed
 */
public class SericeComplementaireServiceBD {

    private Connection cn = Utils.Database.getInstance().getConnection();

    public Object select(String table, int id) {
        String req = "SELECT * FROM " + table + " WHERE id=" + String.valueOf(id) + ";";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet result = st.executeQuery(req);
            PoliceEntity gc = result.getObject(0, PoliceEntity.class);
            return gc;
        } catch (SQLException ex) {
            return null;
        }

    }

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

    public ResultSet chercherParUnCritere(String table, String critere) {
        String req = "SELECT * FROM garantie_complementaire where nom_garantie ='" + critere + "'";
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParNomCompagnie(String table, String critere) {
        String req = "SELECT * FROM garantie_complementaire where nom_compagnie ='" + critere + "'";
        // System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParDeuxCritere(String table, String critereUn, String critereDeux) {
        String req = "SELECT * FROM garantie_complementaire WHERE nom_garantie ='" + critereUn + "' OR nom_garantie = '" + critereDeux + "'";
        //System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParTroisCritere(String table, String critereUn, String critereDeux, String critereTrois) {
        String req = "SELECT * FROM garantie_complementaire WHERE nom_garantie ='" + critereUn + "' OR nom_garantie = '" + critereDeux + "' OR nom_garantie='" + critereTrois + "'";
        //System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParPrimeSuperieurA(String table, int critere) {
        String req = "SELECT * FROM garantie_complementaire where prime_de_base >= '" + critere + "'";
        System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParPrimeInferieurA(String table, double critere) {
        String req = "SELECT * FROM garantie_complementaire where prime_de_base <= '" + critere + "'";
        System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParTarifSuperieurA(String table, int critere) {
        String req = "SELECT * FROM garantie_complementaire where tarif_de_base >= '" + critere + "'";
        //System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet chercherParTarifInferieurA(String table, int critere) {
        String req = "SELECT * FROM garantie_complementaire where tarif_de_base <= '" + critere + "'";
        //System.out.println(req);
        Statement st;
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

}
