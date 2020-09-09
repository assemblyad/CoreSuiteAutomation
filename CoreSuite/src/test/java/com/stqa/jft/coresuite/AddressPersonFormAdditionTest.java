package com.stqa.jft.coresuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class AddressPersonFormAdditionTest extends TestBase {


  @Test
  public void testAddressPersonFormAddition() throws Exception {


    waitWebElement(wd,"//div[3]/table/tbody/tr","xpath");
    extractID();
//    gotoCustomerManagement();
    gotoCustomerManagement();
    //wd.findElement(By.id("lT4Q60")).click();
    searchCustomerManagement();
    searchPersonBusinesses();
    //div[text()='norepl  y@somedomain.com']
    click(By.xpath("//span[(normalize-space(text())='Address')][@class='z-tab-text']"),3);
//    wd.findElement(By.xpath("//span[(normalize-space(text())='Address')][@class='z-tab-text']")).click();
//    wd.findElement(By.id(finalId+"zx0-cnt")).click();
    Boolean webElementDisplayed=false;
    webElementDisplayed=waitForDisplayed(By.xpath("//button[(text()='Add')][@class='formButton z-button']"),5);
    click(By.xpath("//button[(text()='Add')][@class='formButton z-button']"),3);
//    wd.findElement(By.xpath("//button[(text()='Add')][@class='formButton z-button']")).click();

//    wd.findElement(By.xpath("//div[@class='z-hlayout-inner']//div[@class='z-toolbar z-toolbar-panel']//button[@class='formButton z-button'][contains(text(),'Add')]")).click();
//    wd.findElement(By.xpath("//span[(text()='Address Type')][@class='fieldTitle z-label']")).click();
    //wd.findElement(By.xpath("//span[@class='z-combobox z-combobox-disabled']//input[@class='z-combobox-input']")).sendKeys("1099");
    //input[@class='z-combobox-input z-combobox-hover']
//    wd.findElement(By.xpath("//span[normalize-space(text())='Address\u00A0Type']//parent::div[@id='iPIQp81-chdex']//following-sibling::div//span//input")).clear();
    type(By.xpath("//span[normalize-space(text())='Address\u00A0Type']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input"),"1099",10);
//    wd.findElement(By.xpath("//span[normalize-space(text())='Address\u00A0Type']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Address\u00A0Type']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).sendKeys("1099");
    type(By.xpath("//span[normalize-space(text())='Effective\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input"),"",3);
    type(By.xpath("//span[normalize-space(text())='Effective\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input"),"09/08/2020",3);
//    wd.findElement(By.xpath("//span[normalize-space(text())='Effective\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Effective\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).sendKeys("09/05/2020");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Expiration\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Expiration\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).sendKeys("");
    type(By.xpath("//span[normalize-space(text())='Expiration\u00A0Date']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input"),"",3);
//    String webElementId=wd.findElement(By.xpath("//span[normalize-space(text())='Country']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).getAttribute("id");
//    wd.findElement(By.id(webElementId)).clear();
//    wd.findElement(By.id(webElementId)).sendKeys("United States");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Country']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Country']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input")).sendKeys("United States");

    //getLastObjectId();
    String webElementId=getLastObjectId("//span[normalize-space(text())='Address']");
    type(By.xpath("//span[@id="+"'"+webElementId+"'"+"]//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),"Home",3);

//    wd.findElement(By.xpath("//span[@id="+webElementId+"]//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[@id="+webElementId+"]//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("United States");

//    wd.findElement(By.id(webElementId)).clear();

//    wd.findElement(By.id(webElementId)).sendKeys("United States");

//    wd.findElement(By.xpath("//span[normalize-space(text())='Address']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Address']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("United States");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Address']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
    webElementId=getLastObjectId("//span[normalize-space(text())='Postal\u00A0Code']");
    type(By.xpath("//span[@id="+"'"+webElementId+"'"+"]//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),"57703",3);
    click(By.xpath("//span[@id="+"'"+webElementId+"'"+"]//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),3);
//    wd.findElement(By.xpath("//span[normalize-space(text())='Postal\u00A0Code']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Postal\u00A0Code']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("57703");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Latitude']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Latitude']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("180");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Longitude']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Longitude']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("180");
//    wd.findElement(By.xpath("//span[normalize-space(text())='Comment']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).clear();
//    wd.findElement(By.xpath("//span[normalize-space(text())='Comment']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input")).sendKeys("Comment");
  //span[@class='z-combobox z-combobox-disabled']//input[@placeholder='-Select-']
  //.xpath("//span[@class='z-combobox z-combobox-disabled']//input[@class='z-combobox-input']")).sendKeys("1099");
    submitPersonCreation();
    //wd.findElement(By.xpath("//span[@id='lT4Qcx0-cnt']/img")).click();
  }

  //  @org.jetbrains.annotations.NotNull
/*  private String getLastObjectId(String xpath) {
//    List<WebElement> elements =wd.findElements(By.xpath("//span[normalize-space(text())='Address']"));
    List<WebElement> elements =wd.findElements(By.xpath(xpath));
    String webElementId = elements.get(elements.size()-1).getAttribute("id");
    return webElementId;
  }
*/

  private void searchPersonBusinesses() {
    type(By.xpath("//span[normalize-space(text())='Name']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),"dHwP",3);
//    type(By.id(finalId+"qf"),"dHwP",3);
//    wd.findElement(By.id(finalId+"uf")).clear();
//    wd.findElement(By.id(finalId+"uf")).sendKeys("dHwP");
    type(By.xpath("//span[normalize-space(text())='Tax\u00A0ID']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),"",3);
//    type(By.id(finalId+"uf"),"",3);
//    wd.findElement(By.id(finalId+"yf")).clear();
//    wd.findElement(By.id(finalId+"yf")).sendKeys("");

    type(By.xpath("//span[normalize-space(text())='Customer\u00A0Number']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"),"1077017",3);
//    type(By.id(finalId+"xf"),"1077017",3);
//    wd.findElement(By.id(finalId+"0g")).clear();
//    wd.findElement(By.id(finalId+"0g")).sendKeys("1077017");


    click(By.xpath("//button[(text()='Search')][@class='formButton z-button']"),5);
//    click(By.id(finalId+"uq"),3);
//    wd.findElement(By.id(finalId+"yq")).click();
  }

  private void searchCustomerManagement() {
    click(By.id(finalId+"80"),5);
   // wd.findElement(By.id(finalId+"80")).click();
  }

}
