/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.sql.ResultSet;

/**
 *
 * @author BahaEddine
 */
public interface Crud {
    void ajouter(String table, Object obj);
    void update(String table, Object obj);
    void delete(String table, Object obj);
    Object select(String table, int id);
    ResultSet selectAll(String table);
}
