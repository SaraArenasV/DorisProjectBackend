package micro.doris.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static micro.doris.util.PasswordUtil.SecurityLevel.REJECT;
import static micro.doris.util.PasswordUtil.SecurityLevel.SUCCES;

class PasswordUtilTest {



    @Test
    public void higher_what_4() {

        assertEquals(REJECT,  PasswordUtil.assessPassword("1234567") );
    }

    @Test
    public void same_what_4() {

        assertEquals(SUCCES,  PasswordUtil.assessPassword("asd1") );
    }

    @Test
    public void less_what_4() {

        assertEquals(REJECT,  PasswordUtil.assessPassword("as2") );
    }



}
