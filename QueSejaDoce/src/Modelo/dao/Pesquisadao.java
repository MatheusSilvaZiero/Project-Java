/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class Pesquisadao {
    
    
    public List<Produto> buscaProduto(String nomeproduto){
        
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
     List<Produto> produtos = new ArrayList<>();
    
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nomeproduto LIKE ?");
            stmt.setString(1, "%"+nomeproduto+"%");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setCodproduto(rs.getInt("codigoproduto"));
                produto.setNomeproduto(rs.getString("nomeproduto"));
                produto.setPrecoproduto(rs.getDouble("valorproduto"));
                
                produtos.add(produto);
                
            }
                    
                    
                    } catch (SQLException ex) {
                        
            JOptionPane.showInputDialog("Erro ao realizar a Busca", ex);
            
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt, rs);
        }

    return produtos;  
    
    }    
    
    
}
