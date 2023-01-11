package fr.cd.endpoint;


import fr.cd.entities.TypeEquipementEntity;
import fr.cd.repositories.TypeEquipementRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "TypeEquipement")
@Path("/TypeEquipement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeEquipementResource {

    @Inject
    TypeEquipementRepository typeEquipmentRepository;

    @GET
    @Operation(summary = "Liste des types equipements")
    public Response getAll(){

        List<TypeEquipementEntity> typeEquipement = typeEquipmentRepository.listAll();
        return Response.ok(typeEquipement).build();
    }
    @GET
    @Operation(summary = "Liste des couleurs par id")
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id){
        TypeEquipementEntity typeEquipement = typeEquipmentRepository.findById(id);
        return Response.ok(typeEquipement).build();
    }
//
//    @PUT
//    @Operation(summary = "Update")
//    @Path("{id}")
//    public Response update(@PathParam("id") Integer id, TypeEquipement typeEquipement){
//        if(typeEquipement == null || id == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(id != typeEquipement.getId()){
//            return Response.status(Response.Status.CONFLICT).entity(typeEquipement).build();
//        }
//        if(DaoFactory.getTypeEquipementDAO().update(typeEquipement))
//            return Response.ok(typeEquipement).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//    @POST
//    @Operation(summary = "Insert")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response insert(TypeEquipement typeEquipement){
//        if(typeEquipement == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(DaoFactory.getTypeEquipementDAO().insert(typeEquipement))
//            return Response.ok(typeEquipement).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") Integer id){
//
//      TypeEquipement typeEquipement = new TypeEquipement();
//      typeEquipement.setId(id);
//
//        if(DaoFactory.getTypeEquipementDAO().delete(typeEquipement))
//            return Response.ok(typeEquipement).build();
//
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }

}
