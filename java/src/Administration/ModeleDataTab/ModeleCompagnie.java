/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.ModeleDataTab;

import Entities.Compagnie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mahmoud
 */
public class ModeleCompagnie extends AbstractTableModel {
    Connection cn = Utils.Database.getInstance().getConnection();
    private Statement st;
    PreparedStatement pst;
    String[] entetes = {"ID", "Nom compagnie", "FAX", "FIXE", "Adresse" , "Site"};
    List<Entities.Compagnie> ls = new ArrayList<>();
    public ModeleCompagnie(){
        super();
        try {
            
            String req = " SELECT * FROM user where type='compagnie'";
            st= cn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Entities.Compagnie p = new Compagnie();
                p.setId(rs.getString("id"));
                p.setNomCompagnie(rs.getString("nom_compagnie"));
                p.setFax(rs.getString("Fax"));
                p.setFixe(rs.getString("fixe"));
                p.setSite(rs.getString("site"));
                p.setAdresse(rs.getString("adresse"));
                ls.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleCompagnie.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public int getRowCount() {
       return ls.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    @Override
     public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return ls.get(rowIndex).getId();
            case 1:
                return ls.get(rowIndex).getNomCompagnie();
            case 2:
                return ls.get(rowIndex).getFax();
            case 3:
                return ls.get(rowIndex).getFixe();
            case 4:
                return ls.get(rowIndex).getAdresse();
            case 5:
                return ls.get(rowIndex).getSite();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
}
