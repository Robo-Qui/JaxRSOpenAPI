package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Intitule")
public class Intitule implements Serializable {
    private String intitule;

    public Intitule() {
    }

    public Intitule(String intitule) {
        this.intitule = intitule;
    }

    @XmlElement(name = "intitule")
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
