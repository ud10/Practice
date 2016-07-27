/**
 * 
 */
package string;

import java.util.HashMap;

/**
 * @author uditgupta
 * Jul 1, 2016 5:58:46 PM
 */
public class LongestSubstringKUniqueChar {

	public static void main(String[] args) {

	}
	public static int longestSubstr(String str, int k){
		int maxLength = 0, startIndex = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); 
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(hm.containsKey(c)){
				hm.put(c, hm.get(c) + 1);
			}else{
				hm.put(c, 1);
			}
			if(hm.size() > k){
				maxLength = Math.max(maxLength, i-startIndex);
				while(hm.size() > k){
					char cs = str.charAt(startIndex);
					int count = hm.get(cs);
					if(count > 1){
						hm.put(cs, count - 1);
					}else{
						hm.remove(cs);
					}
					startIndex++;
				}
			}
		}
		maxLength = Math.max(maxLength, str.length() - startIndex);
		return maxLength;
	}
}
