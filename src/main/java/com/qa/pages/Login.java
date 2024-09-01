package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

import com.google.common.collect.ImmutableMap;
import com.qa.base.TestBase;

import java.time.Duration;
import java.util.Collections;

public class Login extends TestBase {

    public AndroidDriver mobileDriver;

    @FindBy(xpath = "//android.view.View[@content-desc=\"New to Urinox? Register\"]")
    @CacheLookup
    WebElement newToUrinoxRegisterBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    @CacheLookup
    WebElement loginBtn;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Forgot Password?\"]")
    @CacheLookup
    WebElement forgetPasswordBtn;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    @CacheLookup
    WebElement emailTextField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    @CacheLookup
    WebElement passwordTextField;
    
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

    public Login(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver, this);
    }

    public Register clickRegisterBtn() {
        // Get the element’s location and size
        int startX = newToUrinoxRegisterBtn.getLocation().getX();
        int startY = newToUrinoxRegisterBtn.getLocation().getY();
        int elementWidth = newToUrinoxRegisterBtn.getSize().getWidth();
        int elementHeight = newToUrinoxRegisterBtn.getSize().getHeight();

        // Calculate the coordinates to target the "Register" part
        int clickX = startX + (int) (elementWidth * 0.75); // Adjust percentage as needed
        int clickY = startY + (int) (elementHeight * 0.5);  // Middle of the element's height

        // Create a pointer input for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create the tap action sequence
        Sequence tapSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), clickX, clickY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the tap action
        mobileDriver.perform(Collections.singletonList(tapSequence));

        return new Register(mobileDriver);
    }
    
    public void enterEmail(String email) {
        emailTextField.click();
        emailTextField.sendKeys(email);
        navigateBack();
    }
    
    public void enterPassword(String password) {
        passwordTextField.click();
        passwordTextField.sendKeys(password);
        navigateBack();
    }
    
    public void clickLoginBtn() {
    	loginBtn.click();
    }
}
