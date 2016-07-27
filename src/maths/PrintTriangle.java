/**
 * 
 */
package maths;

/**
 * @author uditgupta
 * Jul 25, 2016 11:00:01 PM
 */
public class PrintTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printTriangle(5);
	}
	private static void printTriangle(int n){
	    int cur = 1;
	    for(int i = 1; i <=n; i++){
	      for(int j = 1; j <= n-i; j++){
	        System.out.print(" ");
	      }
	      for(int j = n-i+1; j <= n; j++){
	        System.out.print(cur+" ");
	        cur = (cur+1)%(n+2);
	        if(cur == 0)
	          cur = 1;
	      }
	      System.out.println();
	    }
	  }	 
}
