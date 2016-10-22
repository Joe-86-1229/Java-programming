/* PairProduct.java
   CSC 225 - Fall 2015
   Programming Assignment 1 - Template for PairProduct
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java PairProduct
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java PairProduct file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird - 05/01/2014
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the PairUp class
public class PairProduct{
	/* PairProduct225()
		The input array A will contain non-negative integers. The function
		will search the array A for a pair of elements which sum to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean PairProduct(int[] A){
		
		int n = A.length;
		boolean pair = false;
		int[] indexArray = new int[226];
		//T(n) is 2n, which is O(n),will explained following
		inputValue(A,indexArray);
		pair = findIt(A,indexArray);
		

		return pair;
	}
	
	//put the array A into a second array follow the rules:
	//if 225 can be divided by A[i] = k, then set value ONE in indexArray[k].
	//more specific if A[0] = 1,then 1 goes into indexArray[1];
	//T(n) = n which is the size of array
	public static void inputValue(int[] A,int[] B){
		double max = 225;
		for(int i = 0; i < A.length; i++){
			double dob = max/A[i];
			if (dob == (int)dob){
				int tmp;
				tmp = (int)dob;
				B[A[i]] = 1;
			
			}
		}
	}
	//select element from beginnign from array A, then j = 225/A[i]
	//if there is a pair, then indexArray[j] = 1.
	//T(n) = n 
	public static boolean findIt(int[] A, int[] B){
		boolean pairProduct = false;
		double max = 225;
		for(int j = 0; j < A.length; j++){
			double tmp = max/A[j];
			if(tmp == (int)tmp){
				int tmp1 = (int)tmp;
				if(B[tmp1] == 1){
					return true;
				}
			}
		}
		
		
		return pairProduct;
	}
		

		
	


	/* main()
	   Contains code to test the PairProduct225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the PairProduct225() function above 
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
		
		boolean pairExists = PairProduct(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a pair of values which multiply to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
