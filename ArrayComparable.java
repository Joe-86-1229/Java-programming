
import java.util.*;



public class ArrayComparable {
  private MyComparableType[] arr = new MyComparableType[5];

  private void fill() {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new MyComparableType((int)(Math.random() * 100),
                                    (int)(Math.random() * 100));
    }
  }

  private void display(String s) {
    System.out.println(s);
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);
  }

  private void run() {
    fill();
    display("Before Sort:");

    // When sort is called this way the items stored must
    // implement Comparable
    Arrays.sort(arr);
    display("After Sort by I:");
    
    //sorted by a comparator method
    Arrays.sort(arr,MyComparableType.getComparator());
    display("After Sort by J:");
  }

  public static void main(String[] args) {
    ArrayComparable ar = new ArrayComparable();
    ar.run();
  }
}


// The data class that we want to sort
class MyComparableType
    implements Comparable<MyComparableType> {
  private int i;
  private int j;
  MyComparableType(int iVal, int jVal) {
    i = iVal;
    j = jVal;
  }
  public int getI() { return i; }
  public int getJ() { return j; }
  
  public String toString() {
    return new String("MyCompType:  i = " + i + " & j = " + j);
  }


// this new method implement comparator with as ascending sort on j
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


  public int compareTo(MyComparableType mct) {
    int i2 = mct.i;
    return (i < i2 ? -1 : (i == i2 ? 0 : 1));
  }

}