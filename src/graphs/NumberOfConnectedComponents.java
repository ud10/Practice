package graphs;
import java.util.*;
public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String r1 = "OOOXOOO";
		String r2 = "OOXXOXO";
		String r3 = "OXOOOXO";
//		String r1 = "XXOO";
//		String r2 = "XXXO";
//		String r3 = "OXXO";
//		String r4 = "OOOX";
		
		ArrayList<String> a = new ArrayList<String>();
		a.add(r1);a.add(r2);a.add(r3);//a.add(r4);
		System.out.println("No. of connected components are: "+ black(a));
	}
	public static int black(ArrayList<String> a) {
		if(a.size() == 0)   
    	    return 0;
		int rows = a.size();
		int cols = a.get(0).length();
		char[][] grid = new char[rows][cols];
		for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j] = a.get(i).charAt(j);
            }
        }
		int count=0;
		for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 'X'){
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
	}
	public static void merge(char[][] grid, int i, int j) {
		 if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1)
		        return;
        if(grid[i][j] != 'X')  
        	return;
        grid[i][j] = '0';
        merge(grid, i+1, j);merge(grid, i-1, j);
        merge(grid, i, j+1);merge(grid, i, j-1);
    }
}
