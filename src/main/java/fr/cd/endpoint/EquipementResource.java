package fr.cd.endpoint;


import fr.cd.entities.EquipementEntity;
import fr.cd.repositories.EquipementRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Equipements")
@Path("/equipements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipementResource {

    @Inject
    EquipementRepository equipementRepository;

    @GET
    @Operation(summary = "liste des equipements")
    public Response getAll(){

     List<EquipementEntity> equipements = equipementRepository.listAll();
        return Response.ok(equipements).build();
    }
    @GET
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id){
        EquipementEntity equipement = equipementRepository.findById(id);
        return Response.ok(equipement).build();
    }
//
//    @PUT
//    @Path("{id}")
//    public Response update(@PathParam("id") Integer id, Equipement equipement){
//        if(equipement == null || id == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(id != equipement.getId()){
//            return Response.status(Response.Status.CONFLICT).entity(equipement).build();
//        }
//        if(DaoFactory.getEquipementDAO().update(equipement))
//            return Response.ok(equipement).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//    @POST
//    public Response insert(Equipement equipement){
//        if(equipement == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(DaoFactory.getEquipementDAO().insert(equipement))
//            return Response.ok(equipement).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") Integer id){
//        Equipement equipement = new Equipement();
//        equipement.setId(id);
//
//        if(DaoFactory.getEquipementDAO().delete(equipement))
//            return Response.ok(equipement).build();
//
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
}
