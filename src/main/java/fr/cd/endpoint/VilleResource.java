package fr.cd.endpoint;


import fr.cd.dto.VilleDto;
import fr.cd.entities.VilleEntity;
import fr.cd.entities.VilleEntityPK;
import fr.cd.repositories.VilleRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Tag(name = "Villes")
@Path("/villes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VilleResource {

    @Inject
    VilleRepository villeRepository;



    @GET
    @Operation(summary = "liste des villes")
    public Response getAll(@Context UriInfo uriInfo){
       List<VilleDto> villes = VilleDto.toVilleDtoList(villeRepository.listAll());
        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

       for(VilleDto ville : villes){
           ville.addLink("all",uriBase);
           ville.addLink("self",uriBase+"/"+ville.getCodeInseeDept()+ville.getCodeInsee());
       }
        return Response.ok(villes).build();
    }

    @GET
    @Path("{codeinsee}")
    public Response getbyId(@PathParam("codeinsee") String codeInsee,@Context UriInfo uriInfo){

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        VilleEntityPK villeEntityPK = new VilleEntityPK();
        villeEntityPK.setCodeInsee(codeInsee.substring(2));
        villeEntityPK.setCodeInseeDept(codeInsee.substring(0,2));

        VilleDto ville = VilleDto.toVilleById(villeRepository.findById(villeEntityPK));

        if (ville.getNomVille() == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else{


            ville.addLink("all",uriBase.replace("/"+ville.getCodeInseeDept()+ville.getCodeInsee(),""));

            return Response.ok(ville).build();
        }

    }

}
