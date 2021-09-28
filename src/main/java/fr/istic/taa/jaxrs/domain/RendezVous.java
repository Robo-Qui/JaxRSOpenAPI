package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "rendezVous")
public class RendezVous implements Serializable {
    private Compte prof;
    private Compte util;
    private Date startTime;
    private Date endTime;

    public RendezVous(Compte prof, Compte util, Date startTime, Date endTime) {
        this.prof = prof;
        this.util = util;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @XmlElement(name = "professionnel")
    public Compte getProf() {
        return prof;
    }

    public void setProf(Compte prof) {
        this.prof = prof;
    }

    @XmlElement(name = "utilisateur")
    public Compte getUtil() {
        return util;
    }

    public void setUtil(Compte util) {
        this.util = util;
    }

    @XmlElement(name = "startTime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @XmlElement(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
