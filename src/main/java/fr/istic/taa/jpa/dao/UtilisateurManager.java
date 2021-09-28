package fr.istic.taa.jpa.dao;

import fr.istic.taa.jpa.business.Utilisateur;

public class UtilisateurManager extends GenericManager<Utilisateur, Long> {
    private CompteManager compteManager;

    public UtilisateurManager(CompteManager compteManager) {
        this.compteManager = compteManager;
    }

    public Utilisateur getUtilisateurById(Long id){
        return (Utilisateur) compteManager.getCompteById(id,Utilisateur.class);
    }

    public Utilisateur getUtilisateurByLogin(String login){
        return (Utilisateur) compteManager.getCompteByLogin(login,Utilisateur.class);
    }
}
