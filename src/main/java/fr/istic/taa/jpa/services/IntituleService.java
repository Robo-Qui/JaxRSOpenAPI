package fr.istic.taa.jpa.services;

import fr.istic.taa.jpa.business.Intitule;
import fr.istic.taa.jpa.dao.IntituleManager;

import java.util.List;

public class IntituleService {
    private IntituleManager manager;

    public IntituleService(IntituleManager manager) {
        this.manager = manager;
    }


    public List<Intitule> add(List<Intitule> intitules) {
        for(Intitule intitule : intitules){
            manager.save(intitule);
        }
        return intitules;
    }
}
