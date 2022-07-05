/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Modelo.bean.NumeroPedido;
import Modelo.dao.Pedidodao;

/**
 *
 * @author Matheus
 */
public class Buscanumerodepedido {
    
    public int buscarnumero () {
       
        int npedido = 0;
        
        
        
       Pedidodao pedidodao = new Pedidodao();
       NumeroPedido numped =  new NumeroPedido();
       
       for(NumeroPedido pedido: pedidodao.buscarnumeropedido()){
          
           npedido = pedido.getNumpedido();
           
         
                   
        
          
       }
        
        return npedido;
    }
       
    public int atulizarnumeropedido (){
           
           int soma = 1;
           int npedido;
        
        
       Pedidodao pedidodao = new Pedidodao();
       
       for(NumeroPedido pedido: pedidodao.buscarnumeropedido()){
          
           pedido.getNumpedido();
           
           npedido = pedido.getNumpedido();
          
           soma = npedido + soma;
           
           pedido.setNumpedido(soma);
           
          
          
           
           pedidodao.atualizacaonumeropedido(pedido);
       }
        return soma;
               
    
}
  
}
