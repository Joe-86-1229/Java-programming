/**
 * @(#)Storage.java
 *
 *
 * @author 
 * @version 1.00 2015/1/16
 */

public class Storage {
	
   	public int getStorage(String s){
   		return s.length();
   	}    
    /**
     * Creates a new instance of <code>Storage</code>.
     */
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Storage st=new Storage();
        
        System.out.println(st.getStorage("Hello World!"));
        
    }
}
