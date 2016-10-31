/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:
 *
 * CREATION DATE:2015-2-26
 *
 * PROBLEM STATEMENT:  (concisely, rephrase the problem)
 *
 * PROGRAM DESCRIPTION:  This program will allow user to virtually initiate a starship.And the status, which are green,yellow and red,
 *						 of system of starship will change randomly.User can force system alter the status to red. 
 * 
 * CLASS PURPOSE:    Menu class is a simulation plantform for user to do things with the starship
 *
 * CLASS INVARIANT:  StarshipController has to be initialized first to run rest of functions
 *
 * RUN INSTRUCTIONS: 
 */
import java.util.Scanner;
public class Menu {
        private boolean go = true;
  		private StarShipController sc;
private void exe(){
    	while(go){
      		displayChoices();
      		switch(getChoice()) {
        		case 'I' : System.out.println("how many iterations whould you like to run? ");
        				   int x = getAnInt();
        				   sc = new StarShipController(x); break;
        				   // avoid running the simulation before user does not initiate starship first 
        		case 'R' : if(sc == null){
        						System.out.println("Havt to init Starship first");
        						break;
        						}
        				   sc.run(); break;
        		case 'F' : if(sc == null){
        						System.out.println("Havt to init Starship first");
        						break;
        						}
        				   sc.forceRed(); break; 
        		case 'Q' : go = false; break;
        		default:   System.out.println("Not a right choice!");
      		}
    	}
    }
    
private void displayChoices(){
    	System.out.println("");
    	System.out.println("My Menu Choices");
    	System.out.println("(I)nit Starship;(R)un the Sim;(F)orce Red; (Q)uit");
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
private int getAnInt() {
    String input = "Empty";
    int i = 0;  
    Scanner in = new Scanner(System.in);
    try {
      i = in.nextInt();
    } catch (Exception e) {
      System.out.println("ERROR:  not an integer");
      // recursively call getAnInt() until success
      i = getAnInt();
    }
    return i;
  }
  
  public static void main(String[] args) {
        Menu m = new Menu();
        m.exe();
    }
    
   
}
