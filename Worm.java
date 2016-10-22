import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;





// basically same code within alg4.jar, but edit initialization function digraph keeping track of number of 0 weight edges
class FloydWarshall {
	private double[][] distTo;  // distTo[v][w] = length of shortest v->w path
    private DirectedEdge[][] edgeTo;  // edgeTo[v][w] = last edge on shortest v->w path
    private int[][] wormHoles;
 
   
    public FloydWarshall(AdjMatrixEdgeWeightedDigraph G) {
        int V = G.V();
        distTo = new double[V][V];
        edgeTo = new DirectedEdge[V][V];
        wormHoles = new int[V][V];

        // initialize distances to infinity
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
                distTo[v][w] = Double.POSITIVE_INFINITY;
            }
        }

        // initialize distances using edge-weighted digraph's
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                distTo[e.from()][e.to()] = e.weight();
                if( e.weight() == 0 )// if it's a 0 weigh edge, there must be a wormhole
                	wormHoles[e.from()][e.to()] = wormHoles[e.from()][e.to()] + 1;
                edgeTo[e.from()][e.to()] = e;
                
            }
            // in case of self-loops
            if (distTo[v][v] >= 0.0) {
                distTo[v][v] = 0.0;
                edgeTo[v][v] = null;
            }
        }

        // Floyd-Warshall updates
        for (int i = 0; i < V; i++) {
            // compute shortest paths using only 0, 1, ..., i as intermediate vertices
            for (int v = 0; v < V; v++) {
                if (edgeTo[v][i] == null) continue;  // optimization
                for (int w = 0; w < V; w++) {
                    if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
                        distTo[v][w] = distTo[v][i] + distTo[i][w];
                        //if there is any 0 weight edges between shortest path, add the number of wormholes up of precedent path
                        if( distTo[v][i] == 0 || distTo[i][w] == 0 )
                        	wormHoles[v][w] = wormHoles[v][i] + wormHoles[i][w];
                        edgeTo[v][w] = edgeTo[i][w];
                    }
                }           
            }
        }
        
    }
    
    //return the shortest distance of two pairs
    public double dist(int s, int t) {
        return distTo[s][t];
    }
   //return the least number of wormholes of shortest distance of two pairs
    public int numOfworm(int s, int t){
    	return wormHoles[s][t];
    }
   
    
 }

class AdjMatrixEdgeWeightedDigraph{
	  	private int V;
	    private int E;
	    private DirectedEdge[][] adj;
	    
	    public AdjMatrixEdgeWeightedDigraph(int V, int E) {
	        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = E;
	        if (E < 0) throw new RuntimeException("Number of edges must be nonnegative");
	        if (E > V*V) throw new RuntimeException("Too many edges");
	        this.adj = new DirectedEdge[V][V];
	    }
	    
	    
	    public int V() {
	        return V;
	    }

	    /**
	     * Returns the number of edges in the edge-weighted digraph.
	     * @return the number of edges in the edge-weighted digraph
	     */
	    public int E() {
	        return E;
	    }

	    /**
	     * Adds the directed edge <tt>e</tt> to the edge-weighted digraph (if there
	     * is not already an edge with the same endpoints).
	     * @param e the edge
	     */
	    public void addEdge(DirectedEdge e) {
	        int v = e.from();
	        int w = e.to();
	        if (adj[v][w] == null) {
	         //   E++;
	            adj[v][w] = e;
	        }
	    }
	    public Iterable<DirectedEdge> adj(int v) {
	        return new AdjIterator(v);
	    }

	    // support iteration over graph vertices
	    private class AdjIterator implements Iterator<DirectedEdge>, Iterable<DirectedEdge> {
	        private int v;
	        private int w = 0;

	        public AdjIterator(int v) {
	            this.v = v;
	        }

	        public Iterator<DirectedEdge> iterator() {
	            return this;
	        }

	        public boolean hasNext() {
	            while (w < V) {
	                if (adj[v][w] != null) return true;
	                w++;
	            }
	            return false;
	        }

	        public DirectedEdge next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            return adj[v][w++];
	        }

	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    }
}

// planet class stores information of planet
class Planet{
	public int x, y, z;
	public String name;
	
	public Planet( String name, int x, int y, int z ){
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		
	}

	public Planet() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.name = "";
	}
	
	
	
}

public class Worm {

    private FloydWarshall spt;
	private int numOfPlanets = 0;	//number of planets
	private int numOfEdges = 0;		//number of edges
	private int numOfWorms = 0;		//number of Worms
	private int [][] indexOfWormhole;	//index of wormhole.aka start and end point of wormhole
	private ArrayList <String> arrayOfPlanets = new ArrayList<String>();
	private ArrayList <Planet> planets = new ArrayList<Planet>();
   
	public Worm( In in ) {
	   int coorX, coorY, coorZ;
	   int parsec = 0;
	   String pName;	
	   String sWorm;	// start point of worm
	   String eWorm;	 // end point of wormhole
	   
	   // start and end point index of planet of wormhole
	   int sindex;
	   int eindex;
	   numOfPlanets = in.readInt();
	   for( int i = 1; i < numOfPlanets; i++ ){
		   numOfEdges += i;
	   }
	
	   for( int i = 0; i < numOfPlanets; i++ ){
		  pName = in.readString();
		  arrayOfPlanets.add( pName );
		  coorX = in.readInt();
		  coorY = in.readInt();
		  coorZ = in.readInt();
		  Planet planet = new Planet( pName, coorX, coorY, coorZ);
		  planets.add(planet);
		  
	   }
	   AdjMatrixEdgeWeightedDigraph G = new AdjMatrixEdgeWeightedDigraph( numOfPlanets, numOfEdges );
	   numOfWorms = in.readInt();
	   indexOfWormhole = new int[numOfWorms][2];
	   for ( int i = 0; i < numOfWorms; i++ ){
		    sWorm = in.readString();
		    eWorm = in.readString();
		    sindex = arrayOfPlanets.indexOf( sWorm );
		    eindex = arrayOfPlanets.indexOf( eWorm );		    
		    indexOfWormhole[i][0] = sindex;
		    indexOfWormhole[i][1] = eindex;
		    
	
	   }
		    
	   	for ( int j = 0; j < numOfPlanets; j++ ){
	    	for (int k = j + 1; k < numOfPlanets; k++ ){
	    		//check if current pair is a wormhole or not
	    		boolean T1 = checkHole( j, k );
	    		boolean T2 = checkHole( k, j );
	    			if( T1 ){ // if j->k is a wormhole
					   G.addEdge(new DirectedEdge( j, k, 0 ));
	    			}else{
					   parsec = Math.abs((int)Math.sqrt( Math.pow(planets.get( j ).x - planets.get( k ).x , 2) + Math.pow( planets.get( j ).y - planets.get( k ).y , 2) + Math.pow(planets.get( j ).z - planets.get( k ).z , 2 )));
					   G.addEdge( new DirectedEdge( j, k, parsec ) );
	    			}
					if( T2 ){// if k->j is a wormhole
						G.addEdge(new DirectedEdge( k, j, 0 ));
					}else{
						   parsec = (int)Math.sqrt( Math.pow(planets.get( k ).x - planets.get( j ).x , 2) + Math.pow( planets.get( k ).y - planets.get( j ).y , 2) + Math.pow(planets.get( k ).z - planets.get( j ).z , 2 ));
						   G.addEdge( new DirectedEdge( k, j, parsec ) );
					}
  
	    		}
	    	}
		   
			      
	   
	   spt = new FloydWarshall(G);
	  

	}

	// check planets pair exist wormhole or not
   public boolean checkHole( int s, int  e){
	   for ( int i = 0; i < numOfWorms; i++){
		   if ( s == indexOfWormhole[i][0] && e == indexOfWormhole[i][1] )
			   return true;
	   }
	   return false;
   }
   
   public double dist( String origP, String destP ) {
      int index_o = arrayOfPlanets.indexOf(origP);
      int index_d = arrayOfPlanets.indexOf(destP);
      return spt.dist(index_o, index_d);
   }
      
   public int worms( String origP, String destP ) { 
      // least number of wormholes in any shortest path from origP to destP
	   int index_o = arrayOfPlanets.indexOf(origP);
	   int index_d = arrayOfPlanets.indexOf(destP);
	   return spt.numOfworm(index_o, index_d);
	   
   }
 
   public String query( String origP, String destP ) {
	   int index_o = arrayOfPlanets.indexOf( origP );
	   int index_d = arrayOfPlanets.indexOf( destP );
	   String s  = "The distance from " + origP + " to "+ destP +" is " + spt.dist(index_o, index_d)+" parsecs using "+ worms(origP, destP)+" wormholes.";
	   
	   return s;
   }
  
   public static void main(String[] args) {
      // You can test your program with something like this.
      In in = new In( args[0] );
      int T = in.readInt();
      for (int t=1; t<=T; t++) {
         System.out.println("Case " + t + ":") ;
         Worm w = new Worm( in );
         int Q = in.readInt() ;
         for (int i=0; i<Q; i++) {
            String p1s = in.readString() ;
            String p2s = in.readString() ;
            System.out.println( w.query( p1s, p2s ) ) ;
         }
      }
   }
}