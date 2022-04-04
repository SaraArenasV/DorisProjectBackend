package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {



    @JsonProperty("rut")
    private String rut ;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("active")
    private String active;
    @JsonProperty("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    //    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
}
