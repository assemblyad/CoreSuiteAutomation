package com.stqa.jft.coresuite.tests;

import com.stqa.jft.coresuite.model.GeneralPersonForm;
import org.testng.annotations.Test;


public class CustomerPersonCreationTests extends TestBase {

  @Test
  public void testCustomerPersonCreation() throws Exception {
    app.getPersonHelper().extractID();
    app.getCustomerManagement().gotoCustomerManagement();
    app.getPersonHelper().initPersonCreation();
    app.getPersonHelper().fillGeneralPersonForm(new GeneralPersonForm("United States", "Mr.", "Jr.", "m", "SSN", "000-11-2021", "Married - Filing Joint", "2", "Payee Name", "01/01/1990", "", "Female", "Common Law"));
    app.getButtons().saveButton();
    app.getNavigationHeler().returnToHomeTab();
    app.getSessionHelper().logOut();
  }
}
