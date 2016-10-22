/**
 * @(#)Player.java
 *
 *
 * @author 
 * @version 1.00 2015/4/11
 */

import java.util.*;
import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;



//Purpose: create an abstract class represents the general attributes of a player without category. 
//
//Data: two integers ‘height’ and ‘weight’; one string ‘name’. 
//
//Behaviour: defined constructor will collect data and fill into variabls
//
//Invariant: ‘height’ and ‘weight ’ must bigger than a positive value.

        
  abstract class Player implements Comparable<Player>,Serializable {
  public int height;
  public int weight;
  public String name;
  public Player(Integer h,Integer w,String na) {
    height = h.intValue();
    weight = w.intValue();
    name = na;
  }
  
  public void play(){
  }
  
  public int getHeight(){
  	return height;
  }
  

//Tasks:  get the ‘height’ value for every player
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: ‘height’ value will be returned

  
  
  public int getWeight(){
  	return weight;
  }
//Tasks:  get the ‘weight’ value for every player
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: ‘weight’ value will be returned
  
  
  
  public String getName(){
  	return name;
  }
//Tasks:  get the ‘name’ string for every player
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: ‘name’ value will be returned
  
  
  // sort method on id with ascending order
  public int compareTo(Player tb) {
    int height2 = tb.height;
    return (height < height2 ? -1 : (height== height2 ? 0 : 1));
  }
  
  /*Tasks: allow users to sort the players  by height stored in playerList
	
	Precondition: at least two elements in playerList
	
	Modifies: None 
	
	Postcondition: plyaerList sorted by height*/

  
  
  // sort method on name with ascending order
  private static class PlayerComparator<E extends Player>
  	  implements Comparator<E> {
    public int compare (E e1, E e2) {
      String s1 = e1.getName();
      String s2 = e2.getName();
      return s1.compareTo(s2);
    }
  }
  
  /*Tasks: allow users to sort the players  by name stored in playerList
	
	Precondition: at least two elements in playerList
	
	Modifies: None 
	
	Postcondition: plyaerList sorted by name*/
  

  // Return an instance of the inner class
  public static Comparator PlayerComparator() {
    return new PlayerComparator<Player>();
  }
  
}

class Guard extends Player {
  public Guard(Integer h, Integer w, String name) {
    super(h,w,name);
  }
  

//Purpose: create a player with Guard role. 
//
//Data: Same with parent class 
//
//Behaviour: besides same general with parent class, it has one more specific statement which is control the ball in play() method. Define constructor will collect data and fill into variables 
//
//Invariant: ‘height’ and ‘weight ’ must bigger than a positive value.
  
  
  public void play(){
  	System.out.println("I am a guard,i control the ball");
  }
  
//Taks:  overloading play() method in Player class, output a statement ‘I control the ball’
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: none
  
  
  
  public String toString() {
    return "Guard "+"height: "+ getHeight()+" cm; weight: "+getWeight()+" kg; name: "+getName();
  }
}

//Purpose: create a player with Guard role. 
//
//Data: Same with parent class 
//
//Behaviour: besides same general with parent class, it has one more specific statement which is control the ball in play() method. Define constructor will collect data and fill into variables 
//
//Invariant: ‘height’ and ‘weight ’ must bigger than a positive value.


class Forward extends Player {
  public Forward(Integer h, Integer w, String name) {
    super(h,w,name);
  }
  
//Purpose: create a player with Forward role. 
//
//Data: Same with parent class 
//
//Behaviour: besides same general with parent class, it has one more specific statement which is catch the rebound in play() method. Define constructor will collect data and fill into variables 
//
//Invariant: ‘height’ and ‘weight ’ must bigger than a positive value.
  
  
  public void play(){
  	System.out.println("I am a Forward,i catch the rebound");
  }
  
  public String toString() {
    return "Forward "+"height: "+ getHeight()+" cm; weight: "+getWeight()+" kg; name: "+getName();
  }
}
//Taks:  overloading play() method in Player class, output a statement ‘I catch the rebound’
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: none



class Center extends Player {
  public Center(Integer h, Integer w, String name) {
    super(h,w,name);
  }
  
//Purpose: create a player with Center role. 
//
//Data: Same with parent class 
//
//Behaviour: besides same general with parent class, it has one more specific statement which is protect the rim in play () method. 
//Define constructor will collect data and fill into variables 
  
  
  public void play(){
  	System.out.println("I am a center, i protect the rim");
  }
  
  public String toString() {
    return "Center "+"height: "+ getHeight()+" cm; weight: "+getWeight()+" kg; name: "+getName();
  }
}

//Taks:  overloading play() method in Player class, output a statement ‘I protect the rim’
//
//Precondition: none
//
//Modifies: none
//
//Postcondition: none

