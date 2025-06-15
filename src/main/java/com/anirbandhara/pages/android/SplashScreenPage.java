package com.anirbandhara.pages.android;

import com.anirbandhara.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;


public class SplashScreenPage extends AndroidActions {

    AndroidDriver driver;
    WebDriverWait wait;
    public SplashScreenPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.grubhub.android:id/welcome_button")
    private WebElement searchNearByButton;

    @AndroidFindBy(id = "com.grubhub.android:id/welcome_login_message_button")
    private WebElement signInButton;

    @AndroidFindBy(id = "com.grubhub.android:id/address_bar")
    private WebElement addressBar;

    public void clickSearchNearBy(){
        clickAction(searchNearByButton);
    }

    public void clickSignIn(){
        clickAction(signInButton);
    }

    public void searchAddress(String location){
        addressBar.sendKeys(location);
    }

    public void choosePlace(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@resource-id, 'welcome_screen_secondary_content')]")));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), 453, 1195));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200))); // Optional pause for realism
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
    }
}
