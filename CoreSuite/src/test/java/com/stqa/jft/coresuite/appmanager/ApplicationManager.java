package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private NavigationHeler navigationHeler;
  private SessionHelper sessionHelper;
  private Buttons buttons;
  private CustomerManagementHelper customerManagementHelper;
  private BusinessHelper businessHelper;
  private PersonHelper personHelper;
  public WebDriver wd;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://ohisnapdevapp34:8080/webapp/homepage.zul");
    wd.manage().window().maximize();
//    navigationHeler.waitForDisplayed(By.xpath("//div[3]/table/tbody/tr"),null);
    personHelper = new PersonHelper(wd);
    businessHelper = new BusinessHelper(wd);
    customerManagementHelper = new CustomerManagementHelper(wd);
    sessionHelper = new SessionHelper(wd);
    buttons = new Buttons(wd);
    navigationHeler = new NavigationHeler(wd);
    sessionHelper.login("developer", "password");
//    navigationHeler.waitForDisplayed(By.xpath("//div[3]/table/tbody/tr"),null);
  }

  public void stop() {
    wd.quit();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public PersonHelper getPersonHelper() {
    return personHelper;
  }

  public BusinessHelper getBusinessHelper() {
    return businessHelper;
  }

  public CustomerManagementHelper getCustomerManagement() {
    return customerManagementHelper;
  }

  public Buttons getButtons() {
    return buttons;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public NavigationHeler getNavigationHeler() {
    return navigationHeler;
  }
}
