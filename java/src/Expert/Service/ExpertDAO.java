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
public class ExpertDAO implements Crud {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    public ExpertDAO() {
    }

    public int ajouter(Entities.Expert o) {
         String nom_exp, prenom_exp,zone_exp,cin_exp,Uname,email;
       String tel_exp;
        Integer enabled;
       nom_exp=o.getNom();
       prenom_exp=o.getPrenom();
       zone_exp=o.getZone();
       cin_exp=o.getCin();
       tel_exp=o.getTel();
       Uname=o.getUname();
       email=o.getMail();
        
       
        
            try {
                
                String req="INSERT INTO user(username,nom_exp,prenom_exp,zone_exp,cin_exp,tel_exp,enabled,username_canonical,email,email_canonical,password,roles,type)"
                        + "VALUES('"+Uname + "','"+nom_exp + "','"+prenom_exp+"','"+zone_exp+"','"+cin_exp+"','123','0','"+Uname + "','"+email+"','"+email+"','12345','a:1:{i:0;s:11:\"ROLE_EXPERT\";}','expert')";
                
                st = cn.createStatement();
                
               return st.executeUpdate(req);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ExpertDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(String table, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
