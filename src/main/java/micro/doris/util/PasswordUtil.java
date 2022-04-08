package micro.doris.util;

public class PasswordUtil {

    public enum SecurityLevel {
        SUCCES, REJECT
    }

    public static SecurityLevel assessPassword(String password) {

        if (password.length()  ==4 ) return SecurityLevel.SUCCES;

        return SecurityLevel.REJECT;
    }
}
