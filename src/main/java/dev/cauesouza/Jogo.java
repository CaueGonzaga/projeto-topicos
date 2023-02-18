package dev.cauesouza;

import javax.persistence.Entity;
// import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Jogo extends PanacheEntity{

    
    String nome;
    String genero;
    String dataLanca;
    String console;
    double preco;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDataLanca() {
        return dataLanca;
    }
    public void setDataLanca(String dataLanca) {
        this.dataLanca = dataLanca;
    }
    public String getConsole() {
        return console;
    }
    public void setConsole(String console) {
        this.console = console;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
{
    System.out.println("Game Start");
}

}
