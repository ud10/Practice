import java.util.*;
public class BadWords {
	/*
	 * FormZero(may be)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] add = {"brokenlink", "flowerpower.net","purchasedomain.com"};
		String[] key = {"broken", "cheap free","cheap free domain biggest greatest"};
		String[] bad = {"biggest", "enemy","hideout"};
		get_bad_websites(add, key, bad, 1);
	}
	static void get_bad_websites(String[] address, String[] keywords, String[] badWords, int threshold) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int x = badWords.length;
        int z = keywords.length;
        for(int i =0;i<x;i++){
        	if(!hm.containsKey(badWords[i]))
        		hm.put(badWords[i], -1);
        }
//      System.out.println(hm.entrySet());
        int count = 0;
        for(int i=0;i<z;i++){
        	count = 0;
        	String[] elem = keywords[i].split(" ");
        	for(String s: elem){
        		if(hm.containsKey(s)){
        			count++;
        		}
        		if(count >= threshold){
        			break;
        		}
        	}
        	if(count >= threshold){
    			for(String s: elem){
    				if(!hm.containsKey(s))
    	        		hm.put(s, i);
    			}
    		}
        }
        for(int i=0;i<z;i++){
        	count = 0;
        	String[] elem = keywords[i].split(" ");
        	for(String s: elem){
        		if(hm.containsKey(s)){
        			count++;
        		}
        		if(count >= threshold){
        			break;
        		}
        	}
        	if(count >= threshold){
        		System.out.println(address[i]);
        	}
        }
    }

}
