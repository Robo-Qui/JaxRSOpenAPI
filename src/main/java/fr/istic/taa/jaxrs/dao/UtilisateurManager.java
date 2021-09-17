package jpa.dao;

import jpa.business.Compte;
import jpa.business.Utilisateur;

import javax.persistence.criteria.*;

public class UtilisateurManager extends GenericManager<Utilisateur, Long> {
    public Utilisateur getUtilisateurById(Long id){
        return (Utilisateur) (new CompteManager()).getCompteById(id,Utilisateur.class);
    }

    public Utilisateur getUtilisateurByLogin(String login){
        return (Utilisateur) (new CompteManager()).getCompteByLogin(login,Utilisateur.class);
    }
}
