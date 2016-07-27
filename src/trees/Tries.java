package trees;
import java.util.*;
class TrieNode{
	char c;
	boolean isLeaf;
	HashMap<Character, TrieNode> children;// = new HashMap<Character, TrieNode>();
	TrieNode(){}
	TrieNode(char c){
		this.c = c;
	}
}
public class Tries {
	private TrieNode root;
	public Tries(){
		this.root = new TrieNode();
	}
	public static void main(String[] args) {
	}
	public void insert(String word){
		HashMap<Character, TrieNode> current = root.children;
		if(root == null)
			root = new TrieNode();
		TrieNode tNode = null;
		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			if(current.containsKey(ch))
				tNode = current.get(ch);
			else{
				tNode = new TrieNode(ch);
				current.put(ch, tNode);
			}
			current = tNode.children;
		}
		tNode.isLeaf = true;
	}
	/**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.isLeaf) {
                return false;
            }
            current.isLeaf = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
	public TrieNode search(String word){
		HashMap<Character, TrieNode> current = root.children;
		TrieNode t = null;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(current.containsKey(c)){
				t = current.get(c);
				current = t.children;
			}else
				return null;
		}
		return t;
	}
}
