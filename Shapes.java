//: c07:Shapes.java
// Polymorphism in Java.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.*;

abstract class Shape {
  abstract void draw() ;
  abstract void erase() ;
 
}

class Circle extends Shape {
  void draw() {
    System.out.println("Circle.draw()");
  }
  void erase() {
    System.out.println("Circle.erase()");
  }
}

class Square extends Shape {
  void draw() {
    System.out.println("Square.draw()");
  }
  void erase() {
    System.out.println("Square.erase()");
  }
}

class Triangle extends Shape {
  void draw() {
    System.out.println("Triangle.draw()");
  }
  void erase() {
    System.out.println("Triangle.erase()");
  }
}

// A "factory" that randomly creates shapes:
class RandomShapeGenerator {

  private Random rand = new Random();

  // note the upcast that occurrs for each
  // call to next()
  public Shape next() {
    switch(rand.nextInt(3)) {
      default: // must have a default case
      case 0: return new Circle();
      case 1: return new Square();
      case 2: return new Triangle();
    }
  }
}

public class Shapes {
  private static RandomShapeGenerator gen =
    new RandomShapeGenerator();

  public static void main(String[] args) {
    Shape[] s = new Shape[9];

    // Fill up the array with shapes:
    for(int i = 0; i < s.length; i++)
      s[i] = gen.next();

    // Make polymorphic method calls:
    for(int i = 0; i < s.length; i++)
    // There are nine output messages, because before every child class intiated, the supercalss will be initiated first.	
      s[i].draw();
   
  }

} 