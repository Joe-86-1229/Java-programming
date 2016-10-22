class FLrep extends TreeAndRepresentation {
  private int k;
  private int start;	//start position in searching function
  private int end;		//end position in searching function
  private int depth;	//record of depth
  FLrep( int m, int[] b ) { // given sequence build tree
    super( m, b );
    N = M;
    t = buildTree( a, 0, N-1, 0 );
  }
  FLrep( int n, BT t ) { // given tree build sequence
    super( n, t);
    depth = 0;
	M = N;
	a = new int[ M ];
	k = -1;
	inTraverse( t, depth );
	
	
  }
  BT buildTree( int in[], int start, int end, int iniValue){
   
   if ( start < end ) {
		int index = searchIndex( in, start, end, iniValue);	//search the index of root of every subtree
		
		// find the depth in sequence, from left to right until the root index 
		// ,which is '1' greater than the root depth, then build the left subtree 
		
		// find the depth in sequence, from root index to the end, 
		// which is equal to the root depth, then bulid the right subtree
		t = new BT( buildTree ( in, start, index, iniValue + 1 ), buildTree ( in, index + 1, end, iniValue ) ) ;	
	}
   if ( start == M-1){	
	   
	   return new BT(null,null);
   }

   if ( start == end ) {
	    
		return null;
	}
	return t;
  }
	
  
  
  void inTraverse( BT t, int depth ){
    if ( t == null){
		return;
	} 
	
	inTraverse ( t.L, depth + 1 );
	a[++k] = depth;
	inTraverse ( t.R, depth );
	
  }
  
  int searchIndex(int in[],int start, int end, int value){
	int i;
	for (i = start; i < end; i++) {
		if (in[i] == value) {
			return i;
		}
	}
	return i;
  }
}