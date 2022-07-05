/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.CadastroFornecedor;
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
 * @author inga05
 */
public class CadastroFornecedordao {
        public void inserirfornecedor(CadastroFornecedor cad){
        
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        System.out.println("Nome Fornecedor " + cad.getNomefornecedor());
        System.out.println("Endereço " + cad.getEndereco() );
        System.out.println("Cidade" + cad.getCidade());
        System.out.println("Bairro" + cad.getBairro());
        System.out.println("Cep" + cad.getCep());
        
        System.out.println("Contato1" + cad.getContato1());
        System.out.println("Contato2" + cad.getContato2());
        System.out.println("Data" + cad.getData());
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO cadastrofornecedor (nomefornecedor,endereco,cep,cnpj,contato,contato2,cidade,bairro,datacad) VALUES (?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,cad.getNomefornecedor());
            stmt.setString(2, cad.getEndereco());
            stmt.setInt(3, cad.getCep());
            stmt.setString(4, cad.getCpnj());
            stmt.setInt(5, cad.getContato1());
            stmt.setInt(6, cad.getContato2());
            stmt.setString(7, cad.getCidade());
            stmt.setString(8, cad.getBairro());
            stmt.setString(9, cad.getData());
            
            
            stmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
                    
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao Salvar o Fornecedor",ex);
       
        }finally{
            
          ConnectionFactory.closeconnection(con, stmt);
            
        }
        
        
    }
        
        public List<CadastroFornecedor> buscarfonecedor (String buscar){
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<CadastroFornecedor> cad = new ArrayList<>();
           
            try {
                stmt = con.prepareStatement("SELECT * FROM cadastrofornecedor WHERE nomefornecedor LIKE ?");
                stmt.setString(1,"%" +buscar+"%");
                rs = stmt.executeQuery();
              
                while (rs.next()){
                    CadastroFornecedor cadastro = new CadastroFornecedor();
                    
                    cadastro.setNomefornecedor(rs.getString("nomefornecedor"));
                    cadastro.setEndereco(rs.getString("endereco"));
                    cadastro.setCep(rs.getInt("cep"));
                    cadastro.setCpnj(rs.getString("cnpj"));
                    cadastro.setContato1(rs.getInt("contato"));
                    cadastro.setContato2(rs.getInt("contato2"));
                    cadastro.setCidade(rs.getString("cidade"));
                    cadastro.setBairro(rs.getString("bairro"));
                    cadastro.setData(rs.getString("datacad"));
                    cadastro.setId(rs.getInt("idfornecedor"));
                    
                    cad.add(cadastro);
                    
                   
                }
            } catch (SQLException ex) {
                JOptionPane.showInputDialog("Erro ao Alterar", ex);
           
            }finally{
                
                ConnectionFactory.closeconnection(con, stmt, rs);
                
            }
            
            
            
            
           return cad;
        
        }
        
        
    public List<CadastroFornecedor> buscarfonecedorid (String buscar){
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<CadastroFornecedor> cad = new ArrayList<>();
           
            try {
                stmt = con.prepareStatement("SELECT * FROM cadastrofornecedor WHERE idfornecedor LIKE ?");
                stmt.setString(1,buscar);
                rs = stmt.executeQuery();
                
                while (rs.next()){
                    CadastroFornecedor cadastro = new CadastroFornecedor();
                    
                    cadastro.setNomefornecedor(rs.getString("nomefornecedor"));
                    cadastro.setEndereco(rs.getString("endereco"));
                    cadastro.setCep(rs.getInt("cep"));
                    cadastro.setCpnj(rs.getString("cnpj"));
                    cadastro.setContato1(rs.getInt("contato"));
                    cadastro.setContato2(rs.getInt("contato2"));
                    cadastro.setCidade(rs.getString("cidade"));
                    cadastro.setBairro(rs.getString("bairro"));
                    cadastro.setData(rs.getString("datacad"));
                    cadastro.setId(rs.getInt("idfornecedor"));
                    
                    cad.add(cadastro);
                    
                    
                }
            } catch (SQLException ex) {
                JOptionPane.showInputDialog("Erro ao Alterar", ex);
           
            }finally{
                
                ConnectionFactory.closeconnection(con, stmt, rs);
                
            }
            
            
            
            
           return cad;
        
        }  
    
     public List<CadastroFornecedor> listarfonecedor (){
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<CadastroFornecedor> cad = new ArrayList<>();
           
            try {
                stmt = con.prepareStatement("SELECT * FROM cadastrofornecedor");
                
                rs = stmt.executeQuery();
                
                
                
                while (rs.next()){
                    
                    CadastroFornecedor cadastro = new CadastroFornecedor();
                    
                    cadastro.setNomefornecedor(rs.getString("nomefornecedor"));
                    cadastro.setEndereco(rs.getString("endereco"));
                    cadastro.setCep(rs.getInt("cep"));
                    cadastro.setCpnj(rs.getString("cnpj"));
                    cadastro.setContato1(rs.getInt("contato"));
                    cadastro.setContato2(rs.getInt("contato2"));
                    cadastro.setCidade(rs.getString("cidade"));
                    cadastro.setBairro(rs.getString("bairro"));
                    cadastro.setData(rs.getString("datacad"));
                    cadastro.setId(rs.getInt("idfornecedor"));
                    
                    cad.add(cadastro);
                    
                   
                }
            } catch (SQLException ex) {
                JOptionPane.showInputDialog("Erro ao Alterar", ex);
           
            }finally{
                
                ConnectionFactory.closeconnection(con, stmt, rs);
                
            }
            
            
            
            
           return cad;
    
        
     }
     
       public List<CadastroFornecedor> buscarfonecedorpuro (String buscar){
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<CadastroFornecedor> cad = new ArrayList<>();
           
            try {
                stmt = con.prepareStatement("SELECT * FROM cadastrofornecedor WHERE nomefornecedor LIKE ?");
                stmt.setString(1,buscar);
                rs = stmt.executeQuery();
              
                while (rs.next()){
                    CadastroFornecedor cadastro = new CadastroFornecedor();
                    
                    cadastro.setNomefornecedor(rs.getString("nomefornecedor"));
                    cadastro.setEndereco(rs.getString("endereco"));
                    cadastro.setCep(rs.getInt("cep"));
                    cadastro.setCpnj(rs.getString("cnpj"));
                    cadastro.setContato1(rs.getInt("contato"));
                    cadastro.setContato2(rs.getInt("contato2"));
                    cadastro.setCidade(rs.getString("cidade"));
                    cadastro.setBairro(rs.getString("bairro"));
                    cadastro.setData(rs.getString("datacad"));
                    cadastro.setId(rs.getInt("idfornecedor"));
                    
                    cad.add(cadastro);
                    
                   
                }
            } catch (SQLException ex) {
                JOptionPane.showInputDialog("Erro ao Alterar", ex);
           
            }finally{
                
                ConnectionFactory.closeconnection(con, stmt, rs);
                
            }
            
            
            
            
           return cad;
        
        }
       
       
       public void alteracaofornecedor (CadastroFornecedor cad){
           
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;
           
            try {
                
                
                stmt = con.prepareStatement("UPDATE cadastrofornecedor SET nomefornecedor = ?, endereco = ?, cep = ?, cnpj = ?, contato = ?, contato2 = ?, cidade = ?, bairro = ?, datacad = ? WHERE idfornecedor = ?");
           
                
                stmt.setString(1, cad.getNomefornecedor());
                stmt.setString(2, cad.getEndereco());
                stmt.setInt(3, cad.getCep());
                stmt.setString(4, cad.getCpnj());
                stmt.setInt(5, cad.getContato1());
                stmt.setInt(6, cad.getContato2());
                stmt.setString(7, cad.getCidade());
                stmt.setString(8, cad.getBairro());
                stmt.setString(9, cad.getData());
                stmt.setInt(10, cad.getId());
                
                
                stmt.executeUpdate();
                
                   JOptionPane.showMessageDialog(null, "Alteração realizada com Sucesso");
                   
            } catch (SQLException ex) {
                
               JOptionPane.showInputDialog("Erro ao Atualizar",  ex);
            
             }finally{
                
                ConnectionFactory.closeconnection(con, stmt);
                
                
            }
           
       } 
       
       public void deletarfornecedor (CadastroFornecedor caddao){
           
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;
           
            try {
                stmt = con.prepareStatement("DELETE  FROM cadastrofornecedor WHERE idfornecedor = ? ");
                
                stmt.setInt(1, caddao.getId());
                
                stmt.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
            } catch (SQLException ex) {
              
                JOptionPane.showInputDialog("Erro ao Remover. ",ex);
           
            
            }finally{
                ConnectionFactory.closeconnection(con, stmt);
                
            }
           
       }
       
       
     }
            

