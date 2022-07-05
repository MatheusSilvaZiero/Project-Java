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
public class PedidoFinalizado {

    public int getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(int numeropedido) {
        this.numeropedido = numeropedido;
    }

    public int getNumeroproduto() {
        return numeroproduto;
    }

    public void setNumeroproduto(int numeroproduto) {
        this.numeroproduto = numeroproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public float getValorpedido() {
        return valorpedido;
    }

    public void setValorpedido(float valorpedido) {
        this.valorpedido = valorpedido;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getVlrunidade() {
        return vlrunidade;
    }

    public void setVlrunidade(float vlrunidade) {
        this.vlrunidade = vlrunidade;
    }

    public String getMespedido() {
        return mespedido;
    }

    public void setMespedido(String mespedido) {
        this.mespedido = mespedido;
    }

    public String getAnopedido() {
        return anopedido;
    }

    public void setAnopedido(String anopedido) {
        this.anopedido = anopedido;
    }
    
    private int numeropedido;
    private int numeroproduto;
    private String nomeproduto;
    private float valorpedido;
    private String nomecliente;
    private String data;
    private int qtd;
    private float vlrunidade;
    private String mespedido;
    private String anopedido;

    
}
