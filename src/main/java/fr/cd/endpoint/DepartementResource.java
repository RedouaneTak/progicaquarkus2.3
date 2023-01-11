package fr.cd.endpoint;


import fr.cd.entities.DepartementEntity;
import fr.cd.repositories.DepartementRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Departements")
@Path("/departements")
public class DepartementResource {

    @Inject
    DepartementRepository departementRepository;
    @GET
    @Operation(summary = "liste des departements")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<DepartementEntity> departement = departementRepository.listAll();
        return Response.ok(departement).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") String id){
        DepartementEntity departement = departementRepository.findById(id);
        return Response.ok(departement).build();
    }

}
