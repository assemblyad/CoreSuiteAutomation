//package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexander");
    double l = 5;
    Square s = new Square(5);
    System.out.println("The square area area with side " + s.l + "=" + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("The rectangle  area with side " + r.a + " and " + r.b + "=" + r.area());

  }

  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");

  }

}