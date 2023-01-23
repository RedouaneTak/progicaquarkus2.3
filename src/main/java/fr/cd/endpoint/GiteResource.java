package fr.cd.endpoint;


import fr.cd.dto.*;
import fr.cd.entities.GiteEntity;
import fr.cd.repositories.EquipementGiteRepository;
import fr.cd.repositories.GiteRepository;
import fr.cd.repositories.PersonneReposittory;
import fr.cd.repositories.SaisonGiteRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Tag(name = "Gites")
@Path("/gites")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiteResource {

    @Inject
    GiteRepository giteRepository;

    @Inject
    PersonneReposittory personneReposittory;

    @Inject
    EquipementGiteRepository equipementGiteRepository;

    @Inject
    SaisonGiteRepository saisonGiteRepository;



    @GET
    @Operation(summary = "liste des gites")
    public Response getAll(@Context UriInfo uriInfo){

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();


        List<GiteDto> gite = GiteDto.toGiteDtoList(giteRepository.listAll());

        for(GiteDto giteDto : gite){
           giteDto.addLink("all",uriBase);
           giteDto.addLink("self",uriBase+"/"+giteDto.getId());     }
        return Response.ok(gite).build();
    }
    @GET
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id,@Context UriInfo uriInfo){
        GiteDetailsDto gite = GiteDetailsDto.toGiteById(giteRepository.findById(id));
        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        gite.addLink("all",uriBase.replace("/"+gite.getId(),""));
        gite.addLink("equipements du gite",uriBase+"/"+"equipementsgite");
        gite.addLink("saison du gite",uriBase+"/"+"saisongite");
        gite.addLink("gerant",uriBase+"/gerant");
        gite.addLink("proprietaire",uriBase+"/proprietaire");
        gite.addLink("disponibilite", uriBase+"/disponibilite");

        return Response.ok(gite).build();
    }

    @GET
    @Path("{id}/equipementsgite")
    public Response getEquipementGiteById(@PathParam("id") Integer id,@Context UriInfo uriInfo){

        List<EquipementGiteDto> equipementsGite = EquipementGiteDto.toEquipementGiteDtoList(equipementGiteRepository.list("from EquipementGiteEntity where ID_GITE = ?1",id));

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(EquipementGiteDto equipementGiteDto: equipementsGite){
            equipementGiteDto.addLink("all",uriBase.replace("/"+id+"/equipementsgite",""));
            equipementGiteDto.addLink("id",uriBase.replace("/equipementsgite",""));
        }

        return Response.ok(equipementsGite).build();
    }

    @GET
    @Path("{id}/saisongite")
    public Response getSaisonGitebyId(@Context UriInfo uriInfo,@PathParam("id") Integer id){

        List<SaisonGiteDto> saisonGite = SaisonGiteDto.toSaisonGiteDtoList(saisonGiteRepository.list("from SaisonGiteEntity where ID_GITE = ?1",id));

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(SaisonGiteDto saisonGiteDto : saisonGite){
            saisonGiteDto.addLink("all",uriBase.replace("/"+id+"saisongite",""));
            saisonGiteDto.addLink("id",uriBase.replace("/saisongite",""));

        }

        return Response.ok(saisonGite).build();
    }

    @GET
    @Path("{id}/proprietaire")
    public Response getPersonnebyId(@Context UriInfo uriInfo,@PathParam("id") Integer id){
        GiteEntity gite = giteRepository.findById(id);
        PersonneDto personne = PersonneDto.toPersonneById(personneReposittory.findById(gite.getPersonne().getIdPersonne()));


        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        personne.addLink("all",uriBase.replace("/proprietaire",""));

        return Response.ok(personne).build();
    }

    @GET
    @Path("{id}/gerant")
    public Response getGerantById(@Context UriInfo uriInfo,@PathParam("id") Integer id){
        GiteEntity gite = giteRepository.findById(id);
        PersonneDto personne = PersonneDto.toPersonneById(personneReposittory.findById(gite.getPersonneGerant().getIdPersonne()));


        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        personne.addLink("all",uriBase.replace("/gerant",""));

        return Response.ok(personne).build();
    }

//    @GET
//    @Path("{id}/disponibilite")
//    public Response getDisponibiliteById(@Context UriInfo uriInfo,@PathParam("id") Integer id){
//        GiteEntity gite = giteRepository.findById(id);
////        DisponibiliteDto disponibilite = PersonneDto.toPersonneById(personneReposittory.findById(gite.getPersonneGerant().getDisponibiliteEntity(), ));
//
//
//        String uriBase = uriInfo.getRequestUriBuilder().build().toString();
//
//        disponibilite.addLink("all",uriBase.replace("/gerant",""));
//
//        return Response.ok(disponibilite).build();
//    }

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
