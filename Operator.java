/**
 * AUTHOR:Jianqiao Zhou
 *
 * CONTACT INFORMATION:Jianqiao.Zhou@student.ufv.ca
 *
 * CREATION DATE:19-Jan-2015 
 *
 * 
 */ 

public class Operator {
	
    public void run(){
    	int i=5;int k=0;
    	k=i++;	//k=5
    	System.out.println(k);//k=5
    	System.out.println(i);//i=6
    	k=++i; 				  //k=7
    	System.out.println(i);//i=7
    	System.out.println(k);//k=7
    	
    }    
    
    
    
    public static void main(String[] args) {
        new Operator().run();
        
    }
}
