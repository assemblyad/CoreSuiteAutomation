package com.stqa.jft.coresuite.appmanager;

import com.stqa.jft.coresuite.model.Customer;
import com.stqa.jft.coresuite.model.CustomerBusiness;
import com.stqa.jft.coresuite.model.GeneralPersonForm;
import org.openqa.selenium.WebDriver;

public class BusinessHelper extends HelperBase {

  public BusinessHelper(WebDriver wd) {
    super(wd);
  }

  public void fillGeneralForm(Customer customer) {

    CustomerBusiness cb=null;
    GeneralPersonForm person=null;

    String className = customer.getClass().getName();
    if (className=="com.stqa.jft.coresuite.model.CustomerBusiness") {
      cb = (CustomerBusiness) customer;

    } else {
      person = (GeneralPersonForm) customer;
    }

    typeClick("Tax ID Type", customer.getTaxIdType(), "span", "fieldTitle z-label", null, null);
    typeClick("Tax ID", customer.getTax_id(), "span", "fieldTitle z-label", null, null);
    typeClick("Payee Name", customer.getPayeeName(), "span", "fieldTitle z-label", null, null);

    if (customer.getClass().getName() == "com.stqa.jft.coresuite.model.CustomerBusiness") {

      typeClick("Business Name", cb.getBusinessName(), "span", "fieldTitle z-label", null, null);
      typeClick("Effective Date", cb.getEffectiveDate(), "span", "fieldTitle z-label", null, null);
      typeClick("Year Established", cb.getYearEstablished(), "span", "fieldTitle z-label", null, null);
      typeClick("Ceased Business Operation", cb.getCeasedBusinessOperation(), "span", "fieldTitle z-label", null, null);
      typeClick("Effective Date", cb.getEffectiveDateTax(), "span", "fieldTitle z-label", null, null);

    } else {
      typeClick("Title", person.getTitle(), "span", "fieldTitle z-label", null, null);
      typeClick("First Name", extractID(), "span", "fieldTitle z-label", null, null);
      typeClick("MI", person.getMi(), "span", "fieldTitle z-label", null, null);
      typeClick("Last Name", "LastNameTest", "span", "fieldTitle z-label", null, null);
      typeClick("Suffix", person.getSuffix(), "span", "fieldTitle z-label", null, null);
      typeClick("Tax Status", person.getTaxStatus(), "span", "fieldTitle z-label", null, null);
      typeClick("Number of Exemptions", person.getNumberOfExamptions(), "span", "fieldTitle z-label", null, null);
      typeClick("Date of Birth", person.getDob(), "span", "fieldTitle z-label", null, null);
      typeClick("Date of Death", person.getDod(), "span", "fieldTitle z-label", null, null);
      typeClick("Gender", person.getGender(), "span", "fieldTitle z-label", null, null);
      typeClick("Marital Status", person.getMartialStatus(), "span", "fieldTitle z-label", null, null);
    }
  }
  public void initBusinessCreation() {
    typeClick("Create Business",null,"button","navigationButton",null,null);
  }

}
