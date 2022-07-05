/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.bean;

/**
 *
 * @author Ingá
 */
public class Produto {

    
    
    
    private int codproduto;
    private String nomeproduto;
    private Double precoproduto;
    


    public int getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public Double getPrecoproduto() {
        return precoproduto;
    }

    public void setPrecoproduto(Double precoproduto) {
        this.precoproduto = precoproduto;
    }

    @Override
    public String toString() {
        return getNomeproduto(); //To change body of generated methods, choose Tools | Templates.
    }


    
}
