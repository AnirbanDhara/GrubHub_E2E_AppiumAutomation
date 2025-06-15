package com.anirbandhara.pages.android;

import com.anirbandhara.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class HomePage extends AndroidActions {
    WebDriverWait wait;
    AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.grubhub.android:id/carousel_title\" and @text=\"Crispy and Cheesy\"]"+"/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.grubhub.android:id/topics_carousel\"]")
    private WebElement restaurants;

    public void scrollRestaurantsAndSelectFoodType(String sectionName){
        scrollToText(sectionName);

        swipeAction(restaurants, "left");

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), 96, 1754));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200))); // Optional pause for realism
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.LinearLayout")));

    }
}

