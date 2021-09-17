package jpa.dao;

import jpa.business.Compte;
import jpa.business.Utilisateur;

import javax.persistence.NoResultException;

public class CompteManager extends GenericManager<Compte, Long>{
    public Compte getCompteById(Long id, Class resultClass){
        try {
            String query = String.format("SELECT a FROM Compte a WHERE DTYPE=%s AND id=%s",
                    resultClass.getName(),
                    id.toString());
            return entityManager.createQuery(query, Compte.class).getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }

    public Compte getCompteByLogin(String login, Class resultClass){
        try {
            String query = String.format("SELECT a FROM Compte a WHERE DTYPE=%s AND login='%s'",
                    resultClass.getName(),
                    login);
            return entityManager.createQuery(query, Compte.class).getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }
}
