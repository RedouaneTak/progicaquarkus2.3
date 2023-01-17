package fr.cd.endpoint;


import fr.cd.dto.PersonneDto;
import fr.cd.dto.SaisonGiteDto;
import fr.cd.repositories.PersonneReposittory;
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

@Tag(name = "Personne")
@Path("/personne")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonneRessourse {
    @Inject
    PersonneReposittory personneRepository;

    @GET
    @Operation(summary = "liste des personne")
    public Response getAll(@Context UriInfo uriInfo){

        List<PersonneDto> personne = PersonneDto.toPersonneDtoList(personneRepository.listAll());

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(PersonneDto personneDto : personne){
            personneDto.addLink("all",uriBase);
            personneDto.addLink("self",uriBase+"/"+personneDto.getIdPersonne());
        }
        return Response.ok(personne).build();
    }
}
