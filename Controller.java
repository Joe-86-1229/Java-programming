/**
 * @(#)Controller.java
 *
 *
 * @author 
 * @version 1.00 2015/4/11
 */
import java.util.Scanner;
import java.util.*;
import java.lang.reflect.*;
import java.io.*;


//Purpose: controls the data flow into model object which is playerList

//Data: a Player type list  ‘playerList’

//Behavior: as descried for each method below , it includes methods for users to manipulate playerList 

//Invariant: private playerList can only be manipulated by the Controller object




public class Controller {
        
  // Can only store TheBase or its descendants
  ArrayList<Player> list = new ArrayList<Player>();
  String[] classes = {"Player", "Guard", "Forward", "Center" };
  
  // add an item 
  public void addPlayer() throws ClassNotFoundException{
  		String input = "Empty";
  		String inputTwo = "Empty";
  		int h = 0;
  		int w = 0;
  		System.out.println("Input a class name");
    	Scanner in = new Scanner(System.in);
    	input = in.next();
      	for (int k = 0; k < classes.length; k++){
      		//if the class name existed, continue input value and description
      		if((input).equals(classes[k]) )
      		{
      			System.out.println("Input a height");
    			Scanner in2 = new Scanner(System.in);
    			h = in2.nextInt();
    			System.out.println("Input a weight");
    			Scanner in3 = new Scanner(System.in);
    			w = in3.nextInt();
    			System.out.println("Input a name");
    			Scanner in4 = new Scanner(System.in);
    			inputTwo = in4.nextLine();
    			list.add(loader(input,h,w,inputTwo));
    			return;
      		}
      	}
      		throw new ClassNotFoundException("No class found");
  }
  
//	Tasks: let users keep manipulating player list until users want to quit
//	
//	Precondition: None 
//	
//	Modifies: new object be added into playerList
//	
//	Postcondition: new object based on users’ input data will be put into playerList
  
  
  
  public void editByName(){
  	disp();
  	String input = "Empty";
  	System.out.println("Input the name of the player you want to edit");
  	Scanner in = new Scanner(System.in);
  	input = in.nextLine();
  	for (int i = 0; i < list.size(); i++){
  		
  		if (input.equals(list.get(i).getName()))
  		{
  		
  			System.out.println("input a height");
  			Scanner in1 = new Scanner(System.in);
  			int h = in1.nextInt();
  			list.get(i).height = h;
  			Scanner in2 = new Scanner(System.in);
  			int w = in2.nextInt();
  			list.get(i).weight = w;
  			Scanner in3 = new Scanner(System.in);
  			String input1 = in3.nextLine();
  			list.get(i).name = input1;
  			
  			return;
  		}
  		System.out.println("Name not found");
  	}
  }
 /*	Tasks: allow users to edit the players stored in playerList
	
	Precondition: at least one element in playerList
	
	Modifies: state information of object stored  in playerList 
	
	Postcondition: new state information object based on users’ input data will be changed on chosen object.
*/
  
  public void deleteByName(){
  	disp();
  	String input = "Empty";
  	int k = 0;
  	System.out.println("Input the name of the player you want to delete");
  	Scanner in = new Scanner(System.in);
  	input = in.nextLine();
  		for (int i = 0; i < list.size(); i++){
  			if (input.equals(list.get(i).name))
  			{
			list.remove(i);
			
			}
  		}
  	}
 /*	Tasks: allow users to delete the players stored in playerList by name
	
	Precondition: at least one element in playerList
	
	Modifies: delete object stored in playerList 
	
	Postcondition: chosen object will be deleted from playerList*/

   
   public void save() {
    Iterator<Player> it = list.iterator();
    try {
      PrintWriter outFi = new PrintWriter(new BufferedWriter(new FileWriter("FilesToCreate.txt")));
      // To turn on append
      // PrintWriter outFi = new PrintWriter(new BufferedWriter(new FileWriter("Strings.txt")), true);
      while(it.hasNext())
        outFi.println(it.next());
      outFi.close(); 
    } catch (IOException e) {
      System.out.println("ERROR:  file I/O problem");
    }
  }
  
  /*Tasks: allow users save the playerList into text file

	Precondition: None
	
	Modifies: None 
	
	Postcondition: a text file stored information of playerList be created*/

  
  
    
   //  using scanner 
   public void open(){
  
  	try{
  		Scanner input = new Scanner(new File("FilesToCreate.txt"));
		while (input.hasNext()) {
  			String className = input.next(); // get the class name
  			input.next(); // discard 'height:'
  			int height = input.nextInt(); // get the height:
  			input.next(); // discard 'cm'
  			input.next(); // discard 'weight:'
  			int weight = input.nextInt(); // get the weight:
  			input.next(); // discard 'kg'
  			input.next(); // discard 'name:'
  			String name = input.nextLine(); // rest of the line is the
                                  // name, so get it all
  			name = name.substring(1); // get rid of the leading space 
                            // extracted by nextLine()
  			list.add(loader(className, height, weight, name));
		}
		input.close();

  	   }catch (FileNotFoundException e) {
      	System.out.println("File Not Found");
  	   }
  }
  
  /*Tasks: allow users open a text file into playerList

	Precondition: None
	
	Modifies: playerList is added new elements
	
	Postcondition: playerList is changed*/

  
  
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
      list = (ArrayList<Player>)in.readObject();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("ERROR:  file not found");
    } catch (ClassNotFoundException e) {
      System.out.println("ERROR:  class not found");
    } catch (IOException e) {
      System.out.println("ERROR:  serialization problem");
    }
  }
  

  public Player loader(String toLoad, int h, int w, String name) {
    try {
      // 1. Create the class object
      Class c = Class.forName(toLoad);
      
      // 2. Create an array of constructor param types
      Class[] paramTypes = { Integer.class,Integer.class, String.class };
      
      // 3. Create an array of matching arguments
      Object[] params = { new Integer(h), new Integer(w), new String(name) };
      
      // 4. Get a reference to the specific class contructor
      Constructor ctor = c.getConstructor(paramTypes);
      
      // 5. Create an instance of the object using its base type
      Object o = ctor.newInstance(params);
      
      // 6. Return the newly created instance
      return (Player)o;
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
  
  public void sortByHeight(){
  	if(list.size() < 2){
  		System.out.println("Need more records");
  		return;
  	}
  	Collections.sort(list);
  }
  
  
  public void sortByName(){
  	if(list.size() < 2){
  		System.out.println("Need more records");
  		return;
  	}
  	Collections.sort(list,Player.PlayerComparator());
  }
  
  public void disp() {
    Iterator it = list.iterator();
    while(it.hasNext())
      System.out.println(it.next());
  }
  
  public void playIt(){
  	for (int i = 0; i < list.size(); i++){
  		list.get(i).play();
  	}
  }
  
 

    
    
}
