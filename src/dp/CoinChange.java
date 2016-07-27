package dp;
import java.util.*;
public class CoinChange {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		//A : [ 18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 ]
		//B : 458 ==> 867621
		//a.add(1);a.add(2);a.add(3);
		a.clear();
		a.add(18);a.add(24);a.add(23);a.add(10);a.add(16);a.add(19);a.add(2);
		a.add(9);a.add(5);a.add(12);a.add(17);a.add(3);a.add(28);a.add(29);a.add(4);a.add(13);
		a.add(15);a.add(8);
		int b = 458;
		int coin = coinchange2(a,b);
		System.out.println(coin);
	}
	public static int coinchange2(ArrayList<Integer> a, int b) {
        int m = a.size();
        int table[] = new int[b+1];
        for(int i=0;i<table.length;i++)
            table[i] = 0;
        table[0] = 1;
        for(int i=0; i<m; i++){
            for(int j=a.get(i); j<=b; j++){
                table[j] += table[j-a.get(i)];
            }
        }
        return table[b];
    }
}
