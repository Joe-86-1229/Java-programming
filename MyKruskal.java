
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;


class MyEdge implements Comparable<MyEdge>{
   private final int v; // NOTE: ensure v < w.
   private final int w;
   private long weight;

   public int minv() { return v; }
   public int maxv() { return w; }
   public long weight() { return weight; }
   public void changeWeight( long weight ) { this.weight = weight; }

   public MyEdge ( int v, int w, long weight ) {
      this.v = v < w ? v : w;
      this.w = v < w ? w : v;
      this.weight = weight;
   }

   

public String toString() {
      return String.format("%d-%d %d", v, w, weight);
   }

public int compareTo(MyEdge that) {
	   if      (this.weight() < that.weight()) 	
		   		return -1;
       else if (this.weight() > that.weight()) 	
    	   		return +1;
       else if (this.weight() == that.weight())
       		{	
    	   		if	(this.v < that.v) 		
    	   			return -1;
    	   		else if (this.v > that.v) 		
    	   			return +1;
    	   		else if (this.v == that.v){
    	   				 if	(this.w < that.w) 
    	   					 return -1;
    	   				 else if(this.w > that.w) 
    	   					 return +1;
    	   			
    	   		}
       		}
       return 0;
   }
   
   
   public int either() {
       return v;
   }
   
   public int other(int vertex) {
       if      (vertex == v) return w;
       else if (vertex == w) return v;
       else throw new IllegalArgumentException("Illegal endpoint");
   }
  

}


class MyEdgeWeightedGraph {

    private final int V;
    private final int E;
    private Bag<MyEdge> edges;

    public int V() { return V; }
    public int E() { return E; }

    public Iterable<MyEdge> edges() { return edges; }
    
    
   
    public 	MyEdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        edges = new Bag<MyEdge>();
        
    }

    public MyEdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            long weight = in.readLong();
            MyEdge e = new MyEdge(v, w, weight);
            addEdge(e);
        }
    }
    
    
    public void addEdge(MyEdge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        edges.add(e);
        
    }
    
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
   
 
}





public class MyKruskal {
	

	    private long weight;                        // weight of MST
	    private Queue<MyEdge> mst = new Queue<MyEdge>();  // edges in MST

	    
	    public MyKruskal(MyEdgeWeightedGraph G) {
	       
	        MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
	        for (MyEdge e : G.edges()) {
	            pq.insert(e);
	        }

	        // run greedy algorithm
	        UF uf = new UF(G.V());
	        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
	            MyEdge e = pq.delMin();
	            int v = e.either();
	            int w = e.other(v);
	            if (!uf.connected(v, w)) { // v-w does not create a cycle
	                uf.union(v, w);  // merge v and w components
	                mst.enqueue(e);  // add edge e to mst
	                weight += e.weight();
	            }
	        }
	    }

	  
	    public Iterable<MyEdge> edges() {
	        return mst;
	    }

	    
	    public long weight() {
	        return weight;
	    }
	    
	

	   
public static long include( MyEdgeWeightedGraph G ) {
	
		long inWeight = 0;
		MinPQ<MyEdge> pq = new MinPQ<MyEdge>();

		
		for (MyEdge e : G.edges()){
			/*refill the PQ*/
			for (MyEdge eg : G.edges()) {
		        pq.insert(eg);
		    }
			/*rebuild a mst*/
			Queue<MyEdge> mst = new Queue<MyEdge>();
			UF uf = new UF(G.V());
		
			int v = e.either();
			int w = e.other(v);
			/*Add the edge into mst first*/
			if(!uf.connected(v, w)){
				uf.union(v,w);
				mst.enqueue(e); 
				inWeight += e.weight();
			}
			/*then build mst with the edge already in mst */
				while (!pq.isEmpty() && mst.size() < G.V() - 1) {
		            MyEdge e1 = pq.delMin();
		            int v1 = e1.either();
		            int w1 = e1.other(v1);
		            /*skip the same edge*/
		            if( !( v == v1 ) || !( w == w1 ) ){
			            if (!uf.connected(v1, w1)) { // v-w does not create a cycle
			                uf.union(v1, w1);  // merge v and w components
			                mst.enqueue(e1);  // add edge e to mst
			                inWeight += e1.weight();
			                
				            }
			            }
					}
 			}
	        
	     
 			
 		return inWeight;
}


public static long exclude( MyEdgeWeightedGraph G ) {
    	long exWeight = 0;
    	MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
    	for (MyEdge e : G.edges()){
				/*refill the PQ*/
				for (MyEdge eg : G.edges()) {
			        pq.insert(eg);
			    }
				/*rebuild a mst*/
				Queue<MyEdge> mst = new Queue<MyEdge>();
				UF uf = new UF(G.V());
			
				int v = e.either();
				int w = e.other(v);
				/*a temp variable keep Track of weights of every mst*/
				long tmpWeight = 0;
				
				while (!pq.isEmpty() && mst.size() < G.V() - 1) {
					
		            MyEdge e1 = pq.delMin();
		            int v1 = e1.either();
		            int w1 = e1.other(v1);
		            /*if e1 is the edge, do not add it into mst*/
		            if( !( v == v1 ) || !( w == w1 ) ){
			            if (!uf.connected(v1, w1)) { // v-w does not create a cycle
			                uf.union(v1, w1);  // merge v and w components
			                mst.enqueue(e1);  // add edge e to mst
			                tmpWeight += e1.weight();
			               
			            }
		            }
				}
				/*if mst is tree, then number of edges equals number of vertices - 1,otherwis
				the Graph is disconnected*/
				if (mst.size() < G.V() - 1)
					exWeight += -99;
				else exWeight += tmpWeight;
				
			}
    	
    	
    	return exWeight;
 }
public static void main(String[] args) {
	        In in = new In(args[0]);
	        MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(in);
	        MyKruskal mst = new MyKruskal(G);
	      
	        StdOut.println( mst.weight());
	        System.out.println( MyKruskal.include( G ) );
	        System.out.println( MyKruskal.exclude( G ) );
	    }
	
}
