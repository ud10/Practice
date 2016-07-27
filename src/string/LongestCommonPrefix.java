package string;
import java.util.ArrayList;
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String x = "abcdefgh";
		String y = "abcefghijk";
		String z = "abcefgh";
		ArrayList<String> a = new ArrayList<String>();
		a.add(x);a.add(y);a.add(z);
		System.out.println(longestCommonPrefix(a));
	}
	public static String longestCommonPrefix(ArrayList<String> a) {
		if(a.size() == 0)
			return "";
		int minLen = Integer.MAX_VALUE;
		for(String str: a){
			if(str.length() < minLen)
				minLen = str.length();
		}
		if(minLen == 0)
			return "";
		for(int i = 0; i<minLen; i++){
			//char pre = '0';
			for(int j = 0; j<a.size()-1; j++){
//				if(j==0){
//					pre = a.get(j).charAt(i);
//					continue;
//				}
				if(a.get(j).charAt(i) != a.get(j+1).charAt(i))
					return a.get(j).substring(0,i);
			}
		}
		return a.get(0).substring(0, minLen);
	}
}	
