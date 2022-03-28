package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    @JsonProperty("rut")
    private String rut ;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("active")
    private boolean active;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
