package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.business.Compte;
import fr.istic.taa.jaxrs.dao.CompteManager;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class UtilisateurDto {

    private CompteManager compteManager;
    public UtilisateurDto(){
        compteManager = new CompteManager();
    }

    public Utilisateur getUtilisateurById(long id){
        Compte result = compteManager.getCompteById(id,Utilisateur.class);
        if(result != null){
            return new Utilisateur(result.getId(),result.getLogin(),result.getPassword());
        }
        else {
            return null;
        }
    }

    public Utilisateur addUtilisateur(Utilisateur util){
        if(!util.getLogin().equals(null) && !util.getPassword().equals(null)){
            fr.istic.taa.jaxrs.business.Utilisateur toAdd = new fr.istic.taa.jaxrs.business.Utilisateur(util.getLogin(), util.getPassword());
            fr.istic.taa.jaxrs.business.Utilisateur result = (fr.istic.taa.jaxrs.business.Utilisateur) compteManager.save(toAdd);
            return new Utilisateur(result.getId(), result.getLogin(),result.getPassword());
        }
        else{
            return null;
        }
    }
}
