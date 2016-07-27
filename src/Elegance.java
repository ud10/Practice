import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Elegance {
	/*
	 * BlackBuck - Lexicographically smallest path in a maze
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        int[][] a = new int[n][m];
        for(int i =0;i<n;i++){
        	 String input = br.readLine();
        	 for(int j=0;j<m;j++){
        		 String[] val = input.split(" ");
        		 a[i][j] = Integer.parseInt(val[j]);
        	 }
        }
        elegant(a);
	}
	public static void elegant(int[][] a){
		
	}
	/*
	 * string solve(int i, int j){
    if (i == N && j == M) return a[i][j];       //-- if we have reached the buttom right cell (I assumed the array is 1-indexed
    if (calculated[i][j]) return f[i][j];       //-- if we have calculated this before 
    string ans;
    if (i == N) ans = srt(a[i][j] + solve(i, j + 1));       //-- if we are at the buttom boundary
    else if (j == M) ans = srt(a[i][j] + solve(i + 1, j));  //-- if we are at the right boundary
    else ans = srt(a[i][j] + smallest(solve(i, j + 1), solve(i + 1, j)));       
    calculated[i][j] = true;        //-- to fetch the calculated result in future calls
    f[i][j] = ans;
    return ans;
}f(i, j) = sort( a(i, j) + smallest(f(i + 1, j), f(i, j + 1)))
string a[200][200];             //-- represent the input grid
string f[200][200];             //-- represent the array used for memoization
bool calculated[200][200];      //-- false if we have not calculate the value before, and true if we have
int N = 199, M = 199;           //-- Number of rows, Number of columns


//-- sort the string str and return it
string srt(string &str){
    sort(str.begin(), str.end());
    return str;
}


//-- return the smallest of x and y
string smallest(string & x, string &y){
    for (int i = 0; i < x.size(); i++){
        if (x[i] < y[i]) return x;
        if (x[i] > y[i]) return y;
    }
    return x;
}
	 */
}
