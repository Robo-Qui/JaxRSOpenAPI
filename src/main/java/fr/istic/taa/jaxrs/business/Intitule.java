package jpa.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Intitule {
    private String intitule;
    private Long id;

    public Intitule() {
    }

    public Intitule(String intitule) {
        this.intitule = intitule;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private void setId(Long id){
        this.id = id;
    }

    public String getIntitule(){
        return intitule;
    }

    public void setIntitule(String inti){
        this.intitule = inti;
    }

    public String toString(){
        return this.intitule;
    }
}
