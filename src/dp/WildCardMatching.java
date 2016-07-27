/**
 * 
 */
package dp;

/**
 * @author uditgupta
 * Jun 19, 2016 3:33:07 PM
 */
public class WildCardMatching {

	public static int isMatch(String s, String p){
		if(p==null || p.length()==0){
			return s.length()==0? 1: 0;
		}
		char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        
		int patternUpdatedIndex = 0;
		boolean flag = true;
		for(int i = 0;i<pat.length; i++){
			if(pat[i] == '*'){
				if(flag){
					pat[patternUpdatedIndex++] = pat[i];
					flag = false;
				}
			}else{
				pat[patternUpdatedIndex++] = pat[i];
				flag = true;
			}
		}
		
		int m = s.length();
		int n = patternUpdatedIndex;//p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		
		if(n > 0 && pat[0] == '*')
			dp[0][1] = true;
		
		dp[0][0] = true;
		
		for(int i =1;i<=m;i++){
			for(int j=1; j<=n;j++){
				if(pat[j-1] == '?' || pat[j-1] == str[i-1])
					dp[i][j] = dp[i-1][j-1];
				else if(pat[j-1] == '*'){
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[m][n] ? 1 : 0;
		
	}
	public static void main(String[] args) {
		//A : "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		//B : "a**************************************************************************************"
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String p = "a********";
		System.out.println(isMatch(s, p));


	}

}
