package jpa.dao;

import jpa.business.Professionnel;
import jpa.business.Utilisateur;

public class ProfessionnelManager extends GenericManager<Professionnel,Long>
{
    public Professionnel getProfessionnelById(Long id){
        return (Professionnel) (new CompteManager()).getCompteById(id,Professionnel.class);
    }

    public Professionnel getProfessionnelByLogin(String login){
        return (Professionnel) (new CompteManager()).getCompteByLogin(login,Professionnel.class);
    }
}
