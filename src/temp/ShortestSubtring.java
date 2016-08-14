/**
 * 
 */
package temp;

import java.util.HashMap;

/**
 * @author uditgupta
 * Jul 31, 2016 11:52:46 PM
 */
public class ShortestSubtring {

	public static void main(String[] args) {
		String a = "ADOBECODEBANC";
		String b = "ABC";
		System.out.println(GetSubString(a,b));
	}
	public static String GetSubString(String input1,String input2){
		//try{
			if(input1 == null)
				return null;
			String output1 = "";
			int l1 = input1.length();
			int l2 = input2.length();
			if(l2 > l1 || input2 == null) 
		        return output1;
		    
		    HashMap<Character,Integer> wordMap = new HashMap<Character,Integer>();
		    for(int i=0; i<l2; i++){
		        char c = input2.charAt(i);    
		        if(wordMap.containsKey(c)){
		        	int k = wordMap.get(c);
		            wordMap.put(c, k+1);
		        }else
		            wordMap.put(c,1);
		    }
		 
		    HashMap<Character,Integer> stringMap = new HashMap<Character,Integer>();
		    int charCountMapped = 0; // count of characters of word present in string
		    int startIndex = 0;      //starting index of output substring in input1
		    int minLength = l1+1;	 //minimum length of output substring
		    
		    for(int i=0; i<l1; i++){
		        char c = input1.charAt(i);
		        if(wordMap.containsKey(c)){
		            if(stringMap.containsKey(c)){
		                if(stringMap.get(c) < wordMap.get(c))
		                    charCountMapped++;
		                int k = stringMap.get(c);
		                stringMap.put(c,k+1);
		            }else{
		                stringMap.put(c,1);
		                charCountMapped++;
		            }
		        } 
		        if(l2 == charCountMapped){
		            char nextChar = input1.charAt(startIndex);
		            while(!stringMap.containsKey(nextChar) || stringMap.get(nextChar) > wordMap.get(nextChar)){
		                if(stringMap.containsKey(nextChar) && stringMap.get(nextChar) > wordMap.get(nextChar)){
		                    int q = stringMap.get(nextChar);
		                	stringMap.put(nextChar, q - 1);
		            	}
		                startIndex++;
		                nextChar = input1.charAt(startIndex);
		            }
		            if (minLength > (i-startIndex+1)) {
		            	output1 = input1.substring(startIndex, i+1);
		                minLength = i-startIndex+1;
		            }
		        }
		    }
		 return output1;
//		}catch(Exception e){
//			
//		}
//		throw new UnsupportedOperationException("GetSubString(String input1,String input2)");
	}
}
