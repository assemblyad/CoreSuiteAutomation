package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.WebDriver;

public class CustomerManagementHelper extends HelperBase {

  public CustomerManagementHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoCustomerManagement() {
    typeClick("Customer Management",null,"div","z-caption-content",null,null);
  }

  public void searchCustomerBusinesses() {
    typeClick("Customer Number","1079000","span","fieldTitle z-label",null,null);
    typeClick("Search",null,"button","formButton z-button",null,null);
  }

  public void searchCustomerManagement() {
    typeClick("Search Customer",null,"button","navigationButton",null,null);
  }
}
