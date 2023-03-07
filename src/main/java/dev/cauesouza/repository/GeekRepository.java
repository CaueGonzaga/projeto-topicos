package dev.cauesouza.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.cauesouza.model.Geek;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GeekRepository implements PanacheRepository<Geek>{

    public List<Geek> findByName(String description){
        String likeDescription = "%"+description+"%";

        return list("description like ?1", likeDescription);
    }

    public List<Geek> listAllOrdenated(){
        return find("Order by id").list();
    }
}
    