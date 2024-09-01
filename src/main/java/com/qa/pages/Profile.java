package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class Profile {
	
	 public AndroidDriver mobileDriver;

	    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Edit\"]")
	    @CacheLookup
	    WebElement editBtn;
	    
	    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Logout\"]")
	    @CacheLookup
	    WebElement logoutBtn;
	    
	    @FindBy(xpath = "//android.widget.EditText[@text=\"Obaid\"]")
	    @CacheLookup
	    WebElement nameTextField;
	    
	    @FindBy(xpath = "//android.widget.EditText[@text=\"obaid@gmail.com\"]")
	    @CacheLookup
	    WebElement emailTextField;
	    
	    @FindBy(xpath = "//android.widget.EditText[@text=\"••••••••\"]")
	    @CacheLookup
	    WebElement passwordTextField;
	    
	    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Save Changes\"]")
	    @CacheLookup
	    WebElement saveBtn;
	    
	    public Profile(AndroidDriver mobileDriver) {
	        this.mobileDriver = mobileDriver;
	        PageFactory.initElements(mobileDriver, this);
	    }
	    
	    public void navigateBack() {
	        mobileDriver.navigate().back();
	    }
	    
	    public void navigateHome() {
	        executeKeyEvent(3); // KeyEvent.KEYCODE_HOME
	    }

	    public void showRecentApps() {
	        executeKeyEvent(187); // KeyEvent.KEYCODE_APP_SWITCH
	    }

	    private void executeKeyEvent(int keyCode) {
	        ((RemoteWebDriver) mobileDriver).executeScript("mobile: keyevent", 
	            ImmutableMap.of("keycode", keyCode));
	    }
	    
	    public void clickEditBtn() {
	    	editBtn.click();
	    }
	    
	    public void editName(String name) {
	    	nameTextField.click();
	    	nameTextField.clear();
	    	nameTextField.sendKeys(name);
	    	navigateBack();
	    	
	    }
	    
	    public void editEmail(String email) {
	    	emailTextField.click();
	    	emailTextField.clear();
	    	emailTextField.sendKeys(email);
	    	navigateBack();
	    }

	    public void editPassword(String password) {
	    	passwordTextField.click();
	    	passwordTextField.clear();
	    	passwordTextField.sendKeys(password);
	    	navigateBack();
	    }
	    
	    public void clickSaveBtn() {
	    	saveBtn.click();
	    }

}
