/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:24-Jan-2015 
 *
 * PROBLEM STATEMENT: Set the original color and change it
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    (a brief desc of the class's purpose)
 *
 * CLASS INVARIANT: intValue[]
 *
 * RUN INSTRUCTIONS: random result
 *									
 */ 
public class RandomValue {
       private int intValue[]=new int[25]; 
    
    public void run(){
    	for(int i=0;i<25;i++){
    		intValue[i]=(int)(Math.random()*10);	//randomly pick up number from 0 to 10
    	}
    		for(int k=1;k<26;k++){
    			if(intValue[k]>intValue[k+1])
    			System.out.println("The "+k+"th value: "+intValue[k]+" is greater than "+(k+1)+"th value: "+intValue[k+1]); 
    			else if(intValue[k]<intValue[k+1])
    			System.out.println("The "+k+"th value: "+intValue[k]+" is less than "+(k+1)+"th value: "+intValue[k+1]);
    			else 
    			System.out.println("The "+k+"th value: "+intValue[k]+" equals "+(k+1)+"th value: "+intValue[k+1]);
    		}
    		for(int j:intValue){
    			System.out.println(j);
    		}
    }
    		
    
    	
    
    
    
    public static void main(String[] args) {
       RandomValue rv=new RandomValue();
       rv.run();
     
       
    }
}
