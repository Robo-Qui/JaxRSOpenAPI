package fr.istic.taa.jpa.services;

import fr.istic.taa.jpa.business.FreeSlot;
import fr.istic.taa.jpa.business.Professionnel;
import fr.istic.taa.jpa.business.RdvInfos;
import fr.istic.taa.jpa.dao.ProfessionnelManager;

import java.util.List;

public class ProfessionnelService {
    private ProfessionnelManager manager;
    private FreeSlotService freeSlotService;
    private RdvInfosService rdvInfosService;

    public ProfessionnelService(ProfessionnelManager manager, FreeSlotService freeSlotService, RdvInfosService rdvInfosService){
        this.manager = manager;
        this.freeSlotService = freeSlotService;
        this.rdvInfosService = rdvInfosService;
    }

    public Professionnel getById(Long id){
        return manager.getProfessionnelById(id);
    }

    public Professionnel getByLogin(String login){
        return manager.getProfessionnelByLogin(login);
    }

    public Professionnel getByName(String name){
        return manager.getProfessionnelByName(name);
    }

    public List<FreeSlot> addFreeSlot(Long id,FreeSlot slot) throws Exception {
        Professionnel prof = getById(id);
        if(prof!=null && slot.getStartTime().before(slot.getEndTime())){
            prof.setFreeSlots(freeSlotService.add(slot,prof.getFreeSlots()));
            manager.update(prof);
            return prof.getFreeSlots();
        }
        else{
            throw new Exception("Account not found or startime must be before endtime");
        }
    }

    public List<FreeSlot> removeFreeSlot(Professionnel prof, FreeSlot slot){
        prof.setFreeSlots(freeSlotService.remove(prof.getFreeSlots(),slot));
        manager.update(prof);
        return prof.getFreeSlots();
    }

    public Professionnel addProfessionnel(Professionnel prof) throws Exception{
        if(getByName(prof.getName()) == null && getByLogin(prof.getLogin()) == null){
            manager.save(prof);
            return prof;
        }
        else{
            throw new Exception("Ce professionnel existe déjà");
        }
    }

    public Professionnel changeProfRdvInfos(Professionnel prof, RdvInfos rdvInfos) throws Exception {
        if(getById(prof.getId()) != null){
            prof.setRdvInfos(rdvInfosService.add(rdvInfos));
            return prof;
        }
        else{
            throw new Exception("Professionnel inexistant");
        }
    }
}
