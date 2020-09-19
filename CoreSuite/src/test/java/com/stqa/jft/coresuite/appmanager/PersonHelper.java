package com.stqa.jft.coresuite.appmanager;

import com.stqa.jft.coresuite.model.GeneralPersonForm;
import org.openqa.selenium.*;

public class PersonHelper extends HelperBase {

  public PersonHelper(WebDriver wd) {
    super(wd);
  }

  public void fillGeneralPersonForm(GeneralPersonForm generalPersonForm) {
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
  public void initPersonCreation() {
//    click("Create Person", "button", "", null, null);
    typeClick("Create Person",null,"button","navigationButton",null,null);
  }
}
