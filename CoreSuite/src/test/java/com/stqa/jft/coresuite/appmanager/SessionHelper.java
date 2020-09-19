package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.*;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) {
    int totalAttempts = 3;
    while (totalAttempts != 0) {
      if (userName == "developer" && password == "password") {
        extractID();

        wd.findElement(By.name("j_username")).clear();
        wd.findElement(By.name("j_username")).sendKeys(userName);
        wd.findElement(By.name("j_password")).clear();
        wd.findElement(By.name("j_password")).sendKeys(password);
        typeClick("Login","","button","formButton z-button",null,null);


        if (isElementPresent(By.xpath("//a[@class='appLink z-a'][normalize-space(text())='Logout']"))) {
          break;
        } else {
          totalAttempts--;
          System.out.println("Current try is " + totalAttempts);
        }
      }

      if (totalAttempts == 0) {
        System.out.println("Maximum number of attempts exceeded");
      }
    }
  }

  public void logOut() {
    typeClick("Logout","","a","appLink z-a",null,null);
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
