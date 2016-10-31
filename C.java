/**
 * @(#)C.java
 *
 *
 * @author 
 * @version 1.00 2015/2/16
 */


        
class A{
	A(){
		System.out.println("a new A");
	}
	A(int a){
		System.out.println("A's parameter is "+a);
	}
}

class B{
	B(){
		System.out.println("a new B");
	}
	B(int b){
		System.out.println("B's parameter is "+b);
	}
}

public class C extends A{
	
	
	C(){
		System.out.println("a new C");
		B b = new B();
	}
	
	C(int c){
		
		A a = new A(1);
		B b1 = new B(2);
		System.out.println("C's parameter is "+c);
	}
	
	
    
    public static void main(String[] args) {
       C c= new C(3);
    }
	
}
