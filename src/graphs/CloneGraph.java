package graphs;
import java.util.*;
/**
 * Definition for undirected graph.
 */
 class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { 
    	  label = x; 
    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
      }
  }
public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, head);
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pop();
            List<UndirectedGraphNode> currNeighbors = curr.neighbors;
            
            for(UndirectedGraphNode n: currNeighbors){
                if(!map.containsKey(n)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    map.put(n, copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(n);
                }else{
                    map.get(curr).neighbors.add(map.get(n));
                }
            }
        }
        return head;
    }

}
