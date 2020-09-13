package com.stqa.jft.coresuite;

import org.testng.annotations.Test;


public class CustomerCreationTests extends TestBase {

  @Test
  public void testCustomerCreation() throws Exception {

    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    extractID();
    gotoCustomerManagement();
    initPersonCreation();
    fillGeneralPersonForm(new GeneralPersonForm("United States", "Mr.", "Jr.", "m", "SSN", "000-00-0014", "Married - Filing Joint", "2", "Payee Name", "01/01/1990", "", "Female", "Common Law"));
    submitPersonCreation();
    returnToHomeTab();
    logOut();
  }


}
