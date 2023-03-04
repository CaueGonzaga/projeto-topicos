package dev.cauesouza.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.cauesouza.model.Game;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Game>{

    public List<Game> findByName(String name){
        String likeName = "%"+name+"%";

        return list("name like ?1", likeName);
    }

}
    