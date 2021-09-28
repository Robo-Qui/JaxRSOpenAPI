package fr.istic.taa.jpa.services;

import fr.istic.taa.jpa.business.RendezVous;
import fr.istic.taa.jpa.dao.RendezVousManager;

public class RendezVousService {
    private RendezVousManager manager;

    public RendezVousService(RendezVousManager manager) {
        this.manager = manager;
    }

    public RendezVous add(RendezVous rdv){
        manager.save(rdv);
        return rdv;
    }
}
