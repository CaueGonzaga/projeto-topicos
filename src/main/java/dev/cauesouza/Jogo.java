package dev.cauesouza;

import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Jogo extends PanacheEntity{

    
    String nome;
    String genero;
    String dataLanca;
    String console;
    double preco;
{
    System.out.println("Game Start");
}

}
