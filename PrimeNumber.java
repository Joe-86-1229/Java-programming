/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:24-Jan-2015 
 *
 * PROBLEM STATEMENT: decide the prime number from 2 to the highest
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    (a brief desc of the class's purpose)
 *
 * CLASS INVARIANT:nums
 *
 * RUN INSTRUCTIONS:5 is highest number , so the output are 2 is prime number
 *															3 is prime number
 *															5 is prime number
 *									
 */ 

public class PrimeNumber {
        
    private int nums=0;
    
    public void  WhetherPrimeNumber(int num){
    	
    	for(int i=2;i<=num;i++){
    		int k=0;
    		for(k=2;k<i;k++){		     
    		   if(i%k==0){
    		   System.out.println(i+" is not a prime");//once the num can divided without remainder, it is not a prime
    		   break;								   //break the inner loop
    	       }		
    	    } 
    	     if(k>=i)
    	     	System.out.println(i+" is a prime");  //once the value of k reach the value of i,it goes through all the value from
    	     										  //2 to i-1.
    	     
    	}
    }
    
    								
    								
    
    
    
    
    public static void main(String[] args) {
        PrimeNumber pn=new PrimeNumber();
        pn.WhetherPrimeNumber(5);
       
        	 
    }
}
