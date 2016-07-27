package dp;
import java.util.ArrayList;
public class MinJumpsII {
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);a.add(3);a.add(1);a.add(1);a.add(4);
	    int jump = minJumps(a);
	    System.out.print(jump);
	}
	public static int minJumps(ArrayList<Integer> a){
		if(a.size() == 0)
			return 0;
		int minNumberOfJumps = 0;
		int curReachableIndexAfterJump = 0;
		int lastReachableIndexAfterJump = 0;
		for(int i=0;i<= curReachableIndexAfterJump && i< a.size();i++){
			if(i > lastReachableIndexAfterJump){
				minNumberOfJumps++;
				lastReachableIndexAfterJump = curReachableIndexAfterJump;
			}
			curReachableIndexAfterJump = Math.max(curReachableIndexAfterJump, i+a.get(i));
		}
		if(curReachableIndexAfterJump < a.size()-1)
			return 0;
		return minNumberOfJumps;
	}
}
