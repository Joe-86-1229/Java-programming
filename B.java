/**
 * @(#)B.java
 *
 *
 * @author 
 * @version 1.00 2015/2/16
 */

class A{
	public void method(int i){
		System.out.println("output of first method: "+i);
	}
	public void method(float f){
		System.out.println("output of second method: "+f);
	}
	public void method(char c){
		System.out.println("output of third method: "+c);
	}
}

public class B extends A {
	public void method(String s){
		System.out.println("output of fourth method: "+s);
	}
	public void method (int i){
		i++;
		System.out.println("output of overridding method: "+i);
	}
        
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        B b = new B();
        b.method(2);
        b.method(2.3f);
        b.method('a');
        b.method("string");
        
    }
}
