package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String a = "aaaabaaa";
		System.out.println(longestPalindrome(a));

	}
	public static String longestPalindrome(String a) {
		if(a==null || a.length() == 0)
			return null;
		if(a.length() == 1)
			return a;
		String longest = "";
		
		for(int i = 0;i<a.length();i++){
			int left = i; 
			int right = i;
			while(left >= 0 && right< a.length() && a.charAt(left)==a.charAt(right)){
				left--;right++;
			}
			String p = a.substring(left+1, right);
			if(p.length() > longest.length())
				longest = p;
			
			left = i; 
			right = i+1;
			while(left >= 0 && right< a.length() && a.charAt(left)==a.charAt(right)){
				left--;right++;
			}
			p = a.substring(left+1, right);
			if(p.length() > longest.length())
				longest = p;
		}
		return longest;
	}
}
