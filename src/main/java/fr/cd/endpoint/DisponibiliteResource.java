package fr.cd.endpoint;

import fr.cd.dto.DisponibiliteDto;
import fr.cd.repositories.DisponibiliteRepository;
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

@Tag(name = "Disponibilite")
@Path("/disponibilite")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisponibiliteResource {

    @Inject
    DisponibiliteRepository disponibiliteRepository;

    @GET
    @Operation(summary = "liste des disponibilites")
    public Response getAll(@Context UriInfo uriInfo){

        List<DisponibiliteDto> disponibilite = DisponibiliteDto.toDisponibiliteDtoList(disponibiliteRepository.listAll());

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(DisponibiliteDto disponibiliteDto : disponibilite){
            disponibiliteDto.addLink("all",uriBase);
            disponibiliteDto.addLink("self",uriBase+"/"+disponibiliteDto.getIdDisponibilite());
        }
        return Response.ok(disponibilite).build();
    }
}
