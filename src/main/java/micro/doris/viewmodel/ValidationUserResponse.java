package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationUserResponse {

    @JsonProperty("valid")
    private boolean valid ;
    @JsonProperty("username")
    private String username;


    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
