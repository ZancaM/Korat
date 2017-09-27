import korat.finitization.*;
import korat.finitization.impl.*;
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.lang.Integer;


/*

I was not able to get GIRTH calculations quire right.
If it is possible to obtain a solution using my method with recursion in HashMap would be amazing.
Matteo Zancanella
*/

public class DirectedRGGraph {
    Vertex startVertex;
    
    public static class Vertex {
        Vertex[] outgoingEdges;
    }
    
    int numberOfNodes;     // number of vertices in graph
    int girth;             // length of the minimum cycle in the graph
   
    
    public boolean repOK() {
        // returns true if the directed, duplicate edge, reachability, regular and girth properties are satisfied
        if (startVertex == null)
            return false;
        if (numberOfNodes < 1)
            return false;
        
        int[] g = {Integer.MAX_VALUE};
        HashMap<Vertex, Integer> hasymap = new HashMap<Vertex, Integer>();
	boolean result = checkVertex(startVertex,null, hasymap, g);
        return result && numberOfNodes == hasymap.size() && g[0] == girth;
    }

	// g is an array because I needed an obj to be passed by reference and not by value.
    public boolean checkVertex(Vertex current, Vertex parent, HashMap<Vertex, Integer> hasymap, int[] g){
        
        HashSet<Vertex> checkedChildren = new HashSet<Vertex>();
        if(!hasymap.containsKey(current)){

	    int size = (hasymap.size()+1);
            hasymap.put(current, size);
            for(int i = 0; i < current.outgoingEdges.length; i++){
                Vertex child = current.outgoingEdges[i];
		//child pointing to parent case
	        if(parent != null) { 
                    if(parent == child) return false;
                }
		//Checking current to child reference case (pointing to itself)
		if(current == child) return false;
		// duplicated children check
                if(!checkedChildren.add(child)) return false;
                if(!checkVertex(child,current, hasymap,g)) return false;
            }
        }else{
		// calculating girth
                if(hasymap.containsKey(current)) {
                    if((int)((int)hasymap.get(parent) - ((int)hasymap.get(current)-1)) < g[0]){
                        g[0] = (int)((int)hasymap.get(parent) - ((int)hasymap.get(current)-1));
                    }
                }	   
	}
       
        return true;
    }
    
    void print_graph(Vertex start){
        System.out.println("---------------------------");
        
        List<Vertex> lst = new ArrayList<Vertex>();
        lst.add(start);
        HashMap<Vertex, Integer> h = new HashMap<Vertex, Integer>();
        
        h.put(start, 1);
        
        //System.out.println("Node count: " + get_node_count(start));
        while(!lst.isEmpty()){
            Vertex tmp = lst.remove(0);
            for(int i=0;i<tmp.outgoingEdges.length;i++){
                Vertex neighbour = tmp.outgoingEdges[i];
                System.out.println(""+ tmp.hashCode() + " -> " + neighbour.hashCode() + " ;");
                if(!h.containsKey(neighbour)){
                    lst.add(neighbour);
                    h.put(neighbour, 1);
                }
            }
        }
    }
    
    public static IFinitization finDirectedRGGraph(int numNodes, int r, int g) {
        IFinitization f = FinitizationFactory.create(DirectedRGGraph.class);
        IObjSet vertex = f.createObjSet(Vertex.class, numNodes);
        f.set("startVertex", vertex);
        IIntSet rs = f.createIntSet(r);
        IIntSet num = f.createIntSet(numNodes);
        IArraySet vertexes = f.createArraySet(Vertex[].class, rs, vertex, numNodes);
        f.set("Vertex.outgoingEdges", vertexes); 
        IIntSet girths = f.createIntSet(g);
        f.set("numberOfNodes", num);
        f.set("girth", girths);
        
        return f;
    }
    
    public String toString(){
        // Override of toString().  You may optionally complete this method to support printing graphs at the command line.
        return "My Graph: "+ numberOfNodes + " -- " + girth;
    }
    
}

