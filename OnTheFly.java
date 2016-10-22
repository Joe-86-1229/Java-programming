// Creating objects with contructors at run-time using a 
// string representing the classes name

// P. Paul Kroeker for Comp155

import java.util.*;
import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;


// cannot have a TheBase object
abstract class TheBase implements Comparable<TheBase> {
  private int id;
  private String description;
  public TheBase(Integer i,String des) {
    id = i.intValue();
    description = des;
  }
  public int getID(){
  	return id;
  }
  
  public String getDescription(){
  	return description;
  }
  
  // sort method on id with ascending order
  public int compareTo(TheBase tb) {
    int id2 = tb.id;
    return (id < id2 ? -1 : (id == id2 ? 0 : 1));
  }
  // sort method on description with ascending order
  private static class FlyComparator<E extends TheBase>
  	  implements Comparator<E> {
    public int compare (E e1, E e2) {
      String s1 = e1.getDescription();
      String s2 = e2.getDescription();
      return s1.compareTo(s2);
    }
  }

  // Return an instance of the inner class
  public static Comparator FlyComparator() {
    return new FlyComparator<TheBase>();
  }
  
}

class ChildA extends TheBase {
  public ChildA(Integer i, String des) {
    super(i,des);
  }
  public String toString() {
    return "ChildA  ID: " + getID()+"; "+" Description: "+ getDescription();
  }
}

class ChildB extends TheBase {
  public ChildB(Integer i, String des) {
    super(i,des);
  }
  public String toString() {
    return "ChildB  ID: " +  getID()+"; "+" Description: "+ getDescription();
  }
}

// a new class ChildC , no more code needed
class ChildC extends TheBase {
  public ChildC(Integer i, String des) {
    super(i,des);
  }
  public String toString() {
    return "ChildC  ID: " + getID()+"; "+" Description: "+ getDescription();
  }
}





public class OnTheFly {
  // Can only store TheBase or its descendants
  List<TheBase> list = new ArrayList<TheBase>();
  //List<String> names = new ArrayList<String>();
  String[] names = {"TheBase", "ChildA", "ChildB","ChildC" };
  
  // add an item 
  public void addItem() throws ClassNotFoundException{
  		String input = "Empty";
  		String inputTwo = "Empty";
  		int i = 0;
  		System.out.println("Input a class name");
    	Scanner in = new Scanner(System.in);
    	input = in.next();
      	for (int k = 0; k < names.length; k++){
      		//if the class name existed, continue input value and description
      		if((input).equals(names[k]) )
      		{
      			System.out.println("Input a value");
    			Scanner in2 = new Scanner(System.in);
    			i = in2.nextInt();
    			System.out.println("Input a description");
    			Scanner in3 = new Scanner(System.in);
    			inputTwo = in3.nextLine();
    			list.add(loader(input,i,inputTwo));
    			return;
      		}
      	}
      		throw new ClassNotFoundException("No class found");
  }
   
   public void save() {
    Iterator<TheBase> it = list.iterator();
    try {
      PrintWriter outFi = new PrintWriter(new BufferedWriter(new FileWriter("FilesToCreat.txt")));
      // To turn on append
      // PrintWriter outFi = new PrintWriter(new BufferedWriter(new FileWriter("Strings.txt")), true);
      while(it.hasNext())
        outFi.println(it.next());
      outFi.close(); // should this be in a 'finally' block? why or why not? (see Study Outline)
    } catch (IOException e) {
      System.out.println("ERROR:  file I/O problem");
    }
  }
    
   //  using scanner 
   public void open(){
  	try{
  		Scanner input = new Scanner(new File("FliesToCreate.txt"));
		while (input.hasNext()) {
  			String className = input.next(); // get the class name
  			input.next(); // discard 'ID:'
  			int id = input.nextInt(); // get the ID
  			input.next(); // discard 'Description:'
  			String desc = input.nextLine(); // rest of the line is the
                                  // description, so get it all
  			desc = desc.substring(1); // get rid of the leading space 
                            // extracted by nextLine()
  			list.add(loader(className, id, desc));
		}
		input.close();

  	   }catch (FileNotFoundException e) {
      	System.out.println("File Not Found");
  	   }
  }
  
    public void serializeIt() {
    System.out.println("Afer serializing quit, restart, unserialize and display.");
    System.out.println("The arraylist will be populated as it was when you quit.");
    try {
      // Note:  We will give the file a .txt extension even though it is a binary file so that
      //        we can double click it later to open it with Notepad and look at its contents.
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ObjectIO.txt"));
      out.writeObject(list);
      out.close(); // needed to flush and close
    } catch (IOException e) {
      System.out.println("ERROR:  serialization problem");
    }
  }
  
   public void unSerializeIt() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("ObjectIO.txt"));
      list = (ArrayList<TheBase>)in.readObject();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("ERROR:  file not found");
    } catch (ClassNotFoundException e) {
      System.out.println("ERROR:  class not found");
    } catch (IOException e) {
      System.out.println("ERROR:  serialization problem");
    }
  }
  

  public TheBase loader(String toLoad, int value, String des) {
    try {
      // 1. Create the class object
      Class c = Class.forName(toLoad);
      
      // 2. Create an array of constructor param types
      Class[] paramTypes = { Integer.class, String.class };
      
      // 3. Create an array of matching arguments
      Object[] params = { new Integer(value), new String(des) };
      
      // 4. Get a reference to the specific class contructor
      Constructor ctor = c.getConstructor(paramTypes);
      
      // 5. Create an instance of the object using its base type
      Object o = ctor.newInstance(params);
      
      // 6. Return the newly created instance
      return (TheBase)o;
    } catch (ClassNotFoundException e) { 
      // thrown by forName()      
      // System.out.println(e);
      System.out.println("That class does not exist.");
      // NOTE: there is another exception though if the name given
      //       is spelled correctly but with a case difference
      //       I've added it next.
    } catch (NoClassDefFoundError e) {
      System.out.println("The class name is case sensitive. Please try again.");
    } catch (NoSuchMethodException e) {
      // thrown by getContructor()
      // System.out.println(e);
      System.out.println("A constructor matching those parameters could not be found.");
    } catch (InstantiationException e) {
      // thrown by newInstance()
      System.out.println(e);
    } catch (IllegalAccessException e) {
      // thrown by newInstance()
      System.out.println(e);      
    } catch (InvocationTargetException e) {
      // thrown by newInstance()
      System.out.println(e);
    } 
    return null; // nothing created if this line is reached.
  }
  
  public void sortById(){
  	Collections.sort(list);
  }
  public void sortByDes(){
  	Collections.sort(list,TheBase.FlyComparator());
  }
  
  public void disp() {
    Iterator it = list.iterator();
    while(it.hasNext())
      System.out.println(it.next());
  }
  
 
}