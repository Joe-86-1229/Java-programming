
/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:
 *
 * CREATION DATE: 21/2/2015
 *
 * PROBLEM STATEMENT:  (concisely, rephrase the problem)
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    FrogController: create an array to store Frog objects
 *									 and add Frog objects into it.
 *									 run different method in Frog class
 *					 Amphibian: superclass of Frog class. create an Amphibian. let it breath in the water and in the air.
 *					 Frog: child of Amphibian class. create a Frog. let it breath in the water and in the air.
 *					 FrogMenu: allow users to control the create and the method of Frog.
 *
 * CLASS INVARIANT:  (what will always be true about this class)
 *
 * RUN INSTRUCTIONS: (include instructions for running your program and
 *                    appropriate data to enter during the run. more
 *                    detail is better than not enough. Include the
 *                    name of the required data file ... this section
 *                    is only required for the file that starts your
 *                    program and will probably be the menu)
 */

import java.util.*;
class FrogController{ 
	
	private static ArrayList<Amphibian> amphibians = new ArrayList <Amphibian>();
	
	
	public FrogController(){
		System.out.println("FrogController");
		// when created a FrogController, created a 'null' Frog
		amphibians.add(null);
			
	}
	
	public void makeFrogs(){
	 	amphibians.add(new Frog());
	}
	
	public void frogsBreathWater(){
		for(Amphibian amph:amphibians){
		// if there is any null element, output Non-exsitent Frog
			if(amph == null){
				System.out.println("Non-exsitent Frog");
			}
			else
			amph.breatheWater();
		}
	}
	
	public void frogsBreathAir(){
		for(Amphibian amph:amphibians){
			// if  first element is null in array, ask to initialize first 	
			if(amph == null){
				System.out.println("Non-exsitent Frog");
				
			}
			else
			amph.breatheAir();
		}
	}
}
	
	

// super class of Frog
class Amphibian {
    private static int counter = 0;
    private int id = 0;    
   
    public Amphibian() {
    	counter++;
    	id = counter;
    	System.out.println("This Amphibian ID is "+id);
    }
    
    public int getID(){
    	return id;
    } 
    
    public void breatheWater(){
    	System.out.println("Amphibian breathing water");
    }
    
    public void breatheAir(){
    	System.out.println("Amphibian breathing air");
    }
}

// child of Amphibian
class Frog extends Amphibian{
	
	public Frog(){
		System.out.println("This Frog ID is "+getID());
	}
	
	public void breatheWater(){
		
		System.out.println("I'm a TadPole "+getID());
	}
	
	public void breatheAir(){
		
		System.out.println("I'm a Frog "+getID());
	}
}

 
// a menu to interact with users
public class FrogMenu {
        
    private boolean run = true;
    private FrogController model;
    
    private void run(){
    	while(run) {
      		displayChoices();
      		switch(getChoice()) {
        		case 'C' : model = new FrogController();
        				   model.makeFrogs(); break;
        		case 'W' : model.frogsBreathWater(); break;
        		case 'A' : model.frogsBreathAir(); break;
        		case 'Q' : run = false; break;
        		default:   System.out.println("Not a right choice!");
      		}
    	}
    }
// show options what users can choice
    private void displayChoices(){
    	System.out.println("");
    	System.out.println("My Menu Choices");
    	System.out.println("(C)reate an Array of Frog; Frogs Breath (W)ater; Frogs Breath (A)ir; (Q)uit");
    	System.out.print("> ");
    }
    
    private char getChoice(){
    	String input = "Empty";
    	Scanner in = new Scanner(System.in);
    	try {
      	// grab everthing up to the 'enter' and convert to uppercase
      	input = in.next().toUpperCase();
    	} catch (Exception e) {
     	 System.out.println("ERROR:  key read problem");
    	}
    	// no matter how many characters are typed return the first
    	return input.charAt(0);
    }
    
    
    
    public static void main(String[] args) {
        FrogMenu fm = new FrogMenu();
        fm.run();
    }
}
