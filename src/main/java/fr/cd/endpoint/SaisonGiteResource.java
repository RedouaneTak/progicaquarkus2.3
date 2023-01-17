package fr.cd.endpoint;

import fr.cd.dto.RegionDto;
import fr.cd.dto.SaisonGiteDto;
import fr.cd.entities.EquipementEntity;
import fr.cd.entities.SaisonGiteEntity;
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

@Tag(name = "SaisonGite")
@Path("/saisonGite")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaisonGiteResource {
    @Inject
    SaisonGiteRepository saisonGiteRepository;

    @GET
    @Operation(summary = "liste des saisons du Gite")
    public Response getAll(@Context UriInfo uriInfo){

        List<SaisonGiteDto> saisonGite = SaisonGiteDto.toSaisonGiteDtoList(saisonGiteRepository.listAll());

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(SaisonGiteDto saisonGiteDto : saisonGite){
            saisonGiteDto.addLink("all",uriBase);
            saisonGiteDto.addLink("self",uriBase+"/"+saisonGiteDto.getIdSaison());
        }
        return Response.ok(saisonGite).build();
    }

}
