package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "rdvInfos")
public class RdvInfos implements Serializable {
    private int duree;
    private List<Intitule> intitules;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<Intitule> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }

    @XmlElement(name = "duree")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @XmlElement(name = "intitules")
    public List<Intitule> getIntitules() {
        return intitules;
    }

    public void setIntitules(List<Intitule> intitules) {
        this.intitules = intitules;
    }
}
