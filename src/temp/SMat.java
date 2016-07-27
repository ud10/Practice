/**
 * 
 */
package temp;

/**
 * @author uditgupta
 * Jun 9, 2016 10:51:33 PM
 */
public class SMat {
	static int[][] a = new int[100][100];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		func(2, 1, 0, 0);
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	public static void func(int n, int val, int i, int j){
		
		if(n>1){
			int p = (int) (Math.pow(2, n-1) * Math.pow(2, n-1));
			int k = (int) ((Math.pow(2, n))/2);
			func(n-1, val, i, j);
			func(n-1, val + p, i, j + k);
			func(n-1, val + p*2, i + k, j);
			func(n-1, val + p*3, i + k, j + k);
		}
		if(n==1){
			a[i][j] = val;
			a[i][j+1] = val+1;
			a[i+1][j] = val+2;
			a[i+1][j+1] = val+3;
			return;
		}
	}
}
