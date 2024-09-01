package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;


public class Register {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    @CacheLookup
    WebElement emailTextField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    @CacheLookup
    WebElement nameTextField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]")
    @CacheLookup
    WebElement passwordTextField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Continue\"]")
    @CacheLookup
    WebElement continueBtn;
    
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

    public AndroidDriver mobileDriver;

    public Register(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver, this);
    }

    public void enterEmail(String email) {
        emailTextField.click();
        emailTextField.sendKeys(email);
        navigateBack();
    }

    public void enterName(String name) {
        nameTextField.click();
        nameTextField.sendKeys(name);
        navigateBack();
    }

    public void enterPassword(String password) {
        passwordTextField.click();
        passwordTextField.sendKeys(password);
        navigateBack();
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }
}
