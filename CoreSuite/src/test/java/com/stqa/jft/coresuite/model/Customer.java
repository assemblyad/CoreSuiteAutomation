package com.stqa.jft.coresuite.model;

import com.stqa.jft.coresuite.appmanager.HelperBase;

public class Customer extends HelperBase {
  private final String country;
  private final String taxIdType;
  private final String tax_id;
  private final String payeeName;

  public Customer (String country, String taxIdType, String tax_id, String payeeName) {
    super();
    this.country = country;
    this.taxIdType = taxIdType;
    this.tax_id = tax_id;
    this.payeeName = payeeName;
  }
  public String getCountry() {
    return country;
  }

  public String getTaxIdType() {
    return taxIdType;
  }

  public String getTax_id() { return tax_id;   }

  public String getPayeeName() {
    return payeeName;
  }

}
