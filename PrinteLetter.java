/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:17-Jan-2015 
 *
 * PROBLEM STATEMENT: print all letters in alphabetical order
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    (a brief desc of the class's purpose)
 *
 * CLASS INVARIANT: 
 *
 * RUN INSTRUCTIONS: The outpt are lowercase letter a to z
 *									
 */ 

public class PrinteLetter {
        
   
  /**
   * TASK:           print out letter in alphabetical order
   *
   * PRECONDITION:   None
   *
   * MODIFIES:       None
   *
   * POSTCONDITION:  None
   */
    public void run(){
    	for(char ch = 'a' ; ch <= 'z' ; ch++ )
         System.out.println(ch);
     	}
    	
 
    public static void main(String[] args) {
        PrinteLetter pL=new PrinteLetter();
        pL.run();
    }
}
