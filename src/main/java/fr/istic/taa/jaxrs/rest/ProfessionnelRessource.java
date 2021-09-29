package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.*;
import fr.istic.taa.jpa.dao.*;
import fr.istic.taa.jpa.services.FreeSlotService;
import fr.istic.taa.jpa.services.IntituleService;
import fr.istic.taa.jpa.services.ProfessionnelService;
import fr.istic.taa.jpa.services.RdvInfosService;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("Professionnel")
@Produces({"application/json", "application/xml"})
public class ProfessionnelRessource {

    private ProfessionnelService service = new ProfessionnelService(new ProfessionnelManager(new CompteManager()), new FreeSlotService(new FreeSlotManager()), new RdvInfosService(new RdvInfosManager(),new IntituleService(new IntituleManager())));

    @GET
    @Path("id/{CompteId}")
    public Response getById(@PathParam("CompteId") Long compteId)  {
        fr.istic.taa.jpa.business.Professionnel ret = service.getById(compteId);
        if(ret==null){
            return Response.status(404).build();
        }
        Professionnel result = new Professionnel(ret.getId(),ret.getLogin(),ret.getPassword(),ret.getName());
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/login/{CompteLogin}")
    public Response getByLogin(@PathParam("CompteLogin") String login)  {
        fr.istic.taa.jpa.business.Professionnel ret = service.getByLogin(login);
        if(ret == null){
            return Response.status(404).build();
        }
        Professionnel result = new Professionnel(ret.getId(),ret.getLogin(),ret.getPassword(), ret.getName());
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addProfessionnel(@Parameter(required = true) Professionnel prof) throws Exception {
        fr.istic.taa.jpa.business.Professionnel ret = service.addProfessionnel(new fr.istic.taa.jpa.business.Professionnel(prof.getLogin(), prof.getPassword(), prof.getName()));
        if(ret==null){
            return Response.status(400).build();
        }
        Professionnel result = new Professionnel(ret.getId(),ret.getLogin(),ret.getPassword(),ret.getName());
        return Response.ok().entity(result).build();
    }

    @PUT
    @Path("/rdvinfos/{ProfId}/")
    public Response updateRdvInfos(@Parameter(required = true) RdvInfos rdvInfos,@PathParam("ProfId") Long profId) throws Exception {
        fr.istic.taa.jpa.business.Professionnel prof = service.getById(profId);
        if(prof == null){
            return Response.status(400).build();
        }
        List<fr.istic.taa.jpa.business.Intitule> intituleList = new ArrayList<>();
        for(Intitule intitule : rdvInfos.getIntitules()){
            intituleList.add(new fr.istic.taa.jpa.business.Intitule(intitule.getIntitule()));
        }
        fr.istic.taa.jpa.business.Professionnel ret = service.changeProfRdvInfos(prof, new fr.istic.taa.jpa.business.RdvInfos(rdvInfos.getDuree(),intituleList));
        if(ret == null){
            return Response.status(404).build();
        }
        Professionnel result = new Professionnel(ret.getId(),ret.getLogin(),ret.getPassword(), ret.getName());
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/freeslot/{ProfId}")
    public Response addFreeSlot(@Parameter(required = true) FreeSlot slot, @PathParam("ProfId") Long profId) throws Exception {
        fr.istic.taa.jpa.business.FreeSlot oSlot = new fr.istic.taa.jpa.business.FreeSlot(slot.getStartTime(),slot.getEndTime());
        List<fr.istic.taa.jpa.business.FreeSlot> ret = service.addFreeSlot(profId,oSlot);
        List<FreeSlot> result = new ArrayList<>();
        for(fr.istic.taa.jpa.business.FreeSlot frSlots : ret){
            result.add(new FreeSlot(frSlots.getStartTime(),frSlots.getEndTime()));
        }
        return Response.ok().entity(result).build();
    }

}
