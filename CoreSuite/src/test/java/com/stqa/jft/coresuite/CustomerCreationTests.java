package com.stqa.jft.coresuite;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomerCreationTests {
  private WebDriver wd;
  private String finalId;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://ohisnapdevapp34:8080/webapp/homepage.zul");
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    login("developer", "password");

  }

  private void login(String userName, String password) {
    extractID();
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
    wd.findElement(By.id(finalId+"x")).sendKeys(userName);
    wd.findElement(By.id(finalId+"_0")).clear();
    wd.findElement(By.id(finalId+"_0")).sendKeys(password);
    wd.findElement(By.id(finalId+"50")).click();
  }

  @Test
  public void testCustomerCreation() throws Exception {

    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    extractID();
    gotoCustomerManagement();
    initPersonCreation();
    fillGeneralPersonForm(new GeneralPersonForm("United States", "Mr.", "Jr.", "m", "SSN", "000-00-0008", "Married - Filing Joint", "2", "Payee Name", "01/01/1990", "", "Female", "Common Law"));
    submitPersonCreation();
    returnToHomeTab();
    logOut();
  }

  private void returnToHomeTab() {
    wd.findElement(By.id(finalId+"v")).click();
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
  }

  private void gotoCustomerManagement() {
    waitWebElement(wd, finalId +"60-cave","id");
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/table/tbody/tr")));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));

    wd.findElement(By.id(finalId +"60-cave")).click();
  }

  private void fillGeneralPersonForm(GeneralPersonForm generalPersonForm) {
    /*
    waitWebElement(wd,finalId +"9p","id");
    wd.findElement(By.cssSelector(finalId+"bo"));
    //driver.findElement(By.id("hFBP_p-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBP3p']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"3p > span.z-comboitem-text"));
    //driver.findElement(By.id("hFBPip-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBPop']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"op > span.z-comboitem-text"));
    //driver.findElement(By.id("hFBPiq-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBPlq']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"lq > span.z-comboitem-text"));
*/

    wd.findElement(By.id(finalId+"1i-real")).click();
    wd.findElement(By.id(finalId+"1i-real")).clear();
    //wd.findElement(By.id(finalId+"1i-real")).sendKeys("");
    wd.findElement(By.id(finalId+"1i-real")).sendKeys(generalPersonForm.getCountry());
    wd.findElement(By.id(finalId+"_p-real")).click();
    wd.findElement(By.id(finalId+"_p-real")).sendKeys(generalPersonForm.getTitle());
    wd.findElement(By.id(finalId+"ip-real")).click();
    wd.findElement(By.id(finalId+"ip-real")).sendKeys(generalPersonForm.getSuffix());
    wd.findElement(By.id(finalId +"9p")).click();
    wd.findElement(By.id(finalId +"9p")).clear();
    wd.findElement(By.id(finalId +"9p")).sendKeys(finalId);
    wd.findElement(By.id(finalId +"cp")).clear();
    wd.findElement(By.id(finalId +"cp")).sendKeys(generalPersonForm.getMi());
    wd.findElement(By.id(finalId +"fp")).clear();
    wd.findElement(By.id(finalId +"fp")).sendKeys(finalId);
    wd.findElement(By.id(finalId +"8q-real")).click();
    wd.findElement(By.id(finalId +"8q-real")).clear();
    //wd.findElement(By.id(finalId +"8q-real")).sendKeys("");
    wd.findElement(By.id(finalId +"8q-real")).sendKeys(generalPersonForm.getTaxIdType());
    wd.findElement(By.id(finalId +"bq")).sendKeys(generalPersonForm.getTax_id());
    wd.findElement(By.id(finalId +"iq-real")).click();
    wd.findElement(By.id(finalId +"iq-real")).sendKeys("");
    wd.findElement(By.id(finalId +"iq-real")).sendKeys(generalPersonForm.getTaxStatus());
    wd.findElement(By.id(finalId +"rq")).click();
//    wd.findElement(By.id(finalId +"rq")).clear();
    wd.findElement(By.id(finalId +"rq")).sendKeys(generalPersonForm.getNumberOfExamptions());
    wd.findElement(By.id(finalId +"yq")).clear();
    wd.findElement(By.id(finalId +"yq")).sendKeys(generalPersonForm.getPayeeName());
//    wd.findElement(By.id(finalId +"8q-icon")).click();
//    wd.findElement(By.id(finalId +"20")).click();
//    wd.findElement(By.id(finalId +"bq")).click();
    wd.findElement(By.id(finalId +"4r-real")).clear();
    wd.findElement(By.id(finalId +"4r-real")).sendKeys(generalPersonForm.getDob());
    wd.findElement(By.id(finalId +"7r-real")).clear();
    wd.findElement(By.id(finalId +"7r-real")).sendKeys(generalPersonForm.getDod());
    wd.findElement(By.id(finalId +"ar-real")).click();
    wd.findElement(By.id(finalId +"ar-real")).sendKeys(generalPersonForm.getGender());
    wd.findElement(By.id(finalId +"hr-real")).click();
    wd.findElement(By.id(finalId +"hr-real")).sendKeys(generalPersonForm.getMartialStatus());

/*
    //driver.findElement(By.id("pXDPyh-icon")).click();
    //driver.findElement(By.id("pXDPxn")).click();
    //driver.findElement(By.id("pXDPyh-icon")).click();
    //driver.findElement(By.id("pXDPbo")).click();
    wd.findElement(By.cssSelector(finalId+"bo"));
    //driver.findElement(By.id("hFBP_p-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBP3p']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"3p > span.z-comboitem-text"));
    //driver.findElement(By.id("hFBPip-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBPop']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"op > span.z-comboitem-text"));
    //driver.findElement(By.id("hFBPiq-icon")).click();
    //driver.findElement(By.xpath("//li[@id='hFBPlq']/span[2]")).click();
    wd.findElement(By.cssSelector(finalId+"lq > span.z-comboitem-text"));
    wd.findElement(By.id(finalId+"rq")).click();
    wd.findElement(By.id(finalId+"rq")).clear();
    wd.findElement(By.id(finalId+"rq")).sendKeys("2");
    wd.findElement(By.id(finalId+"yq")).click();
    wd.findElement(By.id(finalId+"yq")).clear();
    wd.findElement(By.id(finalId+"yq")).sendKeys("Payee Name");
    wd.findElement(By.id(finalId+"4r-real")).click();
    wd.findElement(By.id(finalId+"4r-real")).clear();
    wd.findElement(By.id(finalId+"4r-real")).sendKeys("01/01/1980");
    wd.findElement(By.id(finalId+"ar-icon")).click();
    wd.findElement(By.id(finalId+"cr")).click();
    wd.findElement(By.id(finalId+"hr-icon")).click();
    wd.findElement(By.cssSelector(finalId+"jr > span.z-comboitem-text"));

*/


  }

  private void logOut() {
    wd.findElement(By.id(finalId +"e")).click();
  }

  private void submitPersonCreation() {
    wd.findElement(By.id(finalId +"9g-cnt")).click();
  }

  private void initPersonCreation() {
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    wd.findElement(By.id(finalId +"90")).click();
  }

  private void extractID() {

    finalId = wd.findElement(By.xpath("//div[3]/table/tbody/tr")).getAttribute("id").substring(0,4);
    //String finalId = id.substring(0, 4);
    System.out.println("Id attribute is " + finalId);
    //return id;
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
