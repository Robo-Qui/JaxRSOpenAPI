package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.dto.CompteDto;
import fr.istic.taa.jaxrs.dto.UtilisateurDto;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/compte")
@Produces({"application/json", "application/xml"})
public class UtilisateurRessource {

    private UtilisateurDto dto = new UtilisateurDto();

    @GET
    @Path("/{CompteId}")
    public Response getUtilisateurById(@PathParam("CompteId") Long compteId)  {
        Utilisateur result = dto.getUtilisateurById(compteId);
        if(result != null){
            return Response.ok().entity(result).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addUtilisateur(@Parameter(required = true) Utilisateur util){
        Utilisateur result = dto.addUtilisateur(util);
        if(result==null){
            return Response.status(400).build();
        }
        return Response.ok().entity(result).build();
    }
}
