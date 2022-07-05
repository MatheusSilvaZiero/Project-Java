/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Modelo.bean.Despesas;
import Modelo.bean.PedidoFinalizado;
import Modelo.dao.DespesasDao;

/**
 *
 * @author Matheus
 */
public class ResumocCaixaMensal {
    
   
     public float resumomensal (){   
        Data date = new Data();
         String mes = date.buscarmes();
         String ano = date.buscarano();
         
         
         DespesasDao desp = new DespesasDao();
        float resumo = 0; 
         
        
         for (PedidoFinalizado ped : desp.resumomensal(mes, ano)){
   
            float total = ped.getValorpedido();
               
                resumo = total + resumo;
        
         }
         System.out.println("resumo " + resumo );
        
         return resumo;
         
         
     }   
     
     
     
     public float resumodespmensal (){
         
   Data date = new Data();
         
         String mes = date.buscarmes();
         String ano = date.buscarano();
         float resumo = 0;
         DespesasDao desp = new DespesasDao();
         
         for (Despesas d : desp.resumodespmensal(mes,ano)){
             
             float total = d.getValordespesas();
              resumo = total + resumo;
             
         
         }
         
         
         return resumo;
     }
     
     

    
}
