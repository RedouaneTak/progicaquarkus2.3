package fr.cd.endpoint;


import fr.cd.dto.EquipementGiteDto;
import fr.cd.dto.GiteDto;
import fr.cd.entities.EquipementGiteEntity;
import fr.cd.entities.EquipementGiteEntityPK;
import fr.cd.entities.GiteEntity;
import fr.cd.repositories.EquipementGiteRepository;
import fr.cd.repositories.GiteRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Gites")
@Path("/gites")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiteResource {

    @Inject
    GiteRepository giteRepository;


    @Inject
    EquipementGiteRepository equipementGiteRepository;




    @GET
    @Operation(summary = "liste des gites")
    public Response getAll(@Context UriInfo uriInfo){

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();
        List<GiteDto> gite = GiteDto.toGiteDtoList(giteRepository.listAll());
        for(GiteDto giteDto : gite){
            giteDto.addLink("all",uriBase);
            giteDto.addLink("self",uriBase+"/"+giteDto.getId());
        }
        return Response.ok(gite).build();
    }
    @GET
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id,@Context UriInfo uriInfo){
        GiteDto gite = GiteDto.toGiteById(giteRepository.findById(id));
        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        gite.addLink("all",uriBase.replace("/"+gite.getId(),""));

        return Response.ok(gite).build();
    }

    @GET
    @Path("{id}/equipementsgite")
    public Response getEquipementGiteById(@PathParam("id") Integer id,@Context UriInfo uriInfo){

        List<EquipementGiteDto> equipementsGite = EquipementGiteDto.toEquipementGiteDtoList(equipementGiteRepository.list("from EquipementGiteEntity where ID_GITE = ?1",id));

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();



        return Response.ok(equipementsGite).build();
    }

//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("id") Integer id, Gite gite){
//        if(gite == null || id == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(id != gite.getId()){
//            return Response.status(Response.Status.CONFLICT).entity(gite).build();
//        }
//        if(DaoFactory.getGiteDAO().update(gite))
//            return Response.ok(gite).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//    @POST
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response insert(@PathParam("id") Integer id, Gite gite){
//        if(gite == null || id == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(id != gite.getId()){
//            return Response.status(Response.Status.CONFLICT).entity(gite).build();
//        }
//        if(DaoFactory.getGiteDAO().insert(gite))
//            return Response.ok(gite).build();
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    @Consumes("application/json")
//    @ApiResponse(responseCode = "204", description = "supprimé!!")
//    @ApiResponse(responseCode = "400", description = "!non supprimé!!")
//
//    public Response delete(@PathParam("id") Integer id){
//        if(id == null){
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        if(DaoFactory.getGiteDAO().delete(new Gite())){
//            return Response.status(204).build();
//        }
//        else
//            return Response.status(Response.Status.BAD_REQUEST).build();
//    }

}
