package fr.istic.taa.jaxrs.dto;


import fr.istic.taa.jaxrs.business.Compte;
import fr.istic.taa.jaxrs.dao.CompteManager;

public class CompteDto {
    private CompteManager compteManager;

    public CompteDto(){
        compteManager = new CompteManager();
    }

    public fr.istic.taa.jaxrs.domain.Compte getCompteById(long id){
        Compte result = compteManager.getCompteById(id,Compte.class);
        if(result != null){
            return new fr.istic.taa.jaxrs.domain.Compte(result.getId(),result.getLogin(),result.getPassword());
        }
        else {
            return null;
        }
    }
}
