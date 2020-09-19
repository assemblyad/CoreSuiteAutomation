package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.WebDriver;

public class Buttons extends HelperBase {
  public Buttons(WebDriver wd) {
    super(wd);
  }

  public void saveButton() {
    typeClick("Save","","a","z-toolbarbutton",null,null);
  }
}
