package fr.cd.endpoint;


import fr.cd.dto.DepartementDto;
import fr.cd.dto.RegionDto;
import fr.cd.dto.VilleDto;
import fr.cd.entities.DepartementEntity;
import fr.cd.entities.RegionEntity;
import fr.cd.repositories.DepartementRepository;
import fr.cd.repositories.RegionRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Tag(name = "Regions")
@Path("/regions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionResource {

    @Inject
    RegionRepository regionRepository;

    @Inject
    DepartementRepository departementRepository;

    @GET
    @Operation(summary = "Liste des regions")
    public Response getAll(@Context UriInfo uriInfo){
        List<RegionDto> regions = RegionDto.toRegionDtoList(regionRepository.listAll());

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        for(RegionDto region : regions){
            region.addLink("all",uriBase);
            region.addLink("self",uriBase+"/"+region.getIdRegion());
        }
        return Response.ok(regions).build();

    }
    @GET
    @Path("{id}")
    public Response getbyId(@Context UriInfo uriInfo,@PathParam("id") Integer id){
        RegionDto region = RegionDto.toRegionById(regionRepository.findById(id));
        String uriBase = uriInfo.getRequestUriBuilder().build().toString();

        region.addLink("all",uriBase.replace("/"+region.getIdRegion(),""));
        region.addLink("departements",uriBase+"/departements");

        return Response.ok(region).build();

    }

    @GET
    @Path("{id}/departements")
    public Response getDepartementsByIdRegion(@Context UriInfo uriInfo,@PathParam("id")Integer id){

        List<DepartementDto> departements = DepartementDto.toDepartementDtoList(departementRepository.list("from DepartementEntity where ID_REGION = ?1",id));

        String uriBase = uriInfo.getRequestUriBuilder().build().toString();
        for(DepartementDto departement : departements){
            departement.addLink("all",uriBase.replace("/"+id+"/departements",""));
            departement.addLink("self",uriBase.replace("/departements",""));
        }

        return Response.ok(departements).build();
    }
}
