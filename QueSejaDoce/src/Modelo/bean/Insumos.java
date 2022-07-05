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
public class Insumos {
    
    private String nome;
    private int quantidade;
    private double valortotal;
    private double valorunidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public double getValorunidade() {
        return valorunidade;
    }

    public void setValorunidade(double valorunidade) {
        this.valorunidade = valorunidade;
    }
    
}
