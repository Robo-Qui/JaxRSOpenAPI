package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Compte;
import fr.istic.taa.jaxrs.dto.CompteDto;

@Path("/compte")
@Produces({"application/json", "application/xml"})
public class CompteRessource {

  private CompteDto dto = new CompteDto();

  @GET
  @Path("/{CompteId}")
  public Response getPetById(@PathParam("CompteId") Long compteId)  {
    Compte result = dto.getCompteById(compteId);
    if(result != null){
      return Response.ok().entity(result).build();
    }
    else{
      return Response.status(404).build();
    }
  }
}