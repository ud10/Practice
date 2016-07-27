/**
 * 
 */
package temp;

/**
 * @author uditgupta
 * Jul 23, 2016 12:25:35 AM
 */
public class Task2 {

	public static int solution(int[] A){
		int oneDay= 0; 
		int sevenDays= 0;
		int minCost = 0;
		int range = 0;
		int consecutiveDays = 0;
		boolean flag = false;

		for(int i=0; i<A.length; i++){
			if(flag==true){
				sevenDays++;
				break;
			}
			oneDay++;
			consecutiveDays = 0;
			range = A[i] + 7;
			for(int j=i+1; j<A.length ;j++){
				if( A [j] < range && consecutiveDays >= 3 && (A.length-1) == j)
					flag = true;
				if(A[j]<range)
					consecutiveDays++;
				else{
					if(consecutiveDays>3){
						sevenDays++;
						consecutiveDays = 0;
						i = j-1;
					}else
						consecutiveDays = 0;
					break;
				}
			}
		}
		oneDay = oneDay-sevenDays;
		minCost = (oneDay * 2)+(sevenDays * 7);

		return minCost<25 ? minCost : 25;
	}
	public static void main(String[] args) {
		int[] A = {1,2,4,5,7,29,30};
		System.out.println(solution(A));

	}

}
