package test;

import controller.SMSChecker;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUserInfo {
    @Test
    public void testCheckUserInfo() {
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan DelaCruz,1998-05-22,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("JuAn DeLA CrUz,1998-05-22,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,MAkaTi cIty"));

        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-32,Makati City"));

        //Leap Year
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,2000-02-29,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,2001-02-29,Makati City"));

        //Months with 30 and 31
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-01-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-03-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-07-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-08-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-10-31,Makati City"));
        assertTrue(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-12-31,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-04-31,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-06-31,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-09-31,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-11-31,Makati City"));

        assertFalse(SMSChecker.checkUserInfo("Juan,1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan,1998-05,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan,1998,Makati City"));

        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz/1998,05,22/Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz-1998,05,22-Makati City"));

        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998,05,22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998/05/22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,05-22-1998,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,5-2-1998,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,199-5-2,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,19981-551-221,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-5-22,Makati City"));

        assertFalse(SMSChecker.checkUserInfo(" Juan Dela Cruz,1998-05-22,Makati City "));
        assertFalse(SMSChecker.checkUserInfo(" Juan Dela Cruz,1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,Makati City "));

        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,19 98-0 5-2 2,Makati City"));

        assertFalse(SMSChecker.checkUserInfo(" Juan Dela Cruz , 1998-05-22 , Makati City "));
        assertFalse(SMSChecker.checkUserInfo(" Juan Dela Cruz, 1998-05-22, Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz ,1998-05-22 ,Makati City "));

        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz, 1998 - 05 - 22 ,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz, 1998- 05- 22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22 ,Makati City"));

        assertFalse(SMSChecker.checkUserInfo("Ju4n D3l4 Cru$z,1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,I998-o5-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,M4k@t1 C!ty"));

        assertFalse(SMSChecker.checkUserInfo("1234567890,1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,abcd-ab-ab,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,1234567890"));

        assertFalse(SMSChecker.checkUserInfo("!@#$%^&*(),1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,!@#$-!@-!@,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,!@#$%^&*()"));

        assertFalse(SMSChecker.checkUserInfo(" ,1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz, ,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22, "));

        assertFalse(SMSChecker.checkUserInfo(",1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22,"));

        assertFalse(SMSChecker.checkUserInfo("1998-05-22,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,Makati City"));
        assertFalse(SMSChecker.checkUserInfo("Juan Dela Cruz,1998-05-22"));
    }

}
