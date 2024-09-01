package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.Login;
import com.qa.pages.Profile;

import io.appium.java_client.android.AndroidDriver;

public class EditProfileTest extends TestBase {
	public AndroidDriver mobileDriver;

    @BeforeMethod
    public void initialize(){
        mobileDriver = initializeDriver();
    }

    @Test(description = "Edit Profile", dependsOnMethods = {"com.qa.testcases.LoginTest.accountLogin"})
    public void EditProfile() throws MalformedURLException, InterruptedException {
        Thread.sleep(10000); // Replace with explicit wait in real scenarios
        
        Login loginObject = new Login(mobileDriver);
        loginObject.enterEmail("obaid@gmail.com");
        loginObject.enterPassword("obaid123");
        loginObject.clickLoginBtn();
        Thread.sleep(5000);
        
        Homepage homepageObject=new Homepage(mobileDriver);
        Profile profileObject = homepageObject.clickProfileBtn();
        
        profileObject.clickEditBtn();
        profileObject.editName("Obaid");
        profileObject.editEmail("obaid@gmail.com");
        profileObject.editPassword("obaid123");
        
        profileObject.clickSaveBtn();
        
        Thread.sleep(10000);
        
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult tearResult) {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
}
