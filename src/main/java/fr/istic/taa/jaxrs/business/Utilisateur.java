package jpa.business;

import javax.persistence.Entity;

@Entity
public class Utilisateur extends Compte{

    public Utilisateur(){
        super();
    }

    public Utilisateur(String log, String pass){
        super(log,pass);
    }
}
