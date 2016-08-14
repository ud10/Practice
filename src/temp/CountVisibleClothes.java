/**
 * 
 */
package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author uditgupta
 * Aug 1, 2016 12:28:36 AM
 */
class Cloth{
	int start;
	int end;
	Cloth(int s, int e){
		start = s;
		end = e;
	}
}
public class CountVisibleClothes {

	public static void main(String[] args) {	
		//int[][] input3 = {{0,4},{6,3},{1,5},{6,4},{7,2}};
		int[][] input3 = {{0,4},{6,3},{1,5},{6,4},{7,2},{2,2}};
		//int[][] input3 = {{0,4},{1,5},{7,3},{2,2},{6,4}};
		System.out.println(GetVisibleCount(10,6,input3));
	}
	public static int GetVisibleCount(int input1,int input2,int[][] input3){
		if(input2 == 0){
			return 0;
		}
		ArrayList<Cloth> clothesList = new ArrayList<Cloth>();
		for(int i = 0; i<input3.length; i++){
			Cloth c = new Cloth(input3[i][0], input3[i][0] + input3[i][1]);
			clothesList.add(c);
		}
//		Collections.sort(clothesList, new Comparator<Cloth>(){
//	        public int compare(Cloth c1, Cloth c2){
//	            if(c1.start != c2.start)
//	                return c1.start-c2.start;
//	            else
//	                return c1.end-c2.end;
//	        }
//	    });
//		int visibleCount = 1;
//		for(int i = 1; i<clothesList.size(); i++){
//			if(clothesList.get(i).end >= clothesList.get(i-1).end){
//				visibleCount++;
//			}
//		}
		int visibleCount = input2;
		for(int i = 0; i<clothesList.size(); i++){
			for(int j = i+1; j<clothesList.size(); j++){
				if(clothesList.get(j).end >= clothesList.get(i).end && 
				   clothesList.get(j).start <= clothesList.get(i).start){
					visibleCount--;
				}
			}
		}
		return visibleCount;
		//throw new UnsupportedOperationException("GetVisibleCount(int input1,int input2,int[][] input3)");
	}
}
