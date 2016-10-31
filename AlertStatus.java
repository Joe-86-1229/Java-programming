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
 * CLASS PURPOSE:    There are four classes: AlertStatus, AlertStatusGreen, AlertStatusYellow, AlertStatusRed. AlertStatus is the superclass of other class and 
 *					 it hold a string status. All other children hold there own status respectively.
 * 
 * CLASS INVARIANT:  StarshipController has to be initialized first to run rest of functions
 *
 * RUN INSTRUCTIONS: 
 */

public class AlertStatus {
    public String status; 
}  
    
class AlertStatusGreen extends AlertStatus{
	String status = "Green";
	public String toString(){
		return "The Status now is "+ status;
	}
}
class AlertStatusYellow extends AlertStatus{
	String status = "Yello";
	public String toString(){
		return "The Status now is "+ status;
	}
}

class AlertStatusRed extends AlertStatus{
	String status = "Red";
	public String toString(){
		return "The Status now is "+ status;
	}
}



