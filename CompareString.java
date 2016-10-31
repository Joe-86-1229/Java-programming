/**
 * @(#)CompareString.java
 *
 /**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:24-Jan-2015 
 *
 * PROBLEM STATEMENT: use different method to compare different strings
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    (a brief desc of the class's purpose)
 *
 * CLASS INVARIANT: 
 *
 * RUN INSTRUCTIONS: 
 *									
 */ 

public class CompareString {
        
    public void compare(String a,String b){
    //System.out.println(a>b);	    This will cause compile error
    //System.out.println(a<b);		This will cause compile error
     
     System.out.println(a==b);			//output is false
     System.out.println(a!=b);			//output is true
     System.out.println(a.equals(b));	//output is 1
    
     
    }
    
   
    public static void main(String[] args) {
    	String s1="ac";
    	String s2="ab";
    	String s3="a";
    	String s4="a";
    	CompareString cs=new CompareString();
        cs.compare(s1,s2);
     	
     	System.out.println(s1.compareTo(s2));//use compareTo method which belongs to String class
     										 //s1 is bigger than s2,so the result is 1
     										 
     	System.out.println(s3.compareTo(s2));//use compareTo method
     										 //s3 is smaller tha s2,so the result is -1
     	
        System.out.println(s3.compareTo(s4));//s3 equals to s4, so the result is 0
    }
}
