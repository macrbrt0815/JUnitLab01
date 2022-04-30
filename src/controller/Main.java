package controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.TestRegistration;
import test.TestUserInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    final private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Result validRegistration = JUnitCore.runClasses((TestRegistration.class));

        if(validRegistration.getFailures() != null){
            for(Failure failure : validRegistration.getFailures()){
                logger.log(Level.WARNING,failure.toString());
            }
        }

        if(validRegistration.wasSuccessful()){
            Result validUserInfo = JUnitCore.runClasses((TestUserInfo.class));

            if(validUserInfo.wasSuccessful()){
                logger.log(Level.INFO,"Registration Successful");
            }else{
                logger.log(Level.WARNING,"Invalid User Information");
            }
        } else {
            logger.log(Level.WARNING,"Invalid Registration");
        }
    }
}
