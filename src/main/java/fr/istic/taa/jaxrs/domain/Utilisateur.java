package fr.istic.taa.jaxrs.domain;

public class Utilisateur extends Compte{
    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String password) {
        super(id, login, password);
    }
}
