package bitManipulation;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(3));
	}
	public static long reverse(long a) {
	    for(int i=0;i<16;i++){
	        a = swap(a, i, 32-i-1);
	    }
	    return a;
	}
	private static long swap(long a, int i, int j){
	    long x = (a >> i) & 1l;
	    long y = (a >> j) & 1;;
	    if((x ^ y) != 0){
		    return a ^= (1l << i) | (1l << j);
	    }   
	    return a;
	}
}
