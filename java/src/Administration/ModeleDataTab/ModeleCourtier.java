/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.ModeleDataTab;
import Entities.Compagnie;
import Entities.Courtier;
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
public class ModeleCourtier extends AbstractTableModel{
    Connection cn = Utils.Database.getInstance().getConnection();
    private Statement st;
    PreparedStatement pst;
    String[] entetes = {"ID", "Nom", "Lieu", "Commission","CIN"};
    List<Entities.Courtier> ls = new ArrayList<>();
    public ModeleCourtier(){
        super();
        try {
            
            String req = " SELECT * FROM user where type='courtier'";
            st= cn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Entities.Courtier p = new Courtier();
                p.setId(rs.getString("id"));
                p.setNom(rs.getString("nom"));
                p.setLieu(rs.getString("lieu"));
                p.setCommission(rs.getString("commission"));
                p.setCin(rs.getString("cin"));
                ls.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleCourtier.class.getName()).log(Level.SEVERE, null, ex);
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
                return ls.get(rowIndex).getLieu();
            case 3:
                return ls.get(rowIndex).getCommission();
            case 4:
                return ls.get(rowIndex).getCin();
            
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
}
