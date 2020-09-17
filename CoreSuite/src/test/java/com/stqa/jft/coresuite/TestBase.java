package com.stqa.jft.coresuite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
  protected WebDriver wd;
  protected String finalId;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
//    wd = new FirefoxDriver();
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://ohisnapdevapp34:8080/webapp/homepage.zul");
    wd.manage().window().maximize();
    waitWebElement(wd, "//div[3]/table/tbody/tr", "xpath");
    login("developer", "password");
  }

  private void login(String userName, String password) {
    int totalAttempts = 3;
    while (totalAttempts != 0) {
      if (userName == "developer" && password == "password") {
        extractID();
//        type("Title", generalPersonForm.getTitle(),"span", null,null);
        wd.findElement(By.name("j_username")).clear();
        wd.findElement(By.name("j_username")).sendKeys(userName);
        wd.findElement(By.name("j_password")).clear();
        wd.findElement(By.name("j_password")).sendKeys(password);
        click("Login", "button", "", null, null);

        if (isElementPresent(By.xpath("//a[@class='appLink z-a'][normalize-space(text())='Logout']"))) {
          break;
        } else {
          totalAttempts--;
          System.out.println("Current try is " + totalAttempts);
        }
      }

      if (totalAttempts == 0) {
        System.out.println("Maximum number of attempts exceeded");
      }
    }
  }

  protected void returnToHomeTab() {
    click("Home", "span", null, null, null);
    typeClick("Home",null,"span","applicationTab-line2",null,null);
    waitWebElement(wd, "//div[3]/table/tbody/tr", "xpath");
  }

  protected void gotoCustomerManagement() {
    typeClick("Customer Management",null,"div","z-caption-content",null,null);
  }
  protected void click(By locator,Integer timeout ) {
    waitForDisplayed((locator),timeout);
    wd.findElement(locator).click();
  }

  protected void click(String buttonName, String tagName, String fieldProperty, Integer timeout, Integer index) {
    String xpath = getXpath(buttonName, tagName, fieldProperty, index);
    if (!waitForDisplayed((By.xpath(xpath)), timeout)) {

      System.out.println("The click on button/link named " + buttonName + " didn't work, the tag name and field property as following " + tagName + fieldProperty);
    }
    wd.findElement(By.xpath(xpath)).click();
  }

  protected void type(By locator, String stringToType, Integer timeout) {


    String webElementId = getLastObjectId(locator.toString().replace("By.xpath:", ""));
    String className = wd.findElement(By.id(webElementId)).getAttribute("class");

    waitForDisplayed((By.id(webElementId)), timeout);

    switch (className) {
      case "z-combobox-input":
        wd.findElement(By.xpath(locator.toString().replace("By.xpath:", "").concat("[@id='" + webElementId + "']").concat("//following-sibling::a"))).click();
        wd.findElement(By.xpath("//span[@class='z-comboitem-text'][text()='" + stringToType + "']")).click();
        break;

      default:
        if (wd.findElement(locator).toString().contains(("//span[normalize-space(text())='Address']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input"))) {
          List<WebElement> elements = wd.findElements(locator);
          webElementId = elements.get(elements.size() - 2).getAttribute("id");
        }
        wd.findElement(By.xpath(locator.toString().replace("By.xpath:", "").concat("[@id='" + webElementId + "']"))).clear();
        wd.findElement(By.xpath(locator.toString().replace("By.xpath:", "").concat("[@id='" + webElementId + "']"))).sendKeys(stringToType);
    }
  }

  protected void type(String fieldName, String stringToType, String fieldProperty, Integer timeout, Integer index) {
    String xpath = getXpath(fieldName, null, fieldProperty, null);

    if (!waitForDisplayed((By.xpath(xpath)), timeout)) {
      System.out.println("I am reviewing here");
      System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.xpath(xpath)).getAttribute("class"));
    }

    String className = wd.findElement(By.xpath(xpath)).getAttribute("class");

    switch (className) {
      case "z-combobox-input":
        if (!stringToType.equals(wd.findElement(By.xpath(xpath.concat("//following-sibling::a"))).getText())) {
          wd.findElement(By.xpath(xpath.concat("//following-sibling::a"))).click();

          String improvedStringToType = null;
          String[] fieldNameArray = stringToType.split(" ");
          if (fieldNameArray.length > 1) {
            improvedStringToType = stringToType.trim().replace(" ", "\u00A0");
          } else {
            improvedStringToType = stringToType;
          }
          wd.findElement(By.xpath("//span[@class='z-comboitem-text'][text()='" + improvedStringToType + "']")).click();
        }
        break;
      case "z-datebox-input":
        if (!waitForDisplayed((By.xpath(xpath)), timeout)) {
          System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.xpath(xpath)).getAttribute("class"));
        }
      default:

        if (!waitForDisplayed((By.xpath(xpath)), timeout)) {
          System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.xpath(xpath)).getAttribute("class"));
        }
        wd.findElement(By.xpath(xpath)).clear();
        wd.findElement(By.xpath(xpath)).sendKeys(stringToType);
    }


  }

  protected String getXpath(String fieldName, String tagName, String fieldProperty, Integer index) {

    String xpath = null;
    List<WebElement> elements;
    String improvedFieldName = fieldName;
    String[] fieldNameArray = fieldName.split(" ");
//    int trueSize = 0;


    if (index == null) index = 1;

    if (fieldNameArray.length > 1) {
      if (fieldProperty == "span" || fieldProperty == "input" || fieldProperty == "textarea") {
        improvedFieldName = fieldName.trim().replace(" ", "\u00A0");
      } else improvedFieldName = fieldName;
    }

    if (fieldProperty == null || fieldProperty.equals("") || !fieldProperty.equals("title")) {
      if (tagName == null || tagName.equals("")) tagName = "span";
      if (!waitForDisplayedList((By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")), 5)) {
        System.out.println("I am reviewing here in the list ");
        System.out.println("The tag name  " + tagName + " wasn't found in the method getXpath and field name " + improvedFieldName);
      }
//      System.out.println("The size of collection first stop " + wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")).size());
//      trueSize = wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")).size();
      elements = wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']"));

    } else {
      if (!waitForDisplayedList((By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]")), 5)) {
        System.out.println("I am reviewing here in the list ");
        System.out.println("The tag name  " + tagName + " wasn't found in the method getXpath and field name " + improvedFieldName);
      }
//      trueSize = wd.findElements(By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]")).size();
      elements = wd.findElements(By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]"));
    }

    if (fieldProperty != null && !fieldProperty.equals("") && !fieldProperty.equals("title")) {

      switch (fieldProperty) {
        case "span":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input";
          break;
        case "input":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
/*
        if (!fieldName.equals("Address")) {
          xpath = "//" + fieldProperty + "[@id='" + elements.get(elements.size() - 1).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
        } else {
          xpath = "//" + fieldProperty + "[@id='" + elements.get(elements.size() - 2).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
        }
 */
          break;
        case "textarea":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;
        case "button":
          xpath = "//" + "button" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;

        default:
      }
    } else {
      switch (tagName) {
        case "button":
          xpath = "//" + "button" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "div":
          xpath = "//" + "div" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "a":
          xpath = "//" + "a" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "span":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
//          System.out.println("The size of collection second stop " + wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")).size());
          break;
        default:
      }
    }
    return xpath;
  }

  protected void typeClick(String fieldName, String stringToType,  String tagName, String className, Integer timeout, Integer index) {

    int count =0;
    String id =null;

    while (id==null & count <5) {
      id = getWebId(fieldName, stringToType, tagName, className, null);
      if (id==null) System.out.println("This is from method typeClick due id is null "+id+" and count is "+count);
      count++;

    }

    if (index == null) index = 0;
    if (!waitForDisplayed((By.id(id)), timeout)) {
      System.out.println("I am reviewing here");
      System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.xpath(id)).getAttribute("class"));
    }

//    String classNameN = wd.findElement(By.id(id)).getAttribute("class");
    WebElement elem = wd.findElement(By.id(id));
    if (stringToType!=null && !stringToType.equals("")) {
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
        elem.click();
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
          System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.id(id)).getAttribute("class"));
        }
      default:

        if (!waitForDisplayed((By.id(id)), timeout)) {
          System.out.println("The field with name " + fieldName + " wasn't found,the value's field is " + stringToType + " and object id is " + wd.findElement(By.id(id)).getAttribute("class"));
        }
        wd.findElement(By.id(id)).clear();
        wd.findElement(By.id(id)).sendKeys(stringToType);
    }
*/

  }

  protected String getWebId(String fieldName, String stringToType,String tagName,String className, Integer index) {
    String xPath = null;
    List<WebElement> elements;
    String improvedFieldName = fieldName;
    String[] fieldNameArray = fieldName.split(" ");
    String id=null;

    if (index == null) index = 1;

    if (fieldNameArray.length > 1) {
      if (tagName == "span" || tagName == "input" || tagName == "textarea") {
        improvedFieldName = fieldName.trim().replace(" ", "\u00A0");
      } else improvedFieldName = fieldName;
    }

    elements = wd.findElements(By.xpath("//*[@class = '" + className + "'][normalize-space(text())='" + improvedFieldName + "']"));
  if (elements.size()>0) {
    for (WebElement element : elements) {
      if (element.getText().equals(fieldName)) {
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
    System.out.println("This is from method getWebId, no web elements found for field "+fieldName+"thus returning id null");
  }
    return id;
  }

  public String getXpath(WebElement ele) {
//    String str = ele.toString();
    String str = ele.toString().replaceAll(".+->","");
    String[] listString = null;

    if (str.contains("class")) {
      listString = str.split("class");
      String last = listString[1].trim();
      return last.substring(0, last.length() - 1);
    } else {
      return null;
    }
  }


  protected String getXpath1 (String fieldName, String tagName, String fieldProperty, Integer index) {

    String xpath = null;
    List<WebElement> elements;
    String improvedFieldName = fieldName;
    String[] fieldNameArray = fieldName.split(" ");
//    int trueSize = 0;


    if (index == null) index = 1;

    if (fieldNameArray.length > 1) {
      if (fieldProperty == "span" || fieldProperty == "input" || fieldProperty == "textarea") {
        improvedFieldName = fieldName.trim().replace(" ", "\u00A0");
      } else improvedFieldName = fieldName;
    }


    if (fieldProperty == null || fieldProperty.equals("") || !fieldProperty.equals("title")) {
      if (tagName == null || tagName.equals("")) tagName = "span";
      if (!waitForDisplayedList((By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")), 5)) {
        System.out.println("I am reviewing here in the list ");
        System.out.println("The tag name  " + tagName + " wasn't found in the method getXpath and field name " + improvedFieldName);
      }
      elements = wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']"));
      switch (tagName) {
        case "span":
          xpath = "//" + "span" +  "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input";
          break;
        case "input":
          xpath = "//" + "span" +  "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
          break;
        case "textarea":
          xpath = "//" + "span" +  "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;
        case "button":
          xpath = "//" + "button" +"[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;
        default:
      }

    } else {
      if (!waitForDisplayedList((By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]")), 5)) {
        System.out.println("I am reviewing here in the list ");
        System.out.println("The tag name  " + tagName + " wasn't found in the method getXpath and field name " + improvedFieldName);
      }
//      trueSize = wd.findElements(By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]")).size();
      elements = wd.findElements(By.xpath("//" + tagName + "[@title=normalize-space('" + improvedFieldName + "')]"));
      switch (tagName) {
        case "button":
          xpath = "//" + "button" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "div":
          xpath = "//" + "div" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "a":
          xpath = "//" + "a" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "span":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
//          System.out.println("The size of collection second stop " + wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")).size());
          break;
        default:
      }
    }
/*
    if (fieldProperty != null && !fieldProperty.equals("") && !fieldProperty.equals("title")) {

      switch (fieldProperty) {
        case "span":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//span//input";
          break;
        case "input":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
/*
        if (!fieldName.equals("Address")) {
          xpath = "//" + fieldProperty + "[@id='" + elements.get(elements.size() - 1).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
        } else {
          xpath = "//" + fieldProperty + "[@id='" + elements.get(elements.size() - 2).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//input";
        }

          break;
        case "textarea":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;
        case "button":
          xpath = "//" + "button" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']//parent::div[@class='z-vlayout-inner']//following-sibling::div//textarea";
          break;

        default:
      }
    } else {
      switch (tagName) {
        case "button":
          xpath = "//" + "button" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "div":
          xpath = "//" + "div" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "a":
          xpath = "//" + "a" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
          break;
        case "span":
          xpath = "//" + "span" + "[@id='" + elements.get(elements.size() - index).getAttribute("id") + "']";
//          System.out.println("The size of collection second stop " + wd.findElements(By.xpath("//" + tagName + "[normalize-space(text())='" + improvedFieldName + "']")).size());
          break;
        default:
      }
    }
*/
    return xpath;
  }


  protected void fillGeneralPersonForm(GeneralPersonForm generalPersonForm) {
    typeClick("Title",generalPersonForm.getTitle(),"span","fieldTitle z-label",null,null);
    typeClick("First Name",extractID(),"span","fieldTitle z-label",null,null);
    typeClick("MI",generalPersonForm.getMi(),"span","fieldTitle z-label",null,null);
    typeClick("Last Name","LastNameTest","span","fieldTitle z-label",null,null);
    typeClick("Suffix",generalPersonForm.getSuffix(),"span","fieldTitle z-label",null,null);
    typeClick("Tax ID Type",generalPersonForm.getTaxIdType(),"span","fieldTitle z-label",null,null);
    typeClick("Tax ID",generalPersonForm.getTax_id(),"span","fieldTitle z-label",null,null);
    typeClick("Tax Status",generalPersonForm.getTaxStatus(),"span","fieldTitle z-label",null,null);
    typeClick("Number of Exemptions",generalPersonForm.getNumberOfExamptions(),"span","fieldTitle z-label",null,null);
    typeClick("Payee Name",generalPersonForm.getPayeeName(),"span","fieldTitle z-label",null,null);
    typeClick("Date of Birth",generalPersonForm.getDob(),"span","fieldTitle z-label",null,null);
    typeClick("Date of Death",generalPersonForm.getDod(),"span","fieldTitle z-label",null,null);
    typeClick("Gender",generalPersonForm.getGender(),"span","fieldTitle z-label",null,null);
    typeClick("Marital Status",generalPersonForm.getMartialStatus(),"span","fieldTitle z-label",null,null);

  }

  protected void logOut() {
    click("Logout", "a", null, null, null);
  }

  protected String getLastObjectId(String xpath) {
//    List<WebElement> elements =wd.findElements(By.xpath("//span[normalize-space(text())='Address']"));
    List<WebElement> elements = wd.findElements(By.xpath(xpath));
    String webElementId = elements.get(elements.size() - 1).getAttribute("id");
    return webElementId;
  }

  protected void submitPersonCreation() {
//    typeClick("Save",);
    click("Save", "a", "title", null, null);
  }

  protected void initPersonCreation() {
//    click("Create Person", "button", "", null, null);
    typeClick("Create Person",null,"button","navigationButton",null,null);
  }

  protected String extractID() {
    finalId = wd.findElement(By.xpath("//div[3]/table/tbody/tr")).getAttribute("id").substring(0, 4);
    System.out.println("Id attribute is " + finalId);
    return finalId;
  }

  protected void waitWebElement(WebDriver wd, String expression, String waitIdParameter) {
    WebDriverWait wait = new WebDriverWait(wd, 30);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finalIdN+"60-cave")));
    if (waitIdParameter == "xpath") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
    } else if (waitIdParameter == "id") {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
    }
  }

  //  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public Boolean waitForDisplayed(By locator, Integer... timeout) {
    try {
      waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeout.length > 0 ? timeout[0] : null);
      waitFor(ExpectedConditions.elementToBeClickable(locator), timeout.length > 0 ? timeout[0] : null);
      waitFor(ExpectedConditions.presenceOfElementLocated(locator), timeout.length > 0 ? timeout[0] : null);
    } catch (org.openqa.selenium.TimeoutException exception) {
      System.out.println("I am reviewing fail of error from TimeoutException " + exception.getMessage());
      return false;
    }
    catch (org.openqa.selenium.ElementNotInteractableException exception) {
      System.out.println("I am reviewing fail of error from ElementNotInteractableException " + exception.getMessage());
      return false;
    } catch (org.openqa.selenium.InvalidElementStateException exception) {
      System.out.println("I am reviewing fail of error from InvalidElementStateException" + exception.getMessage());
      return false;
    }

    return true;
  }

  public Boolean waitForDisplayedList(By locator, Integer... timeout) {
    try {
      waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(locator), timeout.length > 0 ? timeout[0] : null);
    } catch (org.openqa.selenium.TimeoutException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    } catch (org.openqa.selenium.ElementNotInteractableException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    } catch (org.openqa.selenium.InvalidElementStateException exception) {
      System.out.println("I am reviewing fail of error from " + exception.getMessage());
      return false;
    }
    return true;
  }

  private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
    timeout = timeout != null ? timeout : 5;
    WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(condition);
  }

  private void waitForList(ExpectedCondition<List<WebElement>> condition, Integer timeout) {
    timeout = timeout != null ? timeout : 5;
    WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(condition);
  }
}
