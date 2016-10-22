/*
Name:Jianqiao Zhou
ID: V00852096
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the HeapSort class
public class HeapSort{
	/* HeapSort(A)
		Sort the array A using heap sort.
		You may add additional functions (or classes) if needed, but the entire program must be
		contained in this file. 

		Do not change the function signature (name/parameters).
	*/
	
	public static int heapsize;
	public static int[] arrayToSort;
	
	public static void HeapSort(int[] A){
		heapsize = A.length;
		arrayToSort = A;
		heapsort(arrayToSort);
	}
	
	/*
		parent,left,right function return its parent,left,right element according
		to its index.
		For instance:The heap index starts from 0,so index 1 and 2 is the 
		children of index 0.
		
	*/
		
	public static int parent(int e){
			return (e-1)/2;
		}
	
	public static int left(int e){
			return e*2+1;
		}
	
	public static int right(int e){
			return e*2+2;
		}
	
	public static void heapsort(int [] A){
		buildMaxHeap(A);
		/*after building the max heap,swap the root with the last node.
		  The Max node will stores at the very end, and the max node won'
		  involve in comparison
		 */
		for (int i = A.length - 1; i > 0; i--) {
		int temp = A[i];
		A[i] = A[0];
		A[0] = temp;
		//isolate the last node, which is the max
		heapsize--;
		//only the first node breaks the property, so run keepMaxHeap on it.
		keepMaxHeap(0);
		}
	}
	
	//building a heap tree with max property, which means A[parent]>A[child]
	public static void buildMaxHeap(int [] A){
		heapsize = A.length;
		//starts from the last node which is a parent
		for (int i = parent(heapsize - 1); i >= 0; i--)
		keepMaxHeap(i);
		}
		
	//keeping max property for heap tree
	public static void keepMaxHeap(int i){
		// get the left and right index based on parent (i) index
		int l = left(i);
		int r = right(i);
		// assume parent > left and right children
		int largest = i;
		// if parent < left ,larget = left
		if (l <= heapsize - 1 && arrayToSort[l] > arrayToSort[i])
			largest = l;
		// if parent < right, largest = right
		if (r <= heapsize - 1 && arrayToSort[r] > arrayToSort[largest])
			largest = r;
		
		//if largest is not parent anymore, swap parent with A[largest]
		if (largest != i) {
			int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[largest];
			arrayToSort[largest] = temp;
			//keeping swap if any property is not right
			keepMaxHeap(largest);
			}
		}

	/* main()
	   Contains code to test the HeapSort function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the HeapSort() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		HeapSort(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		//Don't print out the values if there are more than 100 of them
		if (array.length <= 100){
			System.out.println("Sorted values:");
			for (int i = 0; i < array.length; i++)
				System.out.printf("%d ",array[i]);
			System.out.println();
		}

		//Check whether the sort was successful
		boolean isSorted = true;
		for (int i = 0; i < array.length-1; i++)
			if (array[i] > array[i+1])
				isSorted = false;

		System.out.printf("Array %s sorted.\n",isSorted? "is":"is not");
		System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
	}
}
