/**
 * 
 */
package dp;

/**
 * @author uditgupta
 * Jun 19, 2016 2:22:29 PM
 */
public class RegexMatching {

	public static boolean matchRegex(String s, String p){
		if(p == null || p.length() == 0)
			return s== null || (s.length() == 0) ;
		int m = s.length();
		int n = p.length();
//		if(s.equals(p))
//			return true;
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		
		for(int i = 1; i<=n; i++){
			if(p.charAt(i-1) == '*')
				dp[0][i] = dp[0][i-2];
		}
		
		for(int i = 1; i<=m; i++){
			for(int j = 1; j<=n;j++){
				if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))
					dp[i][j] = dp[i-1][j-1];
				else if(p.charAt(j-1) == '*'){
					dp[i][j] = dp[i][j-2];
					if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1))
						dp[i][j] = dp[i][j] || dp[i-1][j];
				}else
					dp[i][j] = false;
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		//System.out.println(matchRegex("abbbbccc","a*ab*bbbbc*"));
		//System.out.println(matchRegex("a","a"));
		//System.out.println(matchRegex("ac","ab*c"));
		//System.out.println(matchRegex("baaaaaabaaaabaaaaababababbaab","..a*aa*a.aba*a*bab*"));
		System.out.println(matchRegex("efwihfioghih35i",".*"));
	}

}
