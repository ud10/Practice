package graphs;

import java.io.IOException;
import java.util.*;

public class Digraph<V> {
	public static final int VISIT_COLOR_WHITE = 1;
	public static final int VISIT_COLOR_GREY = 2;
	public static final int VISIT_COLOR_BLACK = 3;
	private int state;
	
    public static class Edge<V>{
        private V vertex;
        private int cost;
       
        public Edge(V v, int c){
            vertex = v; cost = c;
        }

        public V getVertex() {
            return vertex;
        }

        public int getCost() {
            return cost;
        }
        
        @Override
        public String toString() {
            return "Edge [vertex=" + vertex + ", cost=" + cost + "]";
        }

    }
    public void setState(V vertex, int s) {
        state = s;
    }
    
    public int getState() {
        return state;
    }
    /**
     * A Map is used to map each vertex to its list of adjacent vertices.
     */

    private Map<V, List<Edge<V>>> neighbors = new HashMap<V, List<Edge<V>>>();

    //private int nr_edges;

    /**
     * String representation of graph.
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (V v : neighbors.keySet())
            s.append("\n    " + v + " -> " + neighbors.get(v));
        return s.toString();
    }

    /**
     * Add a vertex to the graph. Nothing happens if vertex is already in graph.
     */
    public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<Edge<V>>());
    }

    public int getNumberOfEdges(){
        int sum = 0;
        for(List<Edge<V>> outBounds : neighbors.values()){
            sum += outBounds.size();
        }
        return sum;
    }

    /**
     * True iff graph contains vertex.
     */
    public boolean contains(V vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Add an edge to the graph; if either vertex does not exist, it's added.
     * This implementation allows the creation of multi-edges and self-loops.
     */
    public void add(V from, V to, int cost) {
        this.add(from);
        this.add(to);
        neighbors.get(from).add(new Edge<V>(to, cost));
    }

    public int outDegree(int vertex) {
        return neighbors.get(vertex).size();
    }

    public int inDegree(V vertex) {
       return inboundNeighbors(vertex).size();
    }

    public List<V> outboundNeighbors(V vertex) {
        List<V> list = new ArrayList<V>();
        for(Edge<V> e: neighbors.get(vertex))
            list.add(e.vertex);
        return list;
    }

    @SuppressWarnings("rawtypes")
	public List<V> inboundNeighbors(V inboundVertex) {
        List<V> inList = new ArrayList<V>();
        for (V to : neighbors.keySet()) {
            for (Edge e : neighbors.get(to))
                if (e.vertex.equals(inboundVertex))
                    inList.add(to);
        } 
        return inList;
    }

    public boolean isEdge(V from, V to) {
      for(Edge<V> e :  neighbors.get(from)){
          if(e.vertex.equals(to))
              return true;
      }
      return false;
    }

    public int getCost(V from, V to) {
        for(Edge<V> e :  neighbors.get(from)){
            if(e.vertex.equals(to))
                return e.cost;
        }
        return -1;
    }
//    public List<V> findCycles(Digraph<Integer> graph) {
//        List<V> cycleVertices = new ArrayList<V>();
//        // Mark all vertices as white
//        int numVertices = graph.neighbors.keySet().size();
//        for (int i = 0; i < vertices; i++) {
//          setState(VISIT_COLOR_WHITE);
//        }
//        for (int n = 0; n < verticies.size(); n++) {
//          Vertex<T> v = getVertex(n);
//          visit(v, cycleEdges);
//        }
//
//        Edge<T>[] cycles = new Edge[cycleEdges.size()];
//        cycleEdges.toArray(cycles);
//        return cycles;
//      }
//    
//    private void visit(V vertex, ArrayList<Edge<V>> cycleEdges) {
//    	((Digraph<Integer>) vertex).setState(VISIT_COLOR_GREY);
//        int count = graph.outDegree(vertex);
//        		//vertex.getOutgoingEdgeCount();
//        for (int n = 0; n < count; n++) {
//          Edge<T> e = v.getOutgoingEdge(n);
//          Vertex<T> u = e.getTo();
//          if (u.getMarkState() == VISIT_COLOR_GREY) {
//            // A cycle Edge<T>
//            cycleEdges.add(e);
//          } else if (u.getMarkState() == VISIT_COLOR_WHITE) {
//            visit(u, cycleEdges);
//          }
//        }
//        v.setMarkState(VISIT_COLOR_BLACK);
//      }
    
    public static void main(String[] args) throws IOException {

        Digraph<Integer> graph = new Digraph<Integer>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);

        graph.add(0, 1, 1);
        graph.add(1, 2, 2);
        graph.add(2, 3, 2);
        graph.add(3, 0, 2);
        graph.add(1, 3, 1);
        graph.add(2, 1, 5);

        //findCycles(graph);
        System.out.println("The nr. of vertices is: " + graph.neighbors.keySet().size());
        System.out.println("The nr. of edges is: " + graph.getNumberOfEdges()); // to be fixed
        System.out.println("The current graph: " + graph);
        System.out.println("In-degrees for 0: " + graph.inDegree(0));
        System.out.println("Out-degrees for 0: " + graph.outDegree(0));
        System.out.println("In-degrees for 3: " + graph.inDegree(3));
        System.out.println("Out-degrees for 3: " + graph.outDegree(3));
        System.out.println("Outbounds for 1: "+ graph.outboundNeighbors(1));
        System.out.println("Inbounds for 1: "+ graph.inboundNeighbors(1));
        System.out.println("(0,2)? " + (graph.isEdge(0, 2) ? "It's an edge" : "It's not an edge"));
        System.out.println("(1,3)? " + (graph.isEdge(1, 3) ? "It's an edge" : "It's not an edge"));

        System.out.println("Cost for (1,3)? "+ graph.getCost(1, 3));


    }
}
