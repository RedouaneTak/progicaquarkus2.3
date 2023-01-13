package fr.cd.endpoint;


import fr.cd.dto.VilleDto;
import fr.cd.entities.SaisonEntity;
import fr.cd.repositories.SaisonRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Tag(name = "Saisons")
@Path("/saisons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaisonResource {

    @Inject
    SaisonRepository saisonRepository;

    @GET
    @Operation(summary = "liste des saisons")
    public Response getAll(@Context UriInfo uriInfo){

        List<SaisonEntity> saisonEntities = saisonRepository.listAll();

        return Response.ok(saisonEntities).build();
    }
}
