package test;

import controller.SMSChecker;
import org.junit.Test;
import utility.Helper;

import java.io.IOException;
import static org.junit.Assert.*;

public class TestSMSChecker {

    @Test
    public void testCheckRegister() {
        assertTrue(SMSChecker.checkRegister("Register"));
        assertTrue(SMSChecker.checkRegister("ReGisTer"));
        assertTrue(SMSChecker.checkRegister("register"));
        assertTrue(SMSChecker.checkRegister("REGISTER"));
        assertFalse(SMSChecker.checkRegister(" register"));
        assertFalse(SMSChecker.checkRegister("register "));
        assertFalse(SMSChecker.checkRegister("random"));
        assertFalse(SMSChecker.checkRegister(""));
    }

    @Test
    public void testCheckUserInfo(){

    }
    }
