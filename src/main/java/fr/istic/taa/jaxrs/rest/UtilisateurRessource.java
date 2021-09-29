package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.FreeSlot;
import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jpa.business.RendezVous;
import fr.istic.taa.jpa.dao.*;
import fr.istic.taa.jpa.services.*;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/utilisateur")
@Produces({"application/json", "application/xml"})
public class UtilisateurRessource {

    private UtilisateurService service = new UtilisateurService(new UtilisateurManager(new CompteManager()), new ProfessionnelService(new ProfessionnelManager(new CompteManager()), new FreeSlotService(new FreeSlotManager()), new RdvInfosService(new RdvInfosManager(), new IntituleService(new IntituleManager()))), new RendezVousService(new RendezVousManager()));

    @GET
    @Path("/id/{CompteId}")
    public Response getById(@PathParam("CompteId") Long compteId)  {
        fr.istic.taa.jpa.business.Utilisateur ret = service.getById(compteId);
        if(ret == null){
            return Response.status(404).build();
        }
        Utilisateur result = new Utilisateur(ret.getId(),ret.getLogin(),ret.getPassword());
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/login/{CompteLogin}")
    public Response getByLogin(@PathParam("CompteLogin") String login)  {
        fr.istic.taa.jpa.business.Utilisateur ret = service.getByLogin(login);
        if(ret == null){
            return Response.status(404).build();
        }
        Utilisateur result = new Utilisateur(ret.getId(),ret.getLogin(),ret.getPassword());
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addUtilisateur(@Parameter(required = true) Utilisateur util) throws Exception {
        fr.istic.taa.jpa.business.Utilisateur ret = service.addUtilisateur(new fr.istic.taa.jpa.business.Utilisateur(util.getLogin(), util.getPassword()));
        if(ret==null){
            return Response.status(400).build();
        }
        Utilisateur result = new Utilisateur(ret.getId(),ret.getLogin(),ret.getPassword());
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/appointement/{utilId}/{profId}")
    @Consumes("application/json")
    public Response takeAppointentement(@Parameter(required = true) FreeSlot slot, @PathParam("CompteId") Long utilId, @PathParam("CompteId") Long profId) throws Exception {
        fr.istic.taa.jpa.business.FreeSlot oSlot = new fr.istic.taa.jpa.business.FreeSlot(slot.getStartTime(),slot.getEndTime());
        RendezVous ret = service.addAppointement(utilId,profId,oSlot);
        if(ret==null){
            return Response.status(400).build();
        }
        Utilisateur util = new Utilisateur(ret.getClient().getId(),ret.getClient().getLogin(),ret.getClient().getPassword());
        Professionnel prof = new Professionnel(ret.getProf().getId(),ret.getProf().getLogin(),ret.getProf().getPassword(),ret.getProf().getName());
        fr.istic.taa.jaxrs.domain.RendezVous result = new fr.istic.taa.jaxrs.domain.RendezVous(prof,util,ret.getStartTime(),ret.getEndTime());
        return Response.ok().entity(result).build();
    }
}
