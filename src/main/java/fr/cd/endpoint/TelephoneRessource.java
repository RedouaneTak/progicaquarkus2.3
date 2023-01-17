package fr.cd.endpoint;

import fr.cd.dto.PersonneDto;
import fr.cd.dto.TelephoneDto;
import fr.cd.repositories.TelephoneRepository;
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

@Tag(name = "Telephone")
@Path("/telephone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelephoneRessource {
    @Inject
    TelephoneRepository telephoneRepository;

    @GET
    @Operation(summary = "liste des telephones")
    public Response getAll(@Context UriInfo uriInfo){

        List<TelephoneDto> telephone = TelephoneDto.toTelephoneDtoList(telephoneRepository.listAll());

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(TelephoneDto telephoneDto : telephone){
            telephoneDto.addLink("all",uriBase);
            telephoneDto.addLink("self",uriBase+"/"+telephoneDto.getNumTel());
        }
        return Response.ok(telephone).build();
}
}
