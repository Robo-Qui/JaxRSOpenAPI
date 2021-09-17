package jpa.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Professionnel extends Compte{
    private String name;
    RdvInfos infoRdv;
    List<FreeSlot> freeSlots;

    public Professionnel() {
        super();
    }

    public Professionnel(String log, String pass, String name){
        super(log,pass);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public RdvInfos getRdvInfos() {
        return infoRdv;
    }

    public void setRdvInfos(RdvInfos rdvInfo) {
        this.infoRdv = rdvInfo;
    }

    @OneToMany
    public List<FreeSlot> getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(List<FreeSlot> freeSlots) {
        this.freeSlots = freeSlots;
    }

    @Override
    public String toString(){
        return String.format("Profesionnel %s, Durée de RDV: %s\nMotifs de RDV %s\nCréneaux disponibles %s",
                this.name,this.infoRdv.getDuree(),
                IntiList(this.getRdvInfos().getIntitules()),
                this.freeSlots
        );
    }

    private String IntiList(List<Intitule> intitules){
        String res = "Liste des intitulés:";
        for(Intitule intitule : intitules){
            res = String.format("%s\n%s",res,intitule.toString());
        }
        return res;
    }
}
