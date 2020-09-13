package com.stqa.jft.coresuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddressPersonFormAdditionTest extends TestBase {


  @Test
  public void testAddressPersonFormAddition() throws Exception {

    gotoCustomerManagement();
    searchCustomerManagement();
    searchPersonBusinesses();
    click(By.xpath("//span[(normalize-space(text())='Address')][@class='z-tab-text']"),3);
//    click("Address","span",null,null,null);
//    click(By.xpath("//span[(normalize-space(text())='Address')][@class='z-tab-text']"),3);
//    waitForDisplayed(By.xpath("//button[(text()='Add')][@class='formButton z-button']"),5);
    click("Add","button",null,null,null);
//    click(By.xpath("//button[(text()='Add')][@class='formButton z-button']"),3);
    type("Address Type", "1099","span", null,null);
    type("Expiration Date", "","span", null,null);
    type("Country", "United States","span", null,null);
    type("Address", "Home home","input", null,null);
    type("Postal Code", "57703","input", null,null);
//    type("City", "57703","input", null,null);
    type("Latitude", "180","input", null,null);
    type("Longitude", "180","input", null,null);
    type("Comment", "Comment","textarea", null,null);
    submitPersonCreation();
  }
  private void searchPersonBusinesses() {
//    type("Name","u3LQ","input",null, null);
//    type("Tax ID","","input",null, null);
    type("Customer Number","1079000","input",null, null);
    click("Search","button",null,null,null);
//    click(By.xpath("//button[(text()='Search')][@class='formButton z-button']"),5);
  }

  private void searchCustomerManagement() {
    click("Search Customer","button",null,null,null);
//    click(By.xpath("//button[@class='navigationButton'][normalize-space(text())='Search Customer']"),5);
  }

}
