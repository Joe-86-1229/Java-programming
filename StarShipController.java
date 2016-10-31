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
 * CLASS PURPOSE:    StarShipController class is used to communicate with AlertGenerator . StarshipController can 
 *					 get the current alert status depending on the AlertGenerator. 	
 * 
 * CLASS INVARIANT:  StarshipController has to be initialized first to run rest of functions
 *
 * RUN INSTRUCTIONS: 
 */
public class StarShipController {
    private int iterations = 0;
    private AlertGenerator alertGen;    
    
    public StarShipController(int i) {
    	iterations = i;
    	System.out.println("Init for "+i+" iterations");
    }
    public void run(){
    	if(iterations == 0){
    		System.out.println("Have to init Starship first");
    		return;
    	}
    	else{
    		int i = iterations;
    		for(int j = 0; j < i; j++){
    		alertGen = new AlertGenerator();
    		System.out.println(alertGen.nextStatus());
    		
    		}
    	}
    }
    
    public void forceRed(){
    	if(iterations == 0){
    		System.out.println("Have to init Starship first");
    		return;
    	}
    	System.out.println("Force the Status to Red: "+new AlertStatusRed());
    }
    
    
    
}
