/**
 * 
 */
package temp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author uditgupta
 * Jul 23, 2016 1:02:59 AM
 */
class NeighbourNode{
	int n;
	NeighbourNode next;
	NeighbourNode(int n, NeighbourNode next){
		this.n = n;
		this.next = next;
	}
}
class Vertex{
	int num;
	NeighbourNode list;
	Vertex(int n, NeighbourNode l){
		this.num = n;
		this.list = l;
	}
}
public class Task3 {
	static Vertex[] vertices = new Vertex[10];
	public int[] solution(int[] T) {
        
		return null;
    }
	public static void print() {
        System.out.println();
        for (int v=0; v < vertices.length; v++) {
            System.out.print(vertices[v].num);
            for (NeighbourNode nbr=vertices[v].list; nbr != null;nbr=nbr.next) {
                System.out.print(" --> " + vertices[nbr.n].num);
            }
            System.out.println("\n");
        }
    }
	public static void main(String[] args) {
		int n = 10;
		int[] T = new int[n];
		T[0] = 9;T[1] = 1;T[2] = 4;T[3] = 9;T[4] = 0;T[5] = 4;T[6] = 8;T[7] = 9;T[8] = 0;T[9] = 1;
		int capital = -1;
		for(int i = 0;i<T.length; i++){
			if(T[i] == i){
				capital = i;break;
			}
		}
		for(int i = 0; i<T.length; i++){
			vertices[i] = new Vertex(i, null);
		}
		for(int i = 0; i<T.length; i++){
			int v1 = i, v2 = T[i];
			if(i != T[i]){
				vertices[v1].list = new NeighbourNode(v2, vertices[v1].list);
				vertices[v2].list = new NeighbourNode(v1, vertices[v2].list);
			}
		}
		print();
		//distance of ith node from capital
		int[] distance = new int[10];
//		for(int i = 0;i<T.length; i++){
//			distance[i] = 
//		}
		
	}

}
