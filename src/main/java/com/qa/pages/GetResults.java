package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class GetResults {
	public AndroidDriver mobileDriver;
	
 	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Get Result\"]")
    @CacheLookup
    WebElement getResultBtn;
 	
    public GetResults(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver, this);
    }
    
    public void clickGetResultBtn() {
    	getResultBtn.click();
    }
}
