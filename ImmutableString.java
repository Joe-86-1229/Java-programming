/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:19-Jan-2015 
 *
 * 
 */ 

public class ImmutableString {
        
   
    
    
    public String appendTheString(String a){
    	a=a+"Wolrd";
    	System.out.println(a);
    	return a;
    	
    }
    
    
    public static void main(String[] args) {
    	String s="Hello ";
    	
    	ImmutableString IS=new ImmutableString();
        String s2=IS.appendTheString(s);
        System.out.println(s);
        System.out.println(s2);
        
    }
}
