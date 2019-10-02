/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert.Service;

import Shared.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class CompagnieDAO implements Crud {
     Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

    @Override
    public void ajouter(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object select(String table, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectAll(String table) {
        String req = "SELECT id,nom_compagnie, rating FROM user u,rating r where u.id = r.id_compagnie and u.type ='compagnie'";
        try {
            st = cn.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            return null;
        }
    }

  
    public void rate(int id_compagnie, double rating) throws SQLException{
        ResultSet c = cn.createStatement().executeQuery("SELECT * FROM rating WHERE id_compagnie = "+id_compagnie);
        if(c!=null){
            double newRate = 0;
            newRate = (rating + c.getDouble("rating"))/2;
            cn.createStatement().execute("UPDATE rating SET rating = "+newRate+" WHERE id_compagnie = "+id_compagnie);
        }else{
            cn.createStatement().execute("INSERT INTO rating VALUES("+id_compagnie+","+rating+")");
        }
    }
    public ResultSet stat(){
        String req="SELECT count(*) nbr,date_format(date_sinistre,'%Y-%m-%d') datee from sinistre group by date_format(date_sinistre,'%Y-%m-%d')";
         try {
             st=cn.createStatement();
             return st.executeQuery(req);
         } catch (SQLException ex) {
             return null;
         }

    }
    
    
}
