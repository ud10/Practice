
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze2 {
	/* Juspay Q1
	 * You are given a maze with N cells. Each cell may have multiple entry points but not more than one exit (ie. entry/exit points are unidirectional doors like valves).
 cells are named with an integer value from 0 to N-1. The length of the largest cycle in the maze. Return -1 if there are no cycles. Aim for O(N) solution. Sample Input(Plaintext Link) 23 4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21 Sample Output(Plaintext Link) 6
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String x = br.readLine();
        String[] val = x.split(" ");
        int[] edge = new int[N];
        for (int i = 0; i < val.length; i++){
        	edge[i] = Integer.parseInt(val[i]);
        }
        Graph<Integer> graph = new Graph<Integer>();
        for (int i = 0; i < N; i++){
        	graph.add(i);
        }
        for (int i = 0; i < N; i++){
        	graph.add(i, edge[i], 1);
        }
        System.out.println("The nr. of vertices is: " + graph.neighbors.keySet().size());
        int max = 0;
        for (int i = 0; i < N; i++){
        	max = Math.max(max, graph.inDegree(i));
        }
        System.out.println("Out-degrees for 3: " + graph.inDegree(3));
        System.out.println(max);
	}
}
class Graph<V> {
	public static class edge<V>{
	    private V vertex;
	    private int cost;
	    
	    public edge(V v, int c){
	        vertex = v; setCost(c);
	    }
	
	    public V getVertex() {
	        return vertex;
	    }

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}
	public Map<V, List<edge<V>>> neighbors = new HashMap<V, List<edge<V>>>();
	
	public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<edge<V>>());
	}
	 public boolean contains(V vertex) {
	        return neighbors.containsKey(vertex);
	    }
	    public void add(V from, V to, int cost) {
	        this.add(from);
	        this.add(to);
	        neighbors.get(from).add(new edge<V>(to, cost));
	    }

	    public int outDegree(int vertex) {
	        return neighbors.get(vertex).size();
	    }

	    public int inDegree(V vertex) {
	       return inboundNeighbors(vertex).size();
	    }

	    public List<V> outboundNeighbors(V vertex) {
	        List<V> list = new ArrayList<V>();
	        for(edge<V> e: neighbors.get(vertex))
	            list.add(e.vertex);
	        return list;
	    }
	    @SuppressWarnings("rawtypes")
		public List<V> inboundNeighbors(V inboundVertex) {
	        List<V> inList = new ArrayList<V>();
	        for (V to : neighbors.keySet()) {
	            for (edge e : neighbors.get(to))
	                if (e.vertex.equals(inboundVertex))
	                    inList.add(to);
	        }
	        return inList;
	    }

}