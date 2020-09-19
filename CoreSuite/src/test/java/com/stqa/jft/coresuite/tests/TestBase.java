package com.stqa.jft.coresuite.tests;

import com.stqa.jft.coresuite.appmanager.ApplicationManager;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
//    wd = new FirefoxDriver();
    app.init();
  }


  //  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public ApplicationManager getApplicationManager() {
    return app;
  }
}
