/* AUTHOR:Jianqiao Zhou  
 * 
 * CREATION DATE: April 10, 2015 
 *
 * PROBLEM STATEMENT:  1.	Sort by height does not mean something to users
					   2.	There is not too many useful information stored in Playlist.
					   3.	If program need to be more integrated, Guard and Forward may have their own children class, such as point guard, shoots guard, small forward and power forward.
					   4.   Open() function will read files into memory without flash the container first when evey time run it  
 * 
 * PROGRAM DESCRIPTION: This program allows all users to create an array list stores the information of a player and manipulate the information in there.
						Menu class: as a viewer, provide windows and windows for users to manipulate the array list and the information inside.
						Controller class: as a presenter, provide the real function which can manipulates the array list, such edit, sort, delete save etc.
						and control the logic.
						Player class with three children: as a model, it provides actual model or data for user to manipulate, but user does not manipulate 
						player directly, instead, user controls controller to finish job
						1.	Select option from keyboard, users can add, edit, sort, delete, save and open data. Before manipulating array, 
						assure there is data there already
						2.	Whatever option users have chosen, a controller will be created. In Controller class, 
						every manipulating method is defined here.Because the container stores the Player type data, controller can 
						interact with Player and its children.
						3.	Every object stored in container contains integrated information of a Player or certain children.   

 *	
 * CLASS INVARIANT:  None
 *
 * RUN INSTRUCTIONS: 1.Open the file , then you will get 10 records previously stored in a txt file
 *					 2.Display it you can see all the records
 *					 3.if you want to add new player into file, you must type the right class name first like Center, Guard, Forward 
 *					   in addition to other variables
 *					 4.Make sure you have open the file first, otherwise any manipulations won't make any changes with container
 *					 
 */ 









import java.util.*;
import java.lang.reflect.*;
import java.util.Scanner;





//Purpose: provides a windows to users manipulate the Player list
//
//Data: a Boolean ‘go ’variable determines run or quit the program; a Controller object ‘ct’ to access Controller methods
//
//Behavior: as descried for each method below users can manipulate playerList based on the provided choices and prompt.
//
//Invariant: None

public class Menu {
        
    private boolean go = true;
  	private Controller cont =  new Controller();
private void run(){
    	while(go){
      		displayChoices();
      		switch(getChoice()) {
        		case 'A' : try{
   							cont.addPlayer();
        					}catch(ClassNotFoundException e){
        					// if a ClassNotFoundException be caught , break
        				   	  System.out.println("No class found");
        				   }break;
        		
        		case 'D' : cont.disp();break;
        		case 'E' : cont.editByName();break;
        		case 'H' : cont.sortByHeight();break;
        		case 'N' : cont.sortByName();break;
        		case 'S' : cont.save();break;
        		case 'T' : cont.deleteByName();break;
        		case 'O' : cont.open();break;
        		case 'P' : cont.playIt();break;
        		case 'L' : cont.serializeIt();break;
        		case 'U' : cont.unSerializeIt();break;
        		case 'Q' : go = false; break;
        		default:   System.out.println("Not a right choice!");
      		}
    	}
    }
    
    
//
//	Tasks: let users keep manipulating player list until users want to quit
//	
//	Precondition: ‘go’ is true 
//	
//	Modifies: add new object into playerList	
//	
//	Postcondition: new player might be added into playerList; ‘go’ will be false after quiting.
    
    
private void displayChoices(){
    	System.out.println("");
    	System.out.println("My Menu Choices");
    	System.out.println("(A)dd;(D)isplay;(E)ditByName;(H)sortByHeight;(N)sortByName;");
    	System.out.println("(S)ava;(T)DeleteByName(O)pen;(L)serializeit;(U)nSerializeIt;(Q)uit");
    	System.out.print("> ");
    }

//	Tasks: provide manipulation choices for users
//	
//	Precondition: ‘go’ is true
//	
//	Modifies: None
//	
//	Postcondition: None

    
    
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

	
////	Tasks: read users’ input from keyboard
////	
////	Precondition: ‘go’ is true
////	
////	Modifies: None
////	
////	Postcondition: a upperclass letter will be returned



  public static void main(String[] args) {
        Menu m = new Menu();
        m.run();
    }
 }


 