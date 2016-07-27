/**
 * 
 */
package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author uditgupta
 * Jul 22, 2016 10:56:15 PM
 */
public class Task1 {

	public int solution(String E, String L) {
		String[] entry = E.split(":");
        String[] left = L.split(":");
        int h1 = Integer.parseInt(entry[0]);
        int m1 = Integer.parseInt(entry[1]);
        int h2 = Integer.parseInt(left[0]);
        int m2 = Integer.parseInt(left[1]);
        System.out.println(h1 +"--" + m1 + "--"+ h2+ "--" +m2);
        int t1 = h1*60 + m1;
        int t2 = h2*60 + m2;
        double diff = t2 - t1;
        double dH = Math.ceil(diff/60);
        System.out.println(diff + "---"+dH);
        int cost = 2;
        if(dH > 0)
        	cost += 3;
        if(dH-1 > 0)
        	cost += dH-1;
        
		return cost;
    }
	public static void main(String[] args) throws Exception{
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        String s = br.readLine();
//	        int n = Integer.parseInt(s);
//	        int[] rating = new int[n];
	        String s = "10:03";
	        String e = "13:42";
	    	String[] st = s.split(":");
	        String[] en = e.split(":");
	        int h1 = Integer.parseInt(st[0]);
	        int m1 = Integer.parseInt(st[1]);
	        int h2 = Integer.parseInt(en[0]);
	        int m2 = Integer.parseInt(en[1]);
	        System.out.println(h1 +"--" + m1 + "--"+ h2+ "--" +m2);
	        int t1 = h1*60 + m1;
	        int t2 = h2*60 + m2;
	        double diff = t2 - t1;
	        diff = 40;
	        double dH = Math.ceil(diff/60);
	        System.out.println(diff + "---"+dH);
	        
	}

}
