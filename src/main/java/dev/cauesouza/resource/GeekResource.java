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

import dev.cauesouza.repository.GeekRepository;
import dev.cauesouza.model.Geek;


@Path("/geek")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GeekResource {
    
    @Inject
    GeekRepository geekRepository;

    @POST
    @Transactional
    public Geek createGeek(Geek newGeek){
        geekRepository.persist(newGeek);
        return newGeek;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Geek updateGeek(@PathParam("id") Long id, Geek GeekUpdated){
        Geek Geek = findById(id);

        Geek.setDescription(GeekUpdated.getDescription());
        Geek.setOrigin(GeekUpdated.getOrigin());
        Geek.setCategories(GeekUpdated.getCategories());
        Geek.setModel(GeekUpdated.getModel());
        Geek.setPrice(GeekUpdated.getPrice());

        return Geek;
    }

    @GET
    public List <Geek> listAll(){
        List <Geek> list = geekRepository.listAllOrdenated();
        return list;
    }

    @GET
    @Path("/{id}")
    public Geek findById(@PathParam("id")Long id){
        return geekRepository.findById(id);
    }

    @GET
    @Path("/{name}")
    public List <Geek> getGeeksByName(@PathParam("name")String name){
        return geekRepository.findByName(name);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public String deleteGeekById (@PathParam("id")Long id){
        boolean deleted = geekRepository.deleteById(id);
        if(deleted) return "Deleted with success";
        else return "Not found";
    }
}
