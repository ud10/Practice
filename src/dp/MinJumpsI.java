package dp;
import java.util.*;
public class MinJumpsI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);a.add(2);a.add(1);a.add(0);a.add(4);
	    boolean jump = canJump(a);
	    System.out.print(jump);
	}
	public static boolean canJump(ArrayList<Integer> a){
		if(a.size() <=1)
			return true;
		int maxReachableIndexAfterJump = a.get(0);
		for(int i=0;i<a.size();i++){
			if(maxReachableIndexAfterJump<=i && a.get(i)==0)
				return false;
			if(i+a.get(i) > maxReachableIndexAfterJump)
				maxReachableIndexAfterJump = i+a.get(i);
			if(maxReachableIndexAfterJump >= a.size()-1)
				return true;
		}
		return false;
	}
}
