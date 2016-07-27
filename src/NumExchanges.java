
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
public class NumExchanges {
	    public static void main(String args[] ) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int tc = Integer.parseInt(line);
	        for (int i = 0; i < tc; i++) {
	            String NK = br.readLine();
	            String N = NK.split(" ")[0];
	            String K = NK.split(" ")[1];
	            int n = Integer.parseInt(N);
	            int k = Integer.parseInt(K);
	            String Time = br.readLine();
	            String[] strArray = Time.split(" ");	           
				int[] time = new int[n];
				int[] numRounds = new int[n];
				for(int x = 0; x < n; x++) {
				    time[x] = Integer.parseInt(strArray[x]);
				    numRounds[x] = k/time[x];
				}
	        	int numExchanges = 0;
	        	for(int y =0;y<n;y++){
	        		for(int j =y+1;j<n;j++){
	        			if(numRounds[y] != numRounds[j])
	        				numExchanges += numRounds[y] - numRounds[j];
	        		}
	        	}
	    		System.out.println(numExchanges);
	        }
	    }
}
