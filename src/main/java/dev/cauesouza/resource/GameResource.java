package dev.cauesouza.resource;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.oracle.svm.core.annotate.Inject;

import dev.cauesouza.repository.GameRepository;
import dev.cauesouza.model.Game;


@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    
    @Inject
    GameRepository gameRepository;

    @GET
    public Response listAll(){
        List <Game> list = gameRepository.findAll().list();
        return Response.ok(list).build();
    }


    @POST
    @Transactional
    public Response createJogoRep(Game newJogoRep){
        gameRepository.persist(newJogoRep);
        if (gameRepository.isPersistent(newJogoRep)) {
            return Response.created(URI.create("/jogorep/" + newJogoRep.getId())).entity(newJogoRep).build();
        }
        return Response.status(Status.BAD_REQUEST).build();

        
    }
}
