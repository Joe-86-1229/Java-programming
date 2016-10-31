
import java.util.*;

public class ListComparable {
  private List l = new LinkedList();
  // a new list used for copy
  private List l2 = new LinkedList();
  
  public void fill() {
    for (int i = 0; i < 5; i++)
      l.add(new MyComparableType((int)(Math.random() * 100),
                                 (int)(Math.random() * 100))); 
  }
  
  public void fillTwo() {
    for (int i = 0; i < 5; i++)
      l2.add(new MyComparableType((int)(Math.random() * 100),
                                 (int)(Math.random() * 100))); 
  }
  
  public void display(String s) {
    ListIterator it = l.listIterator();
    System.out.println(s);
    while(it.hasNext()) System.out.println(it.next());
  }
  
  public void displayTwo(String s) {
    ListIterator it = l2.listIterator();
    System.out.println(s);
    while(it.hasNext()) System.out.println(it.next());
  }
  
  public void run() {
    fill();
    display("List One Before sort:");
    
    fillTwo();
    displayTwo("List Two Before Copy:");
    
    Collections.copy(l2,l);
    displayTwo("Copy List One to List Two, List Two Now:");
    
    Collections.shuffle(l);
    display("List One After Shuffle :");
    
    Collections.sort(l);
    display("List One After Sort  By I:");
    
    Collections.sort(l,MyComparableType.getComparator());
    display("List One After Sort  By J:");
    
    
  }
  
  public static void main(String[] args) {
    ListComparable lc = new ListComparable();
    lc.run();
  }
}

/**
 *  Note how we can make any changes we want to this class,
 *  even how it is compared with other instances of the same
 *  type and the code above does not need to be updated.
 */
class MyComparableType 
    implements Comparable<MyComparableType> {
    // using <MyComparableType> defines it in Comparable
    // so that compareTo is correctly overridden
  private int i;
  private int j;
  MyComparableType(int iVal, int jVal) {
    i = iVal;
    j = jVal;
  }
  
  public int getI() { return i; }
  public int getJ() { return j; }
  
  
  public String toString() {
    return new String("MyComparableType:  i = " + i + " & j = " + j);
  }
  public int compareTo(MyComparableType mct) {
    int i2 = mct.i;
    return (i < i2 ? -1 : (i == i2 ? 0 : 1));
  }
  
  // method implements comparator comparing on j
  private static class MyCompTypeComparator<E extends MyComparableType>
  	  implements Comparator<E> {
    public int compare (E e1, E e2) {
      int j1 = e1.getJ();
      int j2 = e2.getJ();
      return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
  }
  public static Comparator getComparator() {
    return new MyCompTypeComparator<MyComparableType>();
  }
  
}


