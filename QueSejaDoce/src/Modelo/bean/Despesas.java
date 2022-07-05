/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.bean;

/**
 *
 * @author inga05
 */
public class Despesas {
    
    private String fornecedor;
    private float valordespesas;
    private String data;
    private String mes;
    private String ano;
    private long nfiscal;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNfiscal() {
        return nfiscal;
    }

    public void setNfiscal(long nfiscal) {
        this.nfiscal = nfiscal;
    }

  
    

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getValordespesas() {
        return valordespesas;
    }

    public void setValordespesas(float valordespesas) {
        this.valordespesas = valordespesas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
}
