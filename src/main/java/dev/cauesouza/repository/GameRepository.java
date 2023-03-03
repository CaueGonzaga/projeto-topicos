package dev.cauesouza.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.cauesouza.model.Game;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GameRepository implements PanacheRepository <Game>{
}
    