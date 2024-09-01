package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.google.common.collect.ImmutableMap;

import java.time.Duration;
import java.util.Arrays;

public class Homepage {
    public AndroidDriver mobileDriver;

    public Homepage(AndroidDriver mobileDriver) {
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

    public Scan clickScanBtn() {
        int x = 525; 
        int y = 2080; 

        tapByCoordinates(x, y);
        return new Scan(mobileDriver);
    }

    public Profile clickProfileBtn() {
    	//coordinates of profile
    	int x = 900;  // Set the X coordinate directly
    	int y = 2092; // Set the Y coordinate directly

    	tapByCoordinates(x, y);
    	return new Profile(mobileDriver);

    }

    private void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        mobileDriver.perform(Arrays.asList(tap));
    }
}
