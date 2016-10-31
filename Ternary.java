/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:19-Jan-2015 
 *
 * 
 */ 

public class Ternary {
         
         static int  x=0;
         //private int x=0;
   
    public static int theGreaterOrEqualOf(int a,int b){
    	  x = a< b ? a * 100 : a * 10;
    	  return x;

    }
    
    
    public static void main(String[] args) {
    
    	 System.out.println(Ternary.theGreaterOrEqualOf(8,10));//don't need a object to access the method because it's static

    }
}
