package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Professionnel")
public class Professionnel extends Compte{
    private String name;
    private RdvInfos rdvInfos;
    private List<FreeSlot> freeslots;

    public Professionnel(){
        super();
    }

    public Professionnel(Long id, String login, String password, String name) {
        super(login, password);
        this.name = name;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "rdvInfos")
    public RdvInfos getRdvInfos() {
        return rdvInfos;
    }

    public void setRdvInfos(RdvInfos rdvInfos) {
        this.rdvInfos = rdvInfos;
    }

    @XmlElement(name = "freeSlots")
    public List<FreeSlot> getFreeslots() {
        return freeslots;
    }

    public void setFreeslots(List<FreeSlot> freeslots) {
        this.freeslots = freeslots;
    }
}
