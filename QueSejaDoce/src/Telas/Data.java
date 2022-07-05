/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author inga05
 */
public class Data {
    
    
    
    public String buscarmes(){
        
         LocalDate data = LocalDate.now();
         DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("MM");
         String mes = data.format(dataformatada);
      
         return mes;
        
    }
    
    
    public String buscarano(){
        
         LocalDate data = LocalDate.now();
         DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("yyyy");
         String ano = data.format(dataformatada);
      
         return ano;
        
    }
    
    public String buscardata(){
        
          LocalDate data = LocalDate.now();
         DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String date = data.format(dataformatada);
         
         return date;
        
    }
    
    
    public Month mesporextenso (){
        
        Month date = LocalDate.now().getMonth();
        
        
        
            return date;
    }
    
    
    public String proxmesextenso (){
        
         String date = LocalDate.now().getMonth().plus(1).toString();
       DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("MM");
       String mes = date.format(Locale.forLanguageTag(date), date);
      
        
        return mes;
        
    }
    
    public String proxmes (){
        
        LocalDate date = LocalDate.now().plusMonths(1);
         DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
         String mes = date.format(format);
        
         return mes;
        
        
    }


}
