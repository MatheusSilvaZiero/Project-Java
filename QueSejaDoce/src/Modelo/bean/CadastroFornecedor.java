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
public class CadastroFornecedor {
    
    private String nomefornecedor;
    private String endereco;
    private int cep;
    private String cidade ;
    private String bairro;
    //private int cnpj;
    private String cpnj;
    private int contato1;
    private int contato2;
    private  String data;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

//    public int getCnpj() {
//        return cnpj;
//    }
//
//    public void setCnpj(int cnpj) {
//        this.cnpj = cnpj;
//    }

    public int getContato1() {
        return contato1;
    }

    public void setContato1(int contato1) {
        this.contato1 = contato1;
    }

    public int getContato2() {
        return contato2;
    }

    public void setContato2(int contato2) {
        this.contato2 = contato2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return getNomefornecedor(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
