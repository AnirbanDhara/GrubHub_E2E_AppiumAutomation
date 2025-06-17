package com.anirbandhara.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class AndroidActions {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }

    public void longPressAction(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()),
                "duration", 2000);
    }

    public void scrollToEndAction() {

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));

    }

    public void scrollToText(String text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\"))" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    public void swipeAction(WebElement element, String direction) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 0.08
        ));
    }

    public void clickAction(WebElement element){

        ((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void dragAction(WebElement element){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 100,
                "endY", 100
        ));
    }

}
