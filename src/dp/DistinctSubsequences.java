package dp;

public class DistinctSubsequences {
	/*
	 * Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical 
	 * to the sequence T.
	 */
	public static void main(String[] args) {
		String a = "rabbbit";
		String b = "rabbit";
		System.out.println(numDistinct(a, b));
	}
	public static int numDistinct(String S, String T) {
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		 
		for (int i = 0; i < S.length(); i++)
			dp[i][0] = 1;
	 
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] += dp[i - 1][j];
				}
			}
		}
	 
		return dp[S.length()][T.length()];
	}
	/*http://stackoverflow.com/questions/20459262/distinct-subsequences-dp-explanation
	 * int numDistinct(string S, string T) {

	    vector<int> f(T.size()+1);
	
	    //set the last size to 1.
	    f[T.size()]=1;
	
	    for(int i=S.size()-1; i>=0; --i){
	        for(int j=0; j<T.size(); ++j){
	            f[j]+=(S[i]==T[j])*f[j+1];
	            printf("%d\t", f[j] );
	        }
	        cout<<"\n";
	    }
	    return f[0];
	}
	 */
}
