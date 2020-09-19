package com.stqa.jft.coresuite.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerBusiness extends Customer {

  private final String businessName;
  private final String effectiveDate;
  private final String yearEstablished;
  private final String ceasedBusinessOperation;

  public String getEffectiveDateTax() {
    if (effectiveDate!=null) {
      return effectiveDateTax;
    } else {
      return currentDate();
    }
  }

  private final String effectiveDateTax;

  public CustomerBusiness(String country, String taxIdType, String tax_id, String payeeName, String businessName, String effectiveDate, String yearEstablished, String ceasedBusinessOperation, String effectiveDateTax) {
    super(country, taxIdType, tax_id, payeeName);
    this.businessName = businessName;
    this.effectiveDate = effectiveDate;
    this.yearEstablished = yearEstablished;
    this.ceasedBusinessOperation = ceasedBusinessOperation;
    this.effectiveDateTax=effectiveDateTax;
  }

  public String getBusinessName() {
    return businessName;
  }

  public String getEffectiveDate() {
    if (effectiveDate!=null) {
      return effectiveDate;
    } else {
     return currentDate();
    }

  }

  public String getYearEstablished() { return yearEstablished;   }
  public String getCeasedBusinessOperation() {
    return ceasedBusinessOperation;
  }

}
