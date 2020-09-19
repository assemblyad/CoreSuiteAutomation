package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHeler extends HelperBase {
  public NavigationHeler(WebDriver wd) {
    super(wd);
  }

  public void returnToHomeTab() {

    typeClick("Home",null,"span","applicationTab-line2",null,null);
//    waitForDisplayed((By.xpath("//div[3]/table/tbody/tr")), null);
  }

}
