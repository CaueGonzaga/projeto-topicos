package dev.cauesouza.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.cauesouza.model.Geek;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GeekRepository implements PanacheRepository<Geek>{

    public List<Geek> findByName(String name){
        String likeName = "%"+name+"%";

        return list("name like ?1", likeName);
    }

    public List<Geek> listAllOrdenated(){
        return find("Order by id").list();
    }
}
    