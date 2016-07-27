/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author uditgupta
 * May 30, 2016 1:34:51 AM
 */
class Interval {
      int start;
      int end;
      Interval(){ 
    	 start = 0; end = 0; 
      }
      Interval(int s, int e){ 
    	  start = s; end = e; 
      }
}
public class MergeIntervals {

	public static void main(String[] args) {

	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		intervals.add(newInterval);
		if(intervals==null||intervals.size()==0)
	        return result;
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				if(i1.start != i2.start)
					return i1.start - i2.start;
				else 
					return i1.end - i2.end;
			}
		});
		Interval pre = intervals.get(0);
		for(int i = 0;i<intervals.size(); i++){
			Interval cur = intervals.get(i);
			if(cur.start > pre.end){
				result.add(pre);
				pre = cur;
			}else{
				Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merged;
			}
		}
		result.add(pre);
		return result;
	}
}
