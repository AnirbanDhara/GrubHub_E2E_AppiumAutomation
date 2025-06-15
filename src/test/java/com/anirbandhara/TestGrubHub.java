package com.anirbandhara;

import com.anirbandhara.pages.android.HomePage;
import com.anirbandhara.pages.android.RelatedSearchPage;
import com.anirbandhara.pages.android.SplashScreenPage;
import org.testng.annotations.Test;

public class TestGrubHub extends BaseTest{

    @Test
    public void test_PickUpFoodService() throws InterruptedException{
        SplashScreenPage screenPage = new SplashScreenPage(driver);
        screenPage.clickSearchNearBy();
        Thread.sleep(2000);
        screenPage.searchAddress("kolkata");
        screenPage.choosePlace();

        HomePage homePage = new HomePage(driver);
        homePage.scrollRestaurantsAndSelectFoodType("Crispy and Cheesy");
        Thread.sleep(2000);

//        RelatedSearchPage searchPage = new RelatedSearchPage(driver);


    }
}
