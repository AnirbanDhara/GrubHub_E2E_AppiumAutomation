package com.anirbandhara.pages.android;

import com.anirbandhara.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RelatedSearchPage extends AndroidActions {
    AndroidDriver driver;
    WebDriverWait wait;

    public RelatedSearchPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(id = "com.grubhub.android:id/restaurant_name")
    private WebElement restaurantName;

    public void chooseRestaurant(){
        scrollToEndAction();
    }
}
