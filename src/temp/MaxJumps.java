/**
 * 
 */
package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author uditgupta
 * Jun 9, 2016 11:11:08 PM
 */
public class MaxJumps {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int tc = Integer.parseInt(line);
		for(int numTc = 0; numTc < tc; tc++){
			String size = br.readLine();
			int m = Integer.parseInt(size.split(",")[0]);
			int n = Integer.parseInt(size.split(",")[1]);
			
			int cards = Integer.parseInt(br.readLine());
			int[][] val = new int[cards][2];
			for(int i = 0; i<cards; i++){
				String s = br.readLine();
				val[i][0] = Integer.parseInt(s.split(",")[0]);
				val[i][1] = Integer.parseInt(s.split(",")[1]);
			}
			
			int jumps = 0;
			int a = 1, b = 1;
			int curX = a, curY = b; 
			for(int i = 0; i<cards; i++){
				while((curX + val[i][0] >= 0) && (curX + val[i][0] < m)
						&& (curY + val[i][1] >= 0 ) && (curY + val[i][1] < n)){
					curX += val[i][0]; curY += val[i][1];
					jumps++;
				}
			}
			System.out.println(jumps);
		}
	}

}
