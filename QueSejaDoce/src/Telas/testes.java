/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Modelo.bean.Despesas;
import Modelo.bean.PedidoFinalizado;
import Modelo.dao.DespesasDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author inga05
 */
public class testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
       
        Month date = LocalDate.now().getMonth().plus(1);
        System.out.print("mes " + date);
        
         LocalDate date2 = LocalDate.now().plusMonths(1);
         DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
         String mes = date2.format(format);
        
            System.out.print("mes " + mes);
        
     
   
    }
}
