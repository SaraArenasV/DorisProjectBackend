package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    @JsonProperty("id")
    private int id;
    @JsonProperty("user")
    private String user ;
    @JsonProperty("password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
