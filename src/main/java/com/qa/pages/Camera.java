package com.qa.pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Camera {
	public AndroidDriver mobileDriver;
	
 	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]")
    @CacheLookup
    WebElement onlyThisTimeBtn;
 	
 	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Enter Patient ID\"]")
    @CacheLookup
    WebElement patientIDBtn;
 	
 	@FindBy(xpath = "//android.widget.EditText")
    @CacheLookup
    WebElement patientIDTextField;
 	
 	@FindBy(xpath = "//android.widget.Button[@content-desc=\"SUBMIT\"]")
    @CacheLookup
    WebElement submitBtn;

    public Camera(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver, this);
    }
    
    public void allowPermission() {
    	onlyThisTimeBtn.click();
    }
    
    public void enterPatientID(String id) {
    	patientIDBtn.click();
    	patientIDTextField.click();
    	patientIDTextField.sendKeys(id);
    	submitBtn.click();
    }

    private void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        mobileDriver.perform(Arrays.asList(tap));
    }
    
    public GetResults clickCameraBtn() throws InterruptedException {
    	//coordinates of profile
    	int x = 538;  // Set the X coordinate directly
    	int y = 1900; // Set the Y coordinate directly

    	tapByCoordinates(x, y);
    	Thread.sleep(5000);
    	return new GetResults(mobileDriver);

    }
    
    void allowPermissions() {
    	onlyThisTimeBtn.click();
    }
    
}
