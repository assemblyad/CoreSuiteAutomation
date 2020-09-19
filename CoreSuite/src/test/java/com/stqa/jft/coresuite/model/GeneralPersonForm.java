package com.stqa.jft.coresuite.model;

public class GeneralPersonForm extends Customer {
//  private final String country;
  private final String title;
  private final String suffix;
  private final String mi;
//  private final String taxIdType;
//  private final String tax_id;
  private final String taxStatus;
  private final String numberOfExamptions;
//  private final String payeeName;
  private final String dob;
  private final String dod;
  private final String gender;
  private final String martialStatus;

  public GeneralPersonForm(String country, String title, String suffix, String mi, String taxIdType, String tax_id, String taxStatus, String numberOfExamptions, String payeeName, String dob, String dod, String gender, String martialStatus) {
    super(country, taxIdType, tax_id, payeeName);
//    this.country = country;
    this.title = title;
    this.suffix = suffix;
    this.mi = mi;
//    this.taxIdType = taxIdType;
//    this.tax_id = tax_id;
    this.taxStatus = taxStatus;
    this.numberOfExamptions = numberOfExamptions;
//    this.payeeName = payeeName;
    this.dob = dob;
    this.dod = dod;
    this.gender = gender;
    this.martialStatus = martialStatus;
  }


  public String getCountry() {
    return super.getCountry();
  }


  public String getTitle() {
    return title;
  }

  public String getSuffix() {
    return suffix;
  }

  public String getMi() {
    return mi;
  }

  public String getTaxIdType() {
    return super.getTaxIdType();
  }

  public String getTax_id() {
    return super.getTax_id();
  }

  public String getTaxStatus() {
    return taxStatus;
  }

  public String getNumberOfExamptions() {
    return numberOfExamptions;
  }

  public String getPayeeName() {
    return super.getPayeeName();
  }

  public String getDob() {
    return dob;
  }

  public String getDod() {
    return dod;
  }

  public String getGender() {
    return gender;
  }

  public String getMartialStatus() {
    return martialStatus;
  }
}
