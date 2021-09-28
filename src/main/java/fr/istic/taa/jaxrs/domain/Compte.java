package fr.istic.taa.jaxrs.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "compte")
public class Compte implements Serializable {
    private Long id;
    private String login;
    private String password;

    public Compte(){

    }

    public Compte(String login, String password){
        this.login = login;
        this.password = password;
    }

    public Compte(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
