package test;

import controller.SMSChecker;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRegistration {

    @Test
    public void testCheckRegister() {
        assertTrue(SMSChecker.checkRegister("Register"));
        assertTrue(SMSChecker.checkRegister("ReGisTer"));
        assertTrue(SMSChecker.checkRegister("register"));
        assertTrue(SMSChecker.checkRegister("REGISTER"));
        assertFalse(SMSChecker.checkRegister(" register"));
        assertFalse(SMSChecker.checkRegister("register "));
        assertFalse(SMSChecker.checkRegister("regi ster"));
        assertFalse(SMSChecker.checkRegister("register02 "));
        assertFalse(SMSChecker.checkRegister("#regi$ter"));
        assertFalse(SMSChecker.checkRegister("#regi$ter11"));
        assertFalse(SMSChecker.checkRegister("random"));
        assertFalse(SMSChecker.checkRegister(" "));
        assertFalse(SMSChecker.checkRegister(""));
    }
}
