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
public class CadastroCliente {
    private int id ;
    private String nome;
    private String endereco;
    private String complemento;
    private String cidade;
    private String bairro;
    private String telefone;
    private String pix;
    private String chavepix;
    private int mesnasci;
    private int dianasci;

    public int getMesnasci() {
        return mesnasci;
    }

    public void setMesnasci(int mesnasci) {
        this.mesnasci = mesnasci;
    }

    public int getDianasci() {
        return dianasci;
    }

    public void setDianasci(int dianasci) {
        this.dianasci = dianasci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

  
       public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public String getChavepix() {
        return chavepix;
    }

    public void setChavepix(String chavepix) {
        this.chavepix = chavepix;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
      
    
    
}
