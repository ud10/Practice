package maths;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(3, 4));
		System.out.println(ipow(3, 4));
	}
	public static int pow(int x, int n){
		if(n<0)
			return 1/power(x, -n);
		else
			return power(x,n);
	}
	private static int power(int x, int n){
		if(n==0)
			return 1;
		int y = power(x, n/2);
		if(n%2 == 0)
			return y*y;
		else
			return y*y*x;
	}
	private static int ipow(int base, int exp)
	{
	    int result = 1;
	    while (exp != 0)
	    {
	        if ((exp & 1) == 1)
	            result *= base;
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}

}
