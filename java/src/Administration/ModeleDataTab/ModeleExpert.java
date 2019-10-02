/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.ModeleDataTab;

import Entities.Courtier;
import Entities.Expert;
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
public class ModeleExpert extends AbstractTableModel {
    
    Connection cn = Utils.Database.getInstance().getConnection();
    private Statement st;
    PreparedStatement pst;
    String[] entetes = {"ID", "Nom", "Prenom","CIN", "Zone","Tel"};
    List<Entities.Expert> ls = new ArrayList<>();

    public ModeleExpert() {
        
        super();
        try {
            
            String req = " SELECT * FROM user where type='expert'";
            st= cn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Entities.Expert p = new Expert();
                p.setId(rs.getString("id"));
                p.setNom(rs.getString("nom_exp"));
                p.setPrenom(rs.getString("prenom_exp"));
                p.setCin(rs.getString("cin_exp"));
                p.setZone(rs.getString("zone_exp"));
                p.setTel(rs.getString("tel_exp"));
                ls.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleExpert.class.getName()).log(Level.SEVERE, null, ex);
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
                return ls.get(rowIndex).getNom();
            case 2:
                return ls.get(rowIndex).getPrenom();
            case 3:
                return ls.get(rowIndex).getCin();
            case 4:
                return ls.get(rowIndex).getZone();
            case 5:
                return ls.get(rowIndex).getTel();
            
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
}
