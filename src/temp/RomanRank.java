/**
 * 
 */
package temp;

import java.util.HashMap;

/**
 * @author uditgupta
 * Jun 10, 2016 11:06:01 AM
 */
class Ordinal{
	String fName;
	String rank;
	public Ordinal(String fName, String rank){
		this.fName = fName;
		this.rank = rank;
	}
}
public class RomanRank {

	public static void main(String[] args) {
		String[] names = new String[4];
		names[0] = "Louis I";
		names[1] = "Louis II";
		names[2] = "Louisse I";
		names[3] = "Louisse II";
		sort(names);
	}
	public static String[] sort(String[] names){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("I", 1);	hm.put("II", 2); hm.put("III", 3); hm.put("IV", 4); hm.put("V", 5);
		hm.put("VI", 6); hm.put("VII", 7); hm.put("VIII", 8); hm.put("VI", 9); hm.put("X", 10);
		hm.put("XX", 20); hm.put("XXX", 30); hm.put("XL", 40); hm.put("L", 50);
		
		for(int i =0; i<names.length; i++){
			
		}
		return null;
	}

}
