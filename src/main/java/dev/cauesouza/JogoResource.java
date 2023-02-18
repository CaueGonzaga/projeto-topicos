package dev.cauesouza;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jogo")
public class JogoResource {
    
    @Inject
    JogoService jogoService;
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jogo> listarJogo() {
        return jogoService.listarJogos();
    }

    @POST
    public Jogo cadastrarJogo(Jogo novoJogo){
        return jogoService.criarJogo(novoJogo);
    }

    @GET
    @Path("/{id}")
    public Jogo findById(@PathParam("id") Long id){
        return jogoService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Jogo updateJogo(@PathParam("id") Long id, Jogo jogoUpdate){
        return jogoService.updateJogo(id,jogoUpdate);
    }

    @DELETE
    @Path("/{id}")
    public String deleteJogo(@PathParam("id") Long id){
        if(jogoService.deleteJogo(id)){
            return "Deletado com sucesso";
        }
        else{
            return "Usuário não encontrado";
        }
    }

}
