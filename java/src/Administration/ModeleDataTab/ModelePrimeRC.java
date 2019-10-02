/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.ModeleDataTab;

import Entities.Compagnie;
import Entities.PrimeRC;
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
public class ModelePrimeRC extends AbstractTableModel{
    Connection cn = Utils.Database.getInstance().getConnection();
    private Statement st;
    PreparedStatement pst;
    String[] entetes = {"ID", "Puissance Fiscale", "Prix"};
    List<Entities.PrimeRC> ls = new ArrayList<>();

    public ModelePrimeRC() {
        
        super();
        try {
            
            String req = " SELECT * FROM primerc";
            st= cn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Entities.PrimeRC p = new PrimeRC();
                p.setId(rs.getString("id"));
                p.setPuissance(rs.getString("puissance_fiscale"));
                p.setPrix(rs.getString("prix"));
                
                ls.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelePrimeRC.class.getName()).log(Level.SEVERE, null, ex);
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
                return ls.get(rowIndex).getPuissance();
            case 2:
                return ls.get(rowIndex).getPrix();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
}
