package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Parameter;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {

  private PetDto dto = new PetDto();

  @GET
  @Path("/{petId}")
  public Response getPetById(@PathParam("petId") Long petId)  {
    Pet result = dto.getById(petId);
    if(result != null){
      return Response.ok().entity(result).build();
    }
    else{
      return Response.status(404).build();
    }
  }

  @POST
  @Path("pet/add")
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    // add pet
    return Response.ok().entity("SUCCESS").build();
  }
}