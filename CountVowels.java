/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:24-Jan-2015 
 *
 * PROBLEM STATEMENT: count how many vowels in a string
 *
 * PROGRAM DESCRIPTION:  (describe your program here referring to your
 *                        class diagram as needed)
 *
 * CLASS PURPOSE:    (a brief desc of the class's purpose)
 *
 * CLASS INVARIANT: 
 *  private String st;
    private char ch;
    private char[] ch1;
    private int cnA=0;
    private int cnE=0;
    private int cnI=0;
    private int cnO=0;
    private int cnU=0;
 *
 * RUN INSTRUCTIONS: because the string is "abciode", so there is 1 a,1 e, 1 i, 1,o.
 *									
 */ 
public class CountVowels {
        
    private String st;
    private char ch;
    private char[] ch1;
    private int cnA=0;
    private int cnE=0;
    private int cnI=0;
    private int cnO=0;
    private int cnU=0;
    
    public void VowelCount(String s){
    	st=s.toUpperCase();				//for easy calculate,uppercase all the letter
    	for(int i=0;i<st.length();i++){
    		ch=st.charAt(i);			//chose every character from begin to end in the string
    		switch(ch){					//count the number
    			case 'A':cnA++;break;
    			case 'E':cnE++;break;
    			case 'I':cnI++;break;
    			case 'O':cnO++;break;
    			case 'U':cnU++;break;
    			default:break;
    		}
    	}
    	System.out.println("There are "+cnA+" A");
    	System.out.println("There are "+cnE+" E");
    	System.out.println("There are "+cnI+" I");
    	System.out.println("There are "+cnO+" O");
    	System.out.println("There are "+cnU+" U");
    	
    }
    public static void main(String[] args) {
        CountVowels cv=new CountVowels();
        cv.VowelCount("abciode");
    }
}
