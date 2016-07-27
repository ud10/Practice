package graphs;
import java.util.*;

class WordNode{
	String word;
	int numSteps;
	WordNode(String word, int numSteps){
		this.word = word;
		this.numSteps = numSteps;
	}
}
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> ll = new LinkedList<WordNode>();
		ll.add(new WordNode(beginWord, 1));
		
		wordDict.add(endWord);
		while(!ll.isEmpty()){
			WordNode w = ll.remove();
			String s = w.word;
			if(s.equals(endWord))
				return w.numSteps;
			char[] arr = s.toCharArray();
			for(int i=0;i<arr.length;i++){
				for(char c='a';c<='z';c++){
					char tempChar = arr[i];
					if(arr[i] != c)
						arr[i] = c;
					String temp = new String(arr);
					if(wordDict.contains(temp)){
						ll.add(new WordNode(temp, w.numSteps + 1));
						wordDict.remove(temp);
					}
					arr[i] = tempChar;
				}
			}
		}
		return 0;
	}

}
