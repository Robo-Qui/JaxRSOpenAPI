package fr.istic.taa.jpa.services;

import fr.istic.taa.jpa.dao.RdvInfosManager;
import fr.istic.taa.jpa.business.RdvInfos;

public class RdvInfosService {
    private RdvInfosManager manager;
    private IntituleService intituleService;

    public RdvInfosService(RdvInfosManager manager, IntituleService intituleService) {
        this.manager = manager;
        this.intituleService = intituleService;
    }

    public RdvInfos add(RdvInfos rdvInfos) {
        rdvInfos.setIntitules(intituleService.add(rdvInfos.getIntitules()));
        manager.save(rdvInfos);
        return rdvInfos;
    }
}
