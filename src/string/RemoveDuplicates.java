package string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args){
		removeDuplicateChars("abaacdedcdhg");
	}
	public static void removeDuplicateChars(String input) {
        // COMPLETE ME
        // warning: writing to System.out will break scoring
        
        if(input.length() == 0 || input.isEmpty()){
        	return;
        }
        char[] charArray = input.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : charArray) {
            charSet.add(c);
        }

        StringBuilder string = new StringBuilder();
        for (Character character : charSet) {
        	string.append(character);
        }
        System.out.println(string.toString());
    }
	/*
	 * Other Solns - 
	 * 	1. Sort and traverse
	 *  2. Use HashMap
	 */
}
