package dev.cauesouza.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.cauesouza.repository.GameRepository;
import dev.cauesouza.model.Game;


@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    
    @Inject
    GameRepository gameRepository;

    @POST
    @Transactional
    public Game createGame(Game newGame){
        gameRepository.persist(newGame);
        return newGame;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Game updateGame(@PathParam("id") Long id, Game gameUpdated){
        Game game = findById(id);

        game.setName(gameUpdated.getName());
        game.setSubject(gameUpdated.getSubject());
        game.setSinopses(gameUpdated.getSinopses());
        game.setPlataform(gameUpdated.getPlataform());
        game.setPrice(gameUpdated.getPrice());

        return game;
    }

    @GET
    public List <Game> listAll(){
        List <Game> list = gameRepository.findAll().list();
        return list;
    }

    @GET
    @Path("/{id}")
    public Game findById(@PathParam("id")Long id){
        return gameRepository.findById(id);
    }

    @GET
    @Path("/{name}")
    public List <Game> getGamesByName(@PathParam("name")String name){
        return gameRepository.findByName(name);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public String deleteGameById (@PathParam("id")Long id){
        boolean deleted = gameRepository.deleteById(id);
        if(deleted) return "Deleted with success";
        else return "Not found";
    }
}
