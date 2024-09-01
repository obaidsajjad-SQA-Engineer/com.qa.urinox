package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Camera;
import com.qa.pages.GetResults;
import com.qa.pages.Homepage;
import com.qa.pages.Login;
import com.qa.pages.Scan;

import io.appium.java_client.android.AndroidDriver;

public class PictureAndResultsTest extends TestBase {
	public AndroidDriver mobileDriver;

    @BeforeMethod
    public void initialize(){
        mobileDriver = initializeDriver();
    }

    @Test(description = "Picture & Results Test", dependsOnMethods = {"com.qa.testcases.EditProfileTest.EditProfile"})
    public void CameraPictureAndResults() throws MalformedURLException, InterruptedException {
        Thread.sleep(10000); // Replace with explicit wait in real scenarios
        
        Login loginObject = new Login(mobileDriver);
        loginObject.enterEmail("obaid@gmail.com");
        loginObject.enterPassword("obaid123");
        loginObject.clickLoginBtn();
        Thread.sleep(5000);
        
        Homepage homepageObject=new Homepage(mobileDriver);
        Scan scanObject = homepageObject.clickScanBtn();
        
        Camera cameraObject= scanObject.clickCameraBtn();
        cameraObject.allowPermission();
        Thread.sleep(1000);
        cameraObject.enterPatientID("1");
        Thread.sleep(1000);
        GetResults getResultBtn= cameraObject.clickCameraBtn();
        Thread.sleep(5000);
        getResultBtn.clickGetResultBtn();
        
        Thread.sleep(2000);
        
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult tearResult) {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
}
