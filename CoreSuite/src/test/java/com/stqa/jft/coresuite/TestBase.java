package com.stqa.jft.coresuite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
  protected WebDriver wd;
  protected String finalId;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
//    wd = new FirefoxDriver();
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://ohisnapdevapp34:8080/webapp/homepage.zul");
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    login("developer", "password");
  }

  private void login(String userName, String password) {
    extractID();
    int totalAttempts = 3;
    Boolean webElementDisplayed=true;
    while (totalAttempts != 0 && webElementDisplayed) {

      if (userName == "developer" && password == "password") {
        wd.findElement(By.id(finalId+"x")).clear();
        wd.findElement(By.id(finalId+"x")).sendKeys(userName);
        wd.findElement(By.id(finalId+"_0")).clear();
        wd.findElement(By.id(finalId+"_0")).sendKeys(password);
        wd.findElement(By.id(finalId+"50")).click();
        webElementDisplayed=waitForDisplayed(By.id(finalId+"20-cnt"),2);

        if (webElementDisplayed==true) totalAttempts--;

        return;

      } else {
        System.out.println("Incorrect Login");
        totalAttempts--;
        System.out.println(totalAttempts);

      }

    }

    if (totalAttempts == 0) {

      System.out.println("Maximum number of attempts exceeded");
    }
  }

  protected void returnToHomeTab() {
    wd.findElement(By.id(finalId+"v")).click();
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
  }

  protected void gotoCustomerManagement() {
    click(By.id(finalId+"60-cave"),5);



    //waitWebElement(wd, finalId +"60-cave","id");
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/table/tbody/tr")));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));

  }

  protected void click(By locator,Integer timeout ) {
      waitForDisplayed((locator),timeout);
      wd.findElement(locator).click();
  }

  protected void type(By locator,String stringToType, Integer timeout ) {
    waitForDisplayed((locator),timeout);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(stringToType);

  }

  protected void fillGeneralPersonForm(GeneralPersonForm generalPersonForm) {
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

    protected void logOut() {
    wd.findElement(By.id(finalId +"e")).click();
  }
  protected String getLastObjectId(String xpath) {
//    List<WebElement> elements =wd.findElements(By.xpath("//span[normalize-space(text())='Address']"));
    List<WebElement> elements =wd.findElements(By.xpath(xpath));
    String webElementId = elements.get(elements.size()-1).getAttribute("id");
    return webElementId;
  }

  protected void submitPersonCreation() {

    String webElementId=getLastObjectId("//a[@class='z-toolbarbutton'][@title='Save']");
    click(By.xpath("//a[@id="+"'"+webElementId+"'"+"]//span//img[@src='assets/images/global_save.gif']"),3);
  //    wd.findElement(By.id(finalId +"ww0-cnt")).click();
    //By.xpath("//img[@src='web/L001/images/IMAGENAME.jpg']"))
  }

  protected void initPersonCreation() {
    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    wd.findElement(By.id(finalId +"90")).click();
  }

  protected void extractID() {

    finalId = wd.findElement(By.xpath("//div[3]/table/tbody/tr")).getAttribute("id").substring(0,4);
    //String finalId = id.substring(0, 4);
    System.out.println("Id attribute is " + finalId);
    //return id;
  }

  protected void waitWebElement(WebDriver wd, String expression, String waitIdParameter) {
    WebDriverWait wait = new WebDriverWait(wd,30);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));
    if (waitIdParameter=="xpath") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
    } else if (waitIdParameter=="id") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
    }

  }

//  @AfterMethod(alwaysRun = true)
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

  public Boolean waitForDisplayed (By locator, Integer ... timeout){
    try {

      waitFor(ExpectedConditions.visibilityOfElementLocated(locator),timeout.length>0?timeout[0] :null);
      waitFor(ExpectedConditions.elementToBeClickable(locator),timeout.length>0?timeout[0] :null);
    } catch (org.openqa.selenium.TimeoutException exception) {
      return false;
    }
    catch (org.openqa.selenium.InvalidElementStateException exception) {
      return false;
    }
    return true;
  }

  private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
    timeout= timeout !=null ? timeout :5;
    WebDriverWait wait = new WebDriverWait(wd,timeout);
    wait.until(condition);
  }
}
