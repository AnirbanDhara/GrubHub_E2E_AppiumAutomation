package com.anirbandhara.pages.android;

import com.anirbandhara.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AndroidActions {
    WebDriverWait wait;
    AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.grubhub.android:id/carousel_title\" and @text=\"Delicious Deals\"]"+"/following-sibling::androidx.recyclerview.widget.RecyclerView")
    private WebElement restaurants;

    public void scrollRestaurantsAndSelectFoodType(String sectionName){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        scrollToText(sectionName);

        swipeAction(restaurants, "left");

        clickAction();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.LinearLayout")));

    }
}

