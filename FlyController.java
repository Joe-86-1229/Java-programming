/**
 * @(#)FlyController.java
 *
 *
 * @author 
 * @version 1.00 2015/3/15
 */
import java.util.Scanner;
public class FlyController {
        
        private boolean go = true;
  		private OnTheFly otf =  new OnTheFly();
private void exe(){
    	while(go){
      		displayChoices();
      		switch(getChoice()) {
        		case 'A' : try{
   							otf.addItem();
        					}catch(ClassNotFoundException e){
        					// if a ClassNotFoundException be caught , break
        				   	  System.out.println("No class found");
        				   }break;
        					
        		case 'D' : otf.disp();break;
        		case 'I' : otf.sortById();break;
        		case 'E' : otf.sortByDes();break;
        		case 'S' : otf.save();break;
        		case 'O' : otf.open();break;
        		case 'L' : otf.serializeIt();break;
        		case 'U' : otf.unSerializeIt();break;
        		case 'Q' : go = false; break;
        		default:   System.out.println("Not a right choice!");
      		}
    	}
    }
    
private void displayChoices(){
    	System.out.println("");
    	System.out.println("My Menu Choices");
    	System.out.println("(A)dd;(D)isplay;(I)SortById;(E)SortByDes;(S)ava;(O)pen;(L)serializeit;(U)nSerializeIt;(Q)uit");
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
        FlyController m = new FlyController();
        m.exe();
    }
 }

