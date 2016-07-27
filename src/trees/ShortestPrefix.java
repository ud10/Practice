package trees;
import java.util.*;
public class ShortestPrefix {
	public static final int R = 256;
    private Node root;
    private class Node{
        private int count;
        @SuppressWarnings("unused")
		private boolean isEnd;
        private Node next[] = new Node[R];
        public Node(){
            count = 0;
            isEnd = false;
        }
        public Node(int count, boolean isEnd){
            this.count = count;
            this.isEnd = isEnd;
        }
    }
	public static void main(String args[]){
		ArrayList<String> s = new ArrayList<String>();
		s.add("zebra");s.add("dog");s.add("duck");s.add("dove");
		ArrayList<String> z = prefix(s);
		for(int i=0;i<z.size();i++){
			System.out.println(z.get(i));
		}
	}
 	public static ArrayList<String> prefix(ArrayList<String> a){
 		ShortestPrefix trie = new ShortestPrefix();
        for(int i =0;i<a.size();i++){
            trie.insert(a.get(i));
        }
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < a.size(); i++){
            String str = trie.shortestPrefix(a.get(i));
            res.add(str);
        }
        return res;
	}
    public void insert(String str){
        if(root == null) 
            root = new Node();
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(curr.next[c] == null){
                curr.next[c] = new Node(1, false);
            }else{
                curr.next[c].count++;
            }
            curr = curr.next[c];
        }
        curr.isEnd = true;
    }
    public String shortestPrefix(String str){
        Node curr = root;
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            curr = curr.next[c];
            len++;
            if(curr.count == 1) break;
        }
        return str.substring(0, len);
    }
}
