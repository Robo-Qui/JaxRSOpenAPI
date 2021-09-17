package jpa.business;

import javax.persistence.*;
import java.util.List;

@Entity
public class RdvInfos {
    private int duree;
    private List<Intitule> intitules;
    private Long id;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<Intitule> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }

    public int getDuree(){
        return duree;
    }

    public void setDuree(int length){
        this.duree = length;
    }

    @OneToMany
    public List<Intitule> getIntitules() {
        return intitules;
    }

    public void setIntitules(List<Intitule> intitules) {
        this.intitules = intitules;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private void setId(Long id){
        this.id = id;
    }
}
