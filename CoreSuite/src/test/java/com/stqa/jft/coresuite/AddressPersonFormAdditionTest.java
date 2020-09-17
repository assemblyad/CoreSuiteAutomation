package com.stqa.jft.coresuite;

import org.testng.annotations.Test;

public class AddressPersonFormAdditionTest extends TestBase {


  @Test
  public void testAddressPersonFormAddition() throws Exception {

    gotoCustomerManagement();
    searchCustomerManagement();
    searchPersonBusinesses();
    typeClick("Address",null,"span","z-tab-text",null,null);
    typeClick("Add",null,"button","formButton z-button",null,null);
    typeClick("Address Type","1099","span","fieldTitle z-label",null,null);
    typeClick("Expiration Date","","span","fieldTitle z-label",null,null);
    typeClick("Country","United States","span","fieldTitle z-label",null,null);
    typeClick("Address","United States for Address","span","fieldTitle z-label",null,null);
    typeClick("Postal Code","57703","span","fieldTitle z-label",null,null);
    typeClick("Latitude","180","span","fieldTitle z-label",null,null);
    typeClick("Longitude","180","span","fieldTitle z-label",null,null);
    typeClick("Comment","Comment","span","fieldTitle z-label",null,null);
    submitPersonCreation();
  }
  private void searchPersonBusinesses() {
    typeClick("Customer Number","1079000","span","fieldTitle z-label",null,null);
    typeClick("Search",null,"button","formButton z-button",null,null);
  }

  private void searchCustomerManagement() {
    typeClick("Search Customer",null,"button","navigationButton",null,null);
  }

}
