package com.selenium;

import com.selenium.base.BaseClass;
import com.selenium.pages.SearchingProduct;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AmazonTest extends BaseClass {
    Logger logger=Logger.getLogger(AmazonTest.class.getName());
    SearchingProduct searchingProduct;
    @BeforeTest
    public void start() throws MalformedURLException {
        setup();
        searchingProduct=new SearchingProduct(driver);
    }
    @Test
    public void searchingAProduct() throws InterruptedException {
        searchingProduct.productSearch();
    }
}
