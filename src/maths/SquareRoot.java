/**
 * 
 */
package maths;

/**
 * @author uditgupta
 * Jun 20, 2016 10:08:37 PM
 */
public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 16;
		for(int i = 0; i*i <= n; i++){
			if(i*i == n)
				System.out.println(i);
		}
		System.out.println("done");
		n = 15;
		System.out.println(squareRoot(n));
	}
	
	public static double squareRoot(int n){
		double start = 0;
		double end = n;
		double mid = (start+end)/2;
		double prevMid = 0;
		double diff = Math.abs(mid - prevMid);
		double precision = 0.0005;
		
		while(mid * mid != n && diff > precision){
			if(mid*mid > n)
				end = mid;
			else 
				start = mid;
			prevMid = mid;
			mid = (start + end)/2;
			diff = Math.abs(mid -prevMid);
		}
		return mid;
	}
	public static double sqrt(int number) {
		double t;
	 
		double squareRoot = number / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
}
