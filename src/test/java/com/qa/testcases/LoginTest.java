package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Login;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest extends TestBase {
    public AndroidDriver mobileDriver;

    @BeforeMethod
    public void initialize(){
        mobileDriver = initializeDriver();
    }

    @Test(description = "Login Account", dependsOnMethods = {"com.qa.testcases.RegistrationTest.accountRegistration"})
    public void accountLogin() throws MalformedURLException, InterruptedException {
        Thread.sleep(10000); // Replace with explicit wait in real scenarios
        Login loginObject = new Login(mobileDriver);
        loginObject.enterEmail("obaid@gmail.com");
        loginObject.enterPassword("obaid123");
        loginObject.clickLoginBtn();
        Thread.sleep(10000);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult tearResult) {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
}
