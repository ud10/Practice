
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Sherlock {
	/*
	 * BlackBuck - Subset Sum Problem
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            int size = Integer.parseInt(S);
            
            String C = br.readLine();
            String[] val = C.split(" ");
            int[] cost = new int[size];
            int sum = 0;
            for (int j = 0; j < size; j++){
            	cost[j] = Integer.parseInt(val[j]);
            	sum += cost[j];
            }
            if(sum%2 != 0){
            	System.out.println("NO");
            }else{
	            boolean[][] dp = new boolean [sum/2 + 1][size+1];
	            
	            for(int p = 0; p<=sum/2; p++){
	            	dp[p][0] = false;
	            }
	            for(int p = 0; p<=size; p++){
	            	dp[0][p] = true;
	            }
	            for(int p =1;p<=sum/2; p++){
	            	for(int q =1;q<=size; q++){
	            		 dp[p][q] = dp[p][q-1];
	 	                if(p >= cost[q-1])
	 	                    dp[p][q] = dp[p][q] || dp[p - cost[q-1]][q-1];
	            	}
	            }
	            if(dp[sum/2][size] == true){
	            	System.out.println("YES");
	            }else
	            	System.out.println("NO");
            }
        }
	}

}
