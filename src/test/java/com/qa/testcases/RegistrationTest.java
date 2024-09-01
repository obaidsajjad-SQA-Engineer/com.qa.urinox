package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Login;
import com.qa.pages.Register;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationTest extends TestBase {
    public AndroidDriver mobileDriver;
    
    @BeforeMethod
    public void initialize(){
        mobileDriver = initializeDriver();
    }
    
    @Test(description="Register Account")
    public void accountRegistration() throws MalformedURLException, InterruptedException {
        Thread.sleep(10000); // Avoid using Thread.sleep in real tests; use explicit waits instead
        Login loginObject = new Login(mobileDriver);
        Register registerObject = loginObject.clickRegisterBtn();
        registerObject.enterEmail("obaid@gmail.com");
        registerObject.enterName("Obaid");
        registerObject.enterPassword("Password");
        registerObject.clickContinueBtn();
    }
    
    
    @AfterMethod(alwaysRun=true)
    public void tearDown(ITestResult tearResult) {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
}
