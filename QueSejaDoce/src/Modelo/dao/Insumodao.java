/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.Insumos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingá
 */
public class Insumodao {
    
    public void insertinsumo(Insumos i){
        // Insetir dados de insumos.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
       
        try {
            
            stmt = con.prepareStatement("INSERT INTO cadastroinsumos (nome,quantidade,valortotal,valorunidade)VALUES(?,?,?,?)");
            
            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getQuantidade());
            stmt.setDouble(3, i.getValortotal());
            stmt.setDouble(4, i.getValorunidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
            
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog("Erro ao Salvar", ex);
        } finally {
            
            ConnectionFactory.closeconnection(con, stmt);
        }
        
    }
    
    
}
