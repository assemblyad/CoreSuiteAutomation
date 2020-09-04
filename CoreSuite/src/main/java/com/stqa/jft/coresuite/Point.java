package com.stqa.jft.coresuite;//package ru.stqa.pft.sandbox;

public class Point {
  int x;
  int y;
  public Point (int x, int y) {
    this.x=x;
    this.y=y;
  }
  public double distance(Point p) {
    int x= this.x-p.x;
    int y= this.y-p.y;
    //return Math.sqrt((((p1.x -p2.x)*2) + ((p1.y-p2.y)*2)));
    return Math.sqrt(x*x+y*y);
  }

}
