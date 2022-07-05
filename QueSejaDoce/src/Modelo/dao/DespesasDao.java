/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.Despesas;
import Modelo.bean.PedidoFinalizado;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
public class DespesasDao {
    
    public void cadastrodespesas (Despesas desp){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO despesas (fornecedor, valor, datadespesa, mesdespesa, anodespesa, nnota)VALUES (?,?,?,?,?,?) ");
         
           
          
            
            stmt.setString(1, desp.getFornecedor());
            stmt.setFloat(2, desp.getValordespesas());
            stmt.setString(3, desp.getData());
            stmt.setString(4, desp.getMes());
            stmt.setString(5, desp.getAno());
            stmt.setLong(6, desp.getNfiscal());
            
             stmt.executeUpdate();
          
            JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
        } catch (SQLException ex) {
            
            
            JOptionPane.showInputDialog("Erro ao Cadastrar despesas", ex);
        }
        
    }
    
    
    
    public List<PedidoFinalizado> resumomensal (String mes, String ano ){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <PedidoFinalizado> ped = new ArrayList<>();
        
        
        
        try {
            
            stmt = con.prepareStatement("select distinct mespedido, anopedido, valorpedido from pedidofinalizado where mespedido = ? and anopedido = ?");
             stmt.setString(1, mes);
             stmt.setString(2, ano);
             rs = stmt.executeQuery();
             
           
             
              while (rs.next()){
                  
                 PedidoFinalizado p = new PedidoFinalizado();
                  
                    p.setValorpedido(rs.getFloat("valorpedido"));
                    
                  
                    ped.add(p);
                  
              }
             
             
             
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog("Erro ao carregar o caixa ",ex);
        } finally {
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
       
    
    return ped;
    }
    
    public List <Despesas> resumodespmensal (String mes,String ano){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Despesas> desp = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select distinct id,mesdespesa,anodespesa,valor from despesas where mesdespesa = ? and anodespesa = ?");
            stmt.setString(1, mes);
            stmt.setString(2, ano);
            rs = stmt.executeQuery();
            
            System.out.println(stmt);
            
            while (rs.next()){
                Despesas d = new Despesas();
                
                d.setValordespesas(rs.getFloat("valor"));
                
                desp.add(d);
            }
            
            
        } catch (SQLException ex) {
          JOptionPane.showInputDialog("Erro ao buscar o valor " , ex);
       
        
        } finally {
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
   
        
        
        return desp;
    }
    
    
    
    
    
}
