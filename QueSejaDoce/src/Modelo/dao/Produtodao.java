/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.Produto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingá
 */
public class Produtodao {
    
    public void insertproduto (Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt =  (PreparedStatement) con.prepareStatement("INSERT INTO produto(nomeproduto,valorproduto)VALUES(?,?)");
            
              
              stmt.setString(1, p.getNomeproduto());
              stmt.setDouble(2,p.getPrecoproduto());
              
              stmt.executeUpdate();
              JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
        
        } catch (SQLException ex) {
           
            JOptionPane.showInputDialog("Erro ao salvar!", ex);
       
        }finally {
            
            ConnectionFactory.closeconnection(con, stmt);
            
        }
           
    }
    
    
     public void deletar (Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
       
            try {
                 stmt = (PreparedStatement) con.prepareStatement("DELETE FROM produto WHERE codigoproduto = ? ");
        
                stmt.setInt(1, p.getCodproduto());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Removido com sucesso !" );
                        
                
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao Remover o produto : " + ex);
            }finally{
                ConnectionFactory.closeconnection(con, stmt);
                
            }
            
    }
    
     public List<Produto> Listarproduto () {
    
    Connection con = ConnectionFactory.getConnection();
    java.sql.PreparedStatement stmt = null;
    ResultSet rs = null;
    
    
    List <Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();   
            
            while (rs.next()){
                
                Produto p = new Produto();
                
                p.setCodproduto(rs.getInt("codigoproduto"));
                p.setNomeproduto(rs.getString("nomeproduto"));
                p.setPrecoproduto(rs.getDouble("valorproduto"));
                
                produtos.add(p);
            }  
            
        } catch (SQLException ex) {
           
            JOptionPane.showInputDialog("Erro ao acessar", ex);
       
        }finally{
            
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
        
        
        return produtos;
    }    
     
     
    /* public void AtualizarProduto(Produto p){
         
         Connection con = ConnectionFactory.getConnection();
         PreparedStatement stmt = null;
         int vCodProd = p.getCodproduto();
         String vNomeProd = p.getNomeproduto();
         Double vValor = p.getPrecoproduto();
        
         
        try {
            
            String sql = "UPDATE produto SET nomeproduto= '"+vNomeProd+"', valorproduto = "+vValor+" WHERE codigoproduto = " + vCodProd;
            
            stmt = (PreparedStatement) con.prepareStatement(sql); 
     
            stmt.executeUpdate(sql);
           
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt);
        }
         
     }*/
     
public void AtualizarProduto(Produto p){
    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    
        try {
           // String sql = ;
            stmt = (PreparedStatement) con.prepareStatement("UPDATE produto SET nomeproduto = ? ,valorproduto = ? WHERE codigoproduto = ? ");
                       
            
            
            stmt.setString(1, p.getNomeproduto());
            stmt.setDouble(2, p.getPrecoproduto());
            stmt.setInt(3, p.getCodproduto());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Salvo Com sucesso");
            
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("erro ao atualizar", ex);
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt);
        }
    
    
    
}

public List<Produto> buscaProduto (String busca){
    
    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Produto> produtos = new ArrayList<>();
    
        try {
           
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM produto WHERE nomeproduto LIKE ?");
           
            stmt.setString(1, "%"+busca+"%");
            
            
            rs = stmt.executeQuery();
             
           while(rs.next()){
                Produto p = new Produto();
                
                
            p.setCodproduto(rs.getInt("codigoproduto"));
            p.setNomeproduto(rs.getString("nomeproduto"));
            p.setPrecoproduto(rs.getDouble("valorproduto"));
            
            produtos.add(p);
               
               
           }
            
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar os dados", ex);
        
        }finally{
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
   
    
  return produtos;   
}




}



 
        
      

        
