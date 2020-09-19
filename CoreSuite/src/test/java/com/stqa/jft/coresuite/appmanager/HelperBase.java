package com.stqa.jft.coresuite.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelperBase {
  protected WebDriver wd;
  protected String finalId;

  public HelperBase(WebDriver wd) {
    this.wd=wd;
  }

  public HelperBase() {

  }

  public void typeClick(String fieldNameTitle, String stringToType, String tagName, String className, Integer timeout, Integer index) {


      int count = 0;
      String id = null;

      while (id == null & count < 20) {
        id = getWebId(fieldNameTitle, stringToType, tagName, className, null);
        if (id == null)
          System.out.println("This is from method typeClick due id is null " + id + " and count is " + count);
        count++;

      }

      if (index == null) index = 0;
      if (!waitForDisplayed((By.id(id)), timeout)) {
        System.out.println("I am reviewing here");
        System.out.println("The field with name " + fieldNameTitle + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.xpath(id)).getAttribute("class"));
      }

//    String classNameN = wd.findElement(By.id(id)).getAttribute("class");
      WebElement elem = wd.findElement(By.id(id));
      if (stringToType != null && !stringToType.equals("")) {
//      WebElement elem = wd.findElements(By.id(id + "//parent::div//following-sibling::div//*[@class ='z-textbox' or type='text' or @class ='z-combobox-input']")).get(index);
        if (waitForDisplayed(By.id(id))) {
          elem.click();
          elem.clear();
          elem.sendKeys(stringToType);
        }
      } else {
        if (waitForDisplayed(By.id(id))) {
//        WebElement elem = wd.findElements(By.id(id)).get(index);
          elem.isEnabled();
          elem.click();  ////*[@class='portlet'] "z-caption-content"
        }
      }

/*
    switch (classNameN) {
      case "z-combobox-input":
        if (!stringToType.equals(wd.findElement(By.id(id.concat("//following-sibling::a"))).getText())) {
          wd.findElement(By.id(id.concat("//following-sibling::a"))).click();

          String improvedStringToType = null;
          String[] fieldNameArray = stringToType.split(" ");
          if (fieldNameArray.length > 1) {
            improvedStringToType = stringToType.trim().replace(" ", "\u00A0");
          } else {
            improvedStringToType = stringToType;
          }
          wd.findElement(By.id("//span[@class='z-comboitem-text'][text()='" + improvedStringToType + "']")).click();
        }
        break;
      case "z-datebox-input":
        if (!waitForDisplayed((By.id(id)), timeout)) {
          System.out.println("The field with name " + fieldNameTitle + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.id(id)).getAttribute("class"));
        }
      default:

        if (!waitForDisplayed((By.id(id)), timeout)) {
          System.out.println("The field with name " + fieldNameTitle + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.id(id)).getAttribute("class"));
        }
        wd.findElement(By.id(id)).clear();
        wd.findElement(By.id(id)).sendKeys(stringToType);
    }
*/

  }

  public String getWebId(String fieldNameTitle, String stringToType, String tagName, String className, Integer index) {
    String xPath = null;
    List<WebElement> elements;
    String improvedFieldName = fieldNameTitle;
    String[] fieldNameArray = fieldNameTitle.split(" ");
    String id=null;

    if (index == null) index = 1;

    if (fieldNameArray.length > 1) {
      if (tagName == "span" || tagName == "input" || tagName == "textarea") {
        improvedFieldName = fieldNameTitle.trim().replace(" ", "\u00A0");
      } else improvedFieldName = fieldNameTitle;
    }

    if (fieldNameTitle!="Save") {
      elements = wd.findElements(By.xpath("//*[@class = '" + className + "'][normalize-space(text())='" + improvedFieldName + "']"));
    } else {
      elements = wd.findElements(By.xpath("//*[@class = '" + className + "'][@title=normalize-space('" + improvedFieldName + "')]"));
      for (WebElement element : elements)
        if (element.getAttribute("disabled") == null) return element.getAttribute("id");
    }
  if (elements.size()>0) {
    for (WebElement element : elements) {
      if (element.getText().equals(fieldNameTitle)) {
        xPath = element.toString().replaceAll(".+xpath: ", "").replace("]]", "]");
        if (stringToType != null && !stringToType.equals("")) {
          xPath += "//parent::div//following-sibling::div//*[@class ='z-textbox' or @class ='z-doublebox' or type='text' or @class ='z-combobox-input' or @class ='z-intbox' or @class ='z-datebox-input']";
        }
        id = wd.findElements(By.xpath(xPath)).get(elements.size() - 1).getAttribute("id");
//        System.out.println("This is from method getWebId before checking returning null " + id);
        if (!waitForDisplayed((By.id(id)), 5)) {
          System.out.println("This is from method getWebId before returning null " + id);
          return null;
        }
      }
    }
  } else {
    System.out.println("This is from method getWebId, no web elements found for field "+fieldNameTitle+"thus returning id null");
  }
    return id;
  }

  public String extractID() {
    finalId = wd.findElement(By.xpath("//div[3]/table/tbody/tr")).getAttribute("id").substring(0, 4);
    System.out.println("Id attribute is " + finalId);
    return finalId;
  }

  public Boolean waitForDisplayed(By locator, Integer... timeout) {
    try {
      waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeout.length > 0 ? timeout[0] : null);
      waitFor(ExpectedConditions.elementToBeClickable(locator), timeout.length > 0 ? timeout[0] : null);
      waitFor(ExpectedConditions.presenceOfElementLocated(locator), timeout.length > 0 ? timeout[0] : null);
    } catch (TimeoutException exception) {
      System.out.println("I am reviewing fail of error from TimeoutException " + exception.getMessage());
      return false;
    }
    catch (ElementNotInteractableException exception) {
      System.out.println("I am reviewing fail of error from ElementNotInteractableException " + exception.getMessage());
      return false;
    } catch (InvalidElementStateException exception) {
      System.out.println("I am reviewing fail of error from InvalidElementStateException" + exception.getMessage());
      return false;
    }

    return true;
  }

  public void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
    timeout = timeout != null ? timeout : 5;
    WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(condition);
  }

  public void waitForList(ExpectedCondition<List<WebElement>> condition, Integer timeout) {
    timeout = timeout != null ? timeout : 5;
    WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(condition);
  }
  public String currentDate() {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
    Date date = new Date();
    String date1= dateFormat.format(date);
    return date1;
  }
  public Boolean waitForDisplayedList(By locator, Integer... timeout) {
    try {
      waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(locator), timeout.length > 0 ? timeout[0] : null);
    } catch (TimeoutException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    } catch (ElementNotInteractableException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    } catch (InvalidElementStateException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    }
    return true;
  }

  public void waitWebElement(WebDriver wd, String expression, String waitIdParameter) {
    WebDriverWait wait = new WebDriverWait(wd, 30);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));
    if (waitIdParameter == "xpath") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
    } else if (waitIdParameter == "id") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
    }
  }

}
