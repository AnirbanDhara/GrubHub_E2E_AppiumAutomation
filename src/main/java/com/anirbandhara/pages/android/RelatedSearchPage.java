package com.anirbandhara.pages.android;

import com.anirbandhara.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

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

    @AndroidFindBy(id = "com.grubhub.android:id/enterprise_add_to_cart_button")
    private WebElement addToBagBtn;

    @AndroidFindBy(id = "com.grubhub.android:id/add_button")// flame diner
    private WebElement addButton;

    public void chooseRestaurant(){
        int count = 3;
        for(int i = 0; i < count; i++){
            scrollToEndAction();
        }
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), 322, 843));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200))); // Optional pause for realism
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));

//        wait.until(ExpectedConditions.visibilityOf(addToBagBtn));
    }
}
