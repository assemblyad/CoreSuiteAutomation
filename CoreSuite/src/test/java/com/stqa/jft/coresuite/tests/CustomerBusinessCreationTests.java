package com.stqa.jft.coresuite.tests;

import com.stqa.jft.coresuite.model.CustomerBusiness;
import org.testng.annotations.Test;


public class CustomerBusinessCreationTests extends TestBase {

  @Test
  public void testCustomerBusinessCreation() throws Exception {

//    app.waitWebElement(app.getPersonHelper().wd,"//div[3]/table/tbody/tr","xpath");
    app.getBusinessHelper().extractID();
    app.getCustomerManagement().gotoCustomerManagement();
    app.getBusinessHelper().initBusinessCreation();
    app.getBusinessHelper().fillGeneralForm(new CustomerBusiness("United States","SSN", "000-15-2022","Payee Name", "Business Name", null, "2000", "",null));
    app.getButtons().saveButton();
    app.getNavigationHeler().returnToHomeTab();
    app.getSessionHelper().logOut();
  }

}
