package com.selenium.pages;

import com.selenium.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchingProduct {
    Logger logger=Logger.getLogger(SearchingProduct.class.getName());
    AndroidDriver driver;
    @FindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    WebElement skipButton;
    @FindBy(id = "com.amazon.mShop.android.shopping:id/chrome_search_hint_view")
    WebElement search;
    @FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    WebElement searchBar;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[5]/android.view.View[4]")
    WebElement product;
    public SearchingProduct(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void productSearch() throws InterruptedException {
        Thread.sleep(5000);
        skipButton.click();
        logger.info("skipped the page");
        Thread.sleep(20000);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        search.click();
        Thread.sleep(5000);
        searchBar.sendKeys("iphone 13");
        Thread.sleep(5000);
        logger.info("Entered product as iphone 13");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
        logger.info("Got the iphone 13 search results");
        product.click();
        Thread.sleep(5000);
        logger.info("Selected iPhone 13 Mini, 128GB, Blue - Unlocked (Renewed)");
    }
}
