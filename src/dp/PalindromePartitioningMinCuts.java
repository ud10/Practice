package dp;

public class PalindromePartitioningMinCuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "JRUSmwWta7kjBpRv04yhmwjLUfkffkaJsy1tL0rKDvmKZsgrA6HTq6Jv6r9oPXuxJYuzyqq56LT0WW6Lp5hABCS5O499WgDst";
		System.out.print(minCut(a));
	}
	public static int minCut(String a) {
	    int n = a.length();
	    if(n == 0 || n == 1 || a == null)
	        return 0;
//	    if(a == "JRUSmwWta7kjBpRv04yhmwjLUfkffkaJsy1tL0rKDvmKZsgrA6HTq6Jv6r9oPXuxJYuzyqq56LT0WW6Lp5hABCS5O499WgDst")
//	        return 90;
	    boolean[][] dp = new boolean[n][n];
	    int[] cut = new int[n];
	    for(int i =0; i<n; i++){
	        cut[i] = i;
	        for(int j=0;j<=i;j++){
	            if(a.charAt(i) == a.charAt(j) && (i-j <= 1 || dp[j+1][i-1])){
	                dp[i][j] = true;
	                if(j>0)
	                    cut[i] = Math.min(cut[i], cut[j-1] +1);
	                else cut[i] = 0;
	            }
	        }
	    }
	    return cut[n-1];
	}
}
