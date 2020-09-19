package com.stqa.jft.coresuite.tests;

import org.testng.annotations.Test;

public class AddressPersonFormAdditionTest extends TestBase {


  @Test
  public void testAddressPersonFormAddition() throws Exception {

    app.getCustomerManagement().gotoCustomerManagement();
    app.getCustomerManagement().searchCustomerManagement();
    app.getCustomerManagement().searchCustomerBusinesses();
    app.getPersonHelper().typeClick("Address",null,"span","z-tab-text",null,null);
    app.getPersonHelper().typeClick("Add",null,"button","formButton z-button",null,null);
    app.getPersonHelper().typeClick("Address Type","1099","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Expiration Date","","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Country","United States","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Address","United States for Address","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Postal Code","57703","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Latitude","180","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Longitude","180","span","fieldTitle z-label",null,null);
    app.getPersonHelper().typeClick("Comment","Comment","span","fieldTitle z-label",null,null);
    app.getButtons().saveButton();
  }

}
