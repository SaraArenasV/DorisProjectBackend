package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    @JsonProperty("id")
    private int id;
    @JsonProperty("rut")
    private String rut ;
    @JsonProperty("password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
