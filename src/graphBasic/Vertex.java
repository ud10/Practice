/**
 * 
 */
package graphBasic;

import java.util.*;

/**
 * @author uditgupta
 * May 22, 2016 11:08:22 PM
 */
public class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

