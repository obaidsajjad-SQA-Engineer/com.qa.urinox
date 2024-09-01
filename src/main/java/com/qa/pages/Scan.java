package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Scan {
	public AndroidDriver mobileDriver;
	 
 	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Camera\"]")
    @CacheLookup
    WebElement cameraBtn;
 	
 	public Scan(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver, this);
    }
 	
    public Camera clickCameraBtn() {
 		cameraBtn.click();
 		return new Camera(mobileDriver);
 	}
}
