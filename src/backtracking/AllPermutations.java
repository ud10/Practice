/**
 * 
 */
package backtracking;

/**
 * @author uditgupta
 * Jul 19, 2016 3:21:24 PM
 */
public class AllPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char[] s = {'a','b','c'};
		permute(s, 0, 2);

	}
	private static void permute(char[] s, int l, int r){
		if(l==r)
			System.out.println(s);
		else{
			for(int i = l; i<=r; i++){
				char c = s[i];
				s[i] = s[l];
				s[l] = c;
				//swap(s[i], s[l]);
				permute(s, l+1, r);
				c = s[i];
				s[i] = s[l];
				s[l] = c;
				//swap(s[i], s[l]);
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void swap(char a, char b){
		char t = a;
		a = b;
		b = t;
	}
	
}
