public class MinMax {
	
    /*
     * Determine the min and max values of the input array a in the range ub to ub (inclusive)
     * using a Floor(n/2) and Ceiling (n/2)split.
     *
     * Input:
     * lb – index of lower bound in array a
     * ub – index of upper bound in array a
     * a  - array of values to analyze
     *
     * Output:
     * A Pair object containing the min value in its alpha variable and the max value in its omega variable.
     */
	 
	 
private static class Pair {
   int alpha;   // the smaller one 
   int omega; // the bigger one 
   
   Pair ( int a, int o ) { alpha = a; omega = o; }
}
    public static Pair mmA(int lb, int ub, int[] a) {
		int middle = ( lb + ub )/2 ;
		if ( ub < lb ) return null;
		if ( ub - lb == 1 ){
			if ( a[ub] > a[lb] ){
				
				return new Pair( a[lb], a[ub] );
			}
			else{
				
				return new Pair( a[ub], a[lb]);
			}
		}
		if(ub == lb){
			return new Pair( a[middle], a[middle] );
		}
		
		Pair lPair = mmA( lb , middle, a );
		Pair rPair = mmA( middle + 1, ub, a );
		
		Pair pair = new Pair(0,0);
		
		if (lPair.alpha < rPair.alpha){
			
			pair.alpha = lPair.alpha;
		}
		else
			pair.alpha = rPair.alpha;
		
		if(lPair.omega > rPair.omega){
			pair.omega = lPair.omega;
			
		}
		else
			pair.omega = rPair.omega;
		return pair;
		
		
    }
   
    /*
     * Determine the min and max values of the input array a in the range ub to ub (inclusive)
     * using a better split in order to achieve exactly Ceiling(3n/2 –2) comparisons.
     *
     * Input:
     * lb – index of lower bound in array a
     * ub – index of upper bound in array a
     * a  - array of values to analize
     *
     * Output:
     * A Pair object containing the min value in its alpha variable and the max value in its omega variable.
     */
    public static Pair mmB(int lb, int ub, int[] a) {
		// subarray has even number of elements
		if ( ( ub - lb ) % 2 != 0){
			//basiclly run mmA
			int middle = ( lb + ub )/2 ;
			if ( ub < lb ) return null;
			if ( ub - lb == 1 ){
				if ( a[ub] > a[lb] ){
					
					return new Pair( a[lb], a[ub] );
				}
				else{
					
					return new Pair( a[ub], a[lb]);
				}
			}
			if(ub == lb){
				return new Pair( a[middle], a[middle] );
			}
			
			Pair lPair = mmA( lb , middle, a );
			Pair rPair = mmA( middle + 1, ub, a );
			
			Pair pair = new Pair(0,0);
			
			if (lPair.alpha < rPair.alpha){
				
				pair.alpha = lPair.alpha;
			}
			else
				pair.alpha = rPair.alpha;
			
			if(lPair.omega > rPair.omega){
				pair.omega = lPair.omega;
				
			}
			else
				pair.omega = rPair.omega;
			return pair;
		}
		// if subarray has odd numbers of elements, just find max and min for the first n-1 item and do it recursively
		else{
			ub = ub - 1;	
			int middle = ( lb + ub )/2 ;
			if ( ub < lb ) return null;
			if ( ub - lb == 1 ){
				if ( a[ub] > a[lb] ){
					
					return new Pair( a[lb], a[ub] );
				}
				else{
					
					return new Pair( a[ub], a[lb] );
				}
			}
			Pair lPair = mmA( lb , middle, a );
			Pair rPair = mmA( middle + 1, ub, a );
			int lastInput = a[ ub + 1 ];
			Pair pair = new Pair(0,0);
			
			if (lPair.alpha < rPair.alpha){
				
				pair.alpha = lPair.alpha;
			}
			else
				pair.alpha = rPair.alpha;
			
			if(lPair.omega > rPair.omega){
				pair.omega = lPair.omega;
				
			}
			else
				pair.omega = rPair.omega;
			//if the n item is bigger than max, a[n] is max value. same rule applied when fin min value
			if (lastInput > pair.omega)pair.omega = lastInput;
			if (lastInput < pair.alpha)pair.alpha = lastInput;
			return pair;
		}
		
		
    }

	
}





