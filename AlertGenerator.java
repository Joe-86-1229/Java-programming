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
 * CLASS PURPOSE:    Randomly generate alert status
 *
 * CLASS INVARIANT:  StarshipController has to be initialized first to run rest of functions
 *
 * RUN INSTRUCTIONS: 
 */

import java.util.Random;
public class AlertGenerator {
        
    private Random randNumGen = new Random();
    
    public AlertStatus nextStatus(){
    	AlertStatus newStatus = new AlertStatusGreen();
    	// x will get a random int value from 0 to 9
    	int x = randNumGen.nextInt(10);
    	// x has 70% to get a int value from 0 to 6
    	if( x <= 6){
    		newStatus = new AlertStatusGreen();
    	}
    	// x has 20% to get a int value from 7 to 8
    	if(6 < x && x <= 8){
    		newStatus = new AlertStatusYellow();
    	}
    	// x has 10% to get a int value 9
    	if(8 < x && x <= 9){
    		newStatus = new AlertStatusRed();

    	}
    	return newStatus;
    }
    
    
}
