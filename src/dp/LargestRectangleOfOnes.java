package dp;
import java.util.*;
public class LargestRectangleOfOnes{
	public static void main(String[] args){
		char[][] x = {
						{'1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
						{'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1'},
						{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1'},
						{'1', '1', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '0', '1', '0'},
						{'1', '0', '1', '1', '0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '1'},
						{'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1'},
						{'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '0', '0', '0', '1', '0', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0', '1'}
				     };
		int area = maximalRectangle(x);
		System.out.println(area);
	}
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int[][] height = new int[m][n + 1];
	 
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
				}
			}
		}
	 
		for (int i = 0; i < m; i++) {
			int area = maxAreaInHist(height[i]);
			if (area > maxArea) {
				maxArea = area;
			}
		}
	 
		return maxArea;
	}
	 
	private static int maxAreaInHist(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
	 
		int i = 0;
		int max = 0;
	 
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				max = Math.max(max, height[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		while(!stack.empty()){
			int top = stack.pop();
			int h = height[top];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h*w);
		}
		return max;
	}
}
/*
 *    int ROW = a.size();
    	 int COL = ROW == 0 ? 0 : a.get(0).size();
         int i, j;  
         int max, cur_max;  
         cur_max = 0;
         for(i=1; i<ROW; i++){
             for(j=0; j<COL; j++){  
                 if(a.get(i).get(j) == 1)  
                     a.get(i).set(j, a.get(i-1).get(j) + 1);  
            }
         }
         for(i=0; i<ROW; i++){       
             max = largestArea(a.get(i), COL);  
             if (max > cur_max)  
                 cur_max = max;  
         }  
        //  for(i=ROW-1; i>0; i--){
        //      for(j=0; j<COL; j++){  
        //          if(A[i][j])  
        //              A[i][j] = A[i][j] - A[i-1][j];  
        //      }  
        //  }
         return cur_max;  
    }  
    int largestArea(ArrayList<Integer> arr, int len){  
        int[] area = new int[len];
        int n, i, t;  
        Stack<Integer> St = new Stack<Integer>();
        boolean done;  
        for(i=0; i<len; i++){  
            while (!St.empty()){  
                if(arr.get(i) <= arr.get(St.peek())){  
                    St.pop();  
                }  
                else  
                    break;  
            }  
                if(St.empty())  
                    t = -1;  
                else  
                    t = St.peek();  
                area[i] = i - t - 1;  
                St.push(i);  
        }  
        while (!St.empty())
            St.pop();  
        for (i=len-1; i>=0; i--){  
            while (!St.empty()){  
                if(arr.get(i) <= arr.get(St.peek())){  
                    St.pop();  
                }  
                else  
                    break;  
            }  
            if(St.empty())  
                t = len;  
            else  
                t = St.peek();  
            area[i] += t - i -1;  
            St.push(i);  
        }  
          
        int max = 0;  
        for (i=0; i<len; i++){  
            area[i] = arr.get(i * (area[i] + 1));  
            if (area[i] > max)  
                max = area[i];  
        }  
        return max;  
    }  
 */
