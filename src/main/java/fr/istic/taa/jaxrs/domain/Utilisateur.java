package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Utilisateur")
public class Utilisateur extends Compte{
    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String password) {
        super(id, login, password);
    }
}
