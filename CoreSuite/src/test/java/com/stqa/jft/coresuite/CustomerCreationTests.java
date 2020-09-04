package com.stqa.jft.coresuite;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomerCreationTests {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://ohisnapdevapp34:8080/webapp/homepage.zul");
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    String finalId = extractID();
/*
    //wd.findElement(By.xpath("//input[ends-with (@id,'x')]"));
    //wd.findElement(By.xpath("//input[ends-with (@id,'x')]")).sendKeys("developer");
    "//*[starts-with(@id, 'frag-') and ends-with(@id, '-0')]"
    //div[contains(@style, 'position: fixed; left: 0px; right: 0px; top: 0px; bottom: 0px; z-index: 2147483647;')]
    driver.findElement(By.xpath("//input[@id='gVHWx']")).clear();
    driver.findElement(By.xpath("//input[@id='gVHWx']")).sendKeys("developer");

    //wd.findElement(By.xpath("//input[starts-with (@name,'j_usern')]")).clear();
    //wd.findElement(By.xpath("//input[contains(text(), 'About Google')]"));
    //wd.findElement(By.xpath("//input[matches(@id,'.{4}(.*)x$')]")).sendKeys("developer");
    //div[matches(@id,'che.*boxes')]

*/
    wd.findElement(By.id(finalId+"x")).clear();
    wd.findElement(By.id(finalId+"x")).sendKeys("developer");
    wd.findElement(By.id(finalId+"_0")).clear();
    wd.findElement(By.id(finalId+"_0")).sendKeys("password");
    wd.findElement(By.id(finalId+"50")).click();

  }

  @Test
  public void testCustomerCreation() throws Exception {


    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    String finalIdN = extractID();
    waitWebElement(wd,finalIdN+"60-cave","id");
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/table/tbody/tr")));
    waitWebElement(wd,finalIdN+"60-cave","id");
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));
    wd.findElement(By.id(finalIdN+"60-cave")).click();
    wd.findElement(By.id(finalIdN+"90")).click();
    wd.findElement(By.id(finalIdN+"9p")).click();
    wd.findElement(By.id(finalIdN+"9p")).clear();
    wd.findElement(By.id(finalIdN+"9p")).sendKeys(finalIdN);
    wd.findElement(By.id(finalIdN+"cp")).clear();
    wd.findElement(By.id(finalIdN+"cp")).sendKeys("m");
    wd.findElement(By.id(finalIdN+"fp")).clear();
    wd.findElement(By.id(finalIdN+"fp")).sendKeys(finalIdN);
    wd.findElement(By.id(finalIdN+"bq")).sendKeys("654-64-6473");
    //click();
    wd.findElement(By.id(finalIdN+"8q-icon")).click();
    wd.findElement(By.id(finalIdN+"w20")).click();
    wd.findElement(By.id(finalIdN+"bq")).click();
   // wd.findElement(By.xpath("//span[contains(@id,'9g-cnt'])/img")).click();
    wd.findElement(By.id(finalIdN+"9g-cnt")).click();
    wd.findElement(By.id(finalIdN+"e")).click();
//    wd.findElement(By.id(finalIdN+"2q-real")).click();

  }

  private String extractID() {

    String id = wd.findElement(By.xpath("//div[3]/table/tbody/tr")).getAttribute("id").substring(0,4);
    //String finalId = id.substring(0, 4);
    System.out.println("Id attribute is " + id);
    return id;
  }


  private void waitWebElement(WebDriver wd, String expression,String waitIdParameter) {
    WebDriverWait wait = new WebDriverWait(wd,30);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));
    if (waitIdParameter=="xpath") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
    } else if (waitIdParameter=="id") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
    }

  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
