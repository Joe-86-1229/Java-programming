/**
 * @(#)inherited.java
 *
 *
 * @author 
 * @version 1.00 2015/2/16
 */

public class inherited {
        
class A(){
	A(){
		System.out.println("a new A");
	}
}

class B(){
	B(){
		System.out.println("a new B");
	}
}

class C extends A(){
	new B();
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
