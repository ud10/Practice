package dp;
import java.util.*;
public class WordBreak {

	public static void main(String[] args) {

	}
	public int wordBreak(String a, ArrayList<String> b) {
		int n = a.length();
		if(a == null || n == 0){
	    	return 1;
	    }
	    boolean[] isValid = new boolean[n];
	    for(int i=0;i<n;i++){
	    	if(b.contains(a.substring(0, i+1))){
	    		isValid[i] = true;
	    	}
	    	if(isValid[i]){
	    		for(int j=i+1;j<n;j++){
	    			if(b.contains(a.substring(i+1, j+1))){
		    			isValid[j] = true;
		    		}
	    			if(j==n-1 && isValid[j]==true){
	    				return 1;
	    			}
	    		}
	    	}
	    }
	    return 0;
	}
	public int wordBreak2(String a, ArrayList<String> b) {
	    int n = a.length();
	    if(a == null || n == 0){
	    	return 1;
	    }
	    boolean[] t = new boolean[n+1];
        t[0] = true;
        for(int i=0; i<n; i++){
            if(!t[i]) 
                continue;
            for(String c: b){
                int len = c.length();
                int end = i + len;
                if(end > n)
                    continue;
                if(t[end]) continue;
                if(a.substring(i, end).equals(c)){
                    t[end] = true;
                }
            }
        }
        return t[n]?1:0;
	}
}
