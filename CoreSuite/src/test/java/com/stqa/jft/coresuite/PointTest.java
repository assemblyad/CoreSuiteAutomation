package com.stqa.jft.coresuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void distanceTest() {
    Point p1 = new Point(2,5);
    Point p2 = new Point(5,5);
    Assert.assertEquals(p1.distance(p2),3.0);
  }

}
