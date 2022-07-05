/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Connection.ConnectionFactory;
import Modelo.bean.CadastroCliente;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author Ingá
 */
public class CadastroClienteDao {

    public void insertcliente(CadastroCliente c) {
        // inserir dados do cadastro de clientes.
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt =(PreparedStatement) con.prepareStatement("INSERT INTO cadastrocliente (nome,endereco,complemento,cidade,bairro,telefone,pix,chavepix,id,mesnasci,dianasci) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(9,c.getId());    
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setString(3, c.getComplemento());
            stmt.setString(4, c.getCidade());
            stmt.setString(5, c.getBairro());
            stmt.setString(6, c.getTelefone());
            stmt.setString(7, c.getPix());
            stmt.setString(8, c.getChavepix());
            stmt.setInt(10, c.getMesnasci());
            stmt.setInt(11, c.getDianasci());
            
            
           
       

           stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao Salvar as Informações", ex);

        } finally {

            ConnectionFactory.closeconnection(con, stmt);

        }
    }

    public List<CadastroCliente> ListarCliente() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadastroCliente> cadastro = new ArrayList<>();

        try {

            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM cadastrocliente");

            rs = stmt.executeQuery();

            while (rs.next()) {

                CadastroCliente c = new CadastroCliente();
                
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDianasci(rs.getInt("dianasci"));
                c.setMesnasci(rs.getInt("mesnasci"));
                c.setEndereco(rs.getString("endereco"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setTelefone(rs.getString(("telefone")));
                c.setPix(rs.getString("pix"));
                c.setChavepix(rs.getString("chavepix"));
                
                
                cadastro.add(c);
                
                
                
            }
        } catch (SQLException ex) {
           JOptionPane.showInputDialog("erro ao listar cadastro de clientes"+ ex);
        }  finally{
            
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
              return cadastro;
    }   
    
    
    public void AtualizarCliente(CadastroCliente cadcliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement)con.prepareStatement("UPDATE cadastrocliente SET nome = ?,endereco = ?,complemento = ?,cidade = ?,bairro = ?,telefone = ?,pix = ?,chavepix = ? WHERE id = ? ");
            
            stmt.setString(1, cadcliente.getNome());
            stmt.setString(2, cadcliente.getEndereco());
            stmt.setString(3, cadcliente.getComplemento());
            stmt.setString(4,cadcliente.getCidade());
            stmt.setString(5, cadcliente.getBairro());
            stmt.setString(6, cadcliente.getTelefone());
            stmt.setString(7, cadcliente.getPix());
            stmt.setString(8,cadcliente.getChavepix());
            stmt.setInt(9, cadcliente.getId());
            
            stmt.executeUpdate();
        
        
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog("Erro ao Atualizar", ex);
            
        }finally {
            
            ConnectionFactory.closeconnection(con, stmt);
            
        } 
    }

    public void detelarCliente(CadastroCliente cadcliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt =(PreparedStatement) con.prepareStatement("DELETE  FROM cadastrocliente WHERE id = ?");
            
            stmt.setInt(1, cadcliente.getId());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso ");
        } catch (SQLException ex) {
            
            JOptionPane.showInputDialog("Erro ao deletar ", ex);
        
        }finally{
            
        ConnectionFactory.closeconnection(con, stmt);
            
            
        }   
    }
    
    public List <CadastroCliente> listacadastroPedidoCliente(String nomecliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CadastroCliente> cadcliente = new ArrayList<>();
        
  
            
        try {
            
           // stmt = (PreparedStatement) con.prepareStatement("select * from cadastrocliente where nome = '"+ nomecliente +"'"  );
              stmt = (PreparedStatement) con.prepareStatement("select * from cadastrocliente where nome = ?"  );
            
                    stmt.setString(1, nomecliente);
                    
                    rs = stmt.executeQuery();
                    
            if (rs.first()){  
                CadastroCliente cad = new CadastroCliente();
                cad.setNome(rs.getString("nome"));
                cad.setEndereco(rs.getString("endereco"));
                cad.setComplemento(rs.getString("complemento"));
                cad.setCidade(rs.getString("cidade"));
                cad.setBairro(rs.getString("bairro"));
                cad.setTelefone(rs.getString("telefone"));
                cad.setPix(rs.getString("pix"));
                cad.setChavepix(rs.getString("chavepix"));
                cad.setId(rs.getInt("id"));
                
                
                
            
                
                
                cadcliente.add(cad);
                
               
            }
            
        } catch (SQLException ex) {
            
           JOptionPane.showInputDialog("erro ao buscar",  ex);
           
        } finally{
            
             ConnectionFactory.closeconnection(con, stmt, rs);    
        }
        
        
     
        return cadcliente;
    }
    
    
    
    public List <CadastroCliente> listaaniversario (String mes ){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        List<CadastroCliente> cad = new ArrayList<>();
        
       
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM cadastrocliente WHERE mesnasci = ? order by dianasci ");
            stmt.setString(1, mes);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                CadastroCliente c = new CadastroCliente();
                
                c.setNome(rs.getString("nome"));
                c.setMesnasci(rs.getInt("mesnasci"));
                c.setDianasci(rs.getInt("dianasci"));
                
                cad.add(c);
            }
        
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca.");

       } finally {
            ConnectionFactory.closeconnection(con, stmt, rs);
}
       
       return cad;
    
}
}