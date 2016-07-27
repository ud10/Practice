package arrays;
import java.util.*;
public class NextPermutation {

	public static void main(String[] args) {

	}
	public void nextPermutation(ArrayList<Integer> a) {
	    int n = a.size();
		if(n<2)
			return;
		int p = 0;
		for(int i=n-2;i>=0;i--){
			if(a.get(i) < a.get(i+1)){
				p=i;break;
			}
		}
		int q = 0;
		for(int i=n-1;i>p;i--){
			if(a.get(i) > a.get(p)){
				q = i; break;
			}
		}
		if(p==0 && q==0){
	        Collections.reverse(a);
	        return;
	    }
		int temp=a.get(p);
		a.add(p, a.get(q));
	    a.add(q, temp);
	    
	    if(p<n-1){
	        reverse(a, p+1);
	    }
	}
	public static void reverse(ArrayList<Integer> list, int s) {
	    for(int i = s, j = list.size() - 1; i < j; i++) {
	        list.add(i, list.remove(j));
	    }
	    return;
	}
}
