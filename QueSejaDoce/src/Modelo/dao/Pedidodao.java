/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.NumeroPedido;
import Modelo.bean.Pedido;
import Modelo.bean.PedidoFinalizado;
import Modelo.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class Pedidodao {

    public List<Produto> Listarproduto() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();

                p.setCodproduto(rs.getInt("codigoproduto"));
                p.setNomeproduto(rs.getString("nomeproduto"));
                p.setPrecoproduto(rs.getDouble("valorproduto"));

                produtos.add(p);
            }

        } catch (SQLException ex) {

            JOptionPane.showInputDialog("Erro ao acessar", ex);

        } finally {

            ConnectionFactory.closeconnection(con, stmt, rs);
        }

        return produtos;
    }

    public List<Produto> Listaredido() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nomeproduto ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();

                p.setCodproduto(rs.getInt("codigoproduto"));
                p.setNomeproduto(rs.getString("nomeproduto"));
                p.setPrecoproduto(rs.getDouble("valorproduto"));

                produtos.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pedidodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionFactory.closeconnection(con, stmt, rs);
        }

        return produtos;
    }

    public List<NumeroPedido> buscarnumeropedido() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<NumeroPedido> numeropedidos = new ArrayList<>();

        int teste;

        try {
            stmt = con.prepareStatement("select * from numeropedido ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                NumeroPedido pedido = new NumeroPedido();

                pedido.setNumpedido(rs.getInt("npedido"));

                teste = pedido.getNumpedido();

                numeropedidos.add(pedido);

                

            }

        } catch (SQLException ex) {

            JOptionPane.showInputDialog("Erro ao buscar o dado", ex);

        } finally {

            ConnectionFactory.closeconnection(con, stmt, rs);

        }

        return numeropedidos;
    }

    public void atualizacaonumeropedido(NumeroPedido numPedido) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE numeropedido SET npedido = ?");

            stmt.setInt(1, numPedido.getNumpedido());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showInputDialog("Erro ao realizar a alteração", ex);

        } finally {

            ConnectionFactory.closeconnection(con, stmt);

        }

    }

    public void inserirpedido (List<Pedido> ped) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
    
      
       
            
        try {
             stmt = con.prepareStatement("INSERT INTO pedido (numeroPedido,codproduto,qtd,nomeproduto,valorunit,valorpedido,nomecliente,datapedido,mespedido,anopedido) VALUES (?,?,?,?,?,?,?,?,?,?)");
            
          
             for (Pedido pedido : ped){
                           
                 
                 
                stmt.setInt(1, pedido.getNumeropedido());
                stmt.setInt(2, pedido.getNumeroproduto());
                stmt.setInt(3, pedido.getQtd());
                stmt.setString(4, pedido.getNomeproduto());
                stmt.setFloat(5,pedido.getVlrunidade());
                stmt.setFloat(6,pedido.getValorpedido());
                stmt.setString(7, pedido.getNomecliente());
                stmt.setString(8, pedido.getData());
                stmt.setString(9, pedido.getMespedido());
                stmt.setString(10, pedido.getAnopedido());
               
                
          
                   stmt.executeUpdate();
               
               JOptionPane.showMessageDialog(null, "veio até aqui");  
             }
        
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog(ex , "Erro ao salvar");
            
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt);
            
        }
 
    }
    

 public List <Pedido> buscarpedido(){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     ResultSet rs = null;
     
     List <Pedido> bp = new ArrayList<>();
     
        try {
            stmt = con.prepareStatement("select distinct numeropedido, nomecliente, valorpedido from pedido");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Pedido pedido = new Pedido();
                
                pedido.setNumeropedido(rs.getInt("numeropedido"));
                pedido.setNomecliente(rs.getString("nomecliente"));
                pedido.setValorpedido(rs.getFloat("valorpedido"));
                
                bp.add(pedido);
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedidodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
        
        
  return bp;   
 }
 public List <Pedido> pedidoRealizado (int numped){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     ResultSet rs = null;
     
     List <Pedido> pedrealizado = new ArrayList<>();
     
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM pedido WHERE numeroPedido = ? ");
            stmt.setInt(1,numped );
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                
                Pedido pedido = new Pedido();
                
                pedido.setNumeropedido(rs.getInt("numeroPedido"));
                pedido.setNumeroproduto(rs.getInt("codproduto"));
                pedido.setQtd(rs.getInt("qtd"));
                pedido.setNomeproduto(rs.getString("nomeproduto"));
                pedido.setVlrunidade(rs.getFloat("valorunit"));
                pedido.setValorpedido(rs.getFloat("valorpedido"));
                pedido.setNomecliente(rs.getString("nomecliente"));
                pedido.setData(rs.getString("datapedido"));
                
                pedrealizado.add(pedido);
                
           
            }
            
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar", ex);
       
        
        } finally {
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
     
     
     return pedrealizado;
 } 

 public  void PedidoFinalizado (List<PedidoFinalizado> pedlist ){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     
     
        try {
            stmt = con.prepareStatement("INSERT INTO pedidofinalizado (numeroPedido,qtd,nomeproduto,valorunit,valorpedido,nomecliente,datapedido,mespedido,anopedido) VALUES (?,?,?,?,?,?,?,?,?)");
            System.out.println("ok");
        for(PedidoFinalizado pedido : pedlist){
            
            stmt.setInt(1, pedido.getNumeropedido());
            stmt.setInt(2, pedido.getQtd());
            stmt.setString(3, pedido.getNomeproduto());
            stmt.setFloat(4, pedido.getVlrunidade());
            stmt.setFloat(5, pedido.getValorpedido());
            stmt.setString(6, pedido.getNomecliente());
            stmt.setString(7, pedido.getData());
            stmt.setString(8, pedido.getMespedido());
            stmt.setString(9, pedido.getAnopedido());
            
            stmt.executeUpdate();
            
        
            
        }
        
        } catch (SQLException ex) {
           JOptionPane.showInputDialog("Erro ao finalizar o pedido ", ex);
        
        
        } finally {
            
            ConnectionFactory.closeconnection(con, stmt);
            
            
        }
 }
 
 public void deletarpedidorealizado (PedidoFinalizado ped){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     
        try {
            System.err.println(" valor " + ped.getNumeropedido());
            
            stmt = con.prepareStatement("DELETE FROM pedido WHERE numeroPedido = ? ");
            
            stmt.setInt(1, ped.getNumeropedido());
            stmt.executeUpdate();
            
            
            System.err.println("String sql  " + stmt);
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedidodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            ConnectionFactory.closeconnection(con, stmt);
        }
     
     
 }
 
 
 public List<PedidoFinalizado> listarpedidofinalizado (String mes,String ano){
      
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     ResultSet rs = null;
      List <PedidoFinalizado> pedfin = new ArrayList<>();
     
        try {
            stmt = con.prepareStatement("SELECT DISTINCT numeropedido,nomecliente,datapedido,valorpedido FROM pedidofinalizado WHERE mespedido = ? and anopedido = ?");
            stmt.setString(1, mes);
            stmt.setString(2, ano);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                PedidoFinalizado ped = new PedidoFinalizado();
                
                ped.setNumeropedido(rs.getInt("numeropedido"));
                ped.setNomecliente(rs.getString("nomecliente"));
                ped.setData(rs.getString("datapedido"));
                ped.setValorpedido(rs.getFloat("valorpedido"));
                
                
                pedfin.add(ped);
            }
            
            
        } catch (SQLException ex) {
            
            
                JOptionPane.showInputDialog("Erro ao buscar Lista de pedidos",ex);
            
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt, rs);
            
        }
     
     return pedfin;
 }
 
 
 public List<Pedido> extornopedidofin (int numpedido){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     ResultSet rs = null;
      List <Pedido> pedlist = new ArrayList<>();
     
        try {
            stmt = con.prepareStatement("SElECT * FROM pedidofinalizado WHERE numeropedido = ?");
            stmt.setInt(1, numpedido);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                 Pedido ped = new Pedido();
                
                ped.setNumeropedido(rs.getInt("numeropedido"));
                ped.setQtd(rs.getInt("qtd"));
                ped.setNomeproduto(rs.getString("nomeproduto"));
                ped.setVlrunidade(rs.getFloat("valorunit"));
                ped.setValorpedido(rs.getFloat("valorpedido"));
                ped.setNomecliente(rs.getString("nomecliente"));
                ped.setData(rs.getString("datapedido")); 
                ped.setMespedido(rs.getString("mespedido"));
                ped.setAnopedido(rs.getString("anopedido"));
                
                pedlist.add(ped);
                
                JOptionPane.showMessageDialog(null,"chegou aqui 1 ");
                
                   System.out.println(ped.getNumeropedido());
                    System.out.println(ped.getQtd());
                    System.out.println(ped.getNomeproduto());
                    System.out.println(ped.getVlrunidade());
                    System.out.println(ped.getValorpedido());
                    System.out.println(ped.getNomecliente());
                    System.out.println(ped.getData());
                    System.out.println(ped.getMespedido());
                    
            }
            
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Pedidodao.class.getName()).log(Level.SEVERE, null, ex);
       
        }finally {
            
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
     
     
     return null;
 }
 
 

 
 
 public void inserirpedidofinalizado (int numpedido){
      
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     
        try {
            
            
            stmt = con.prepareStatement("INSERT INTO pedido SELECT numeroPedido, codproduto, qtd, nomeproduto, valorunit, valorpedido, nomecliente, datapedido, mespedido, anopedido FROM pedidofinalizado WHERE numeropedido = ? ");
            stmt.setInt(1, numpedido);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "inserido com sucesso");
            
            
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao realizar o processo "+ ex);
        }finally{
            
            ConnectionFactory.closeconnection(con, stmt);
        }
     
     
     
 }
 
 public void deletarpedidoinseridofinalizado (int numpedido){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     
     
        try {
            stmt = con.prepareStatement("DELETE FROM pedidofinalizado WHERE numeropedido = ?");
            stmt.setInt(1, numpedido);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog("Erro ao remover " + ex);
            
        } finally{
            
            ConnectionFactory.closeconnection(con, stmt);
            
        }
     
     
     
     
 }
 
  public void deletarpedido (Pedido ped){
     
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
     
        try {
            System.err.println(" valor " + ped.getNumeropedido());
            
            stmt = con.prepareStatement("DELETE FROM pedido WHERE numeroPedido = ? ");
            
            stmt.setInt(1, ped.getNumeropedido());
            stmt.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null, "Removido com Sucesso");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Excluir pedido");
            
        }finally{
            
            ConnectionFactory.closeconnection(con, stmt);
        }
     
     
 }
 
    
}

