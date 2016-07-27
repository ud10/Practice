package backtracking;
import java.util.*;
public class SubsetsWithDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> a = new ArrayList<Integer>();
		
	}
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		Collections.sort(a);
		int n = a.size();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		
		for(int i = n-1; i>=0;i--){
			
			if (i == n - 1 || a.get(i) != a.get(i+1) || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
			
			for(ArrayList<Integer> temp : prev){
				temp.add(0, a.get(i));
			}
			if(i == n-1 || a.get(i) != a.get(i+1)){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(a.get(i));
				prev.add(temp);
			}
			for(ArrayList<Integer> temp : prev){
				result.add(new ArrayList<Integer>(temp));
			}
		}
		result.add(new ArrayList<Integer>());
		return result;
	}
}
