package bitManipulation;

public class DivideIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int divide(int dividend, int divisor) {
	    long sign = 1;
        if(dividend<0)
            sign = -sign;
        if(divisor<0)
            sign = -sign;
         
        long tmp = Math.abs((long)dividend);
        long tmp2 = Math.abs((long)divisor);
        long c = 1;
        while(tmp>tmp2){
            tmp2 = tmp2<<1;    
            c = c<<1;
        }
        long res = 0;
        while(tmp >= Math.abs((long)divisor)){
            while(tmp >= tmp2){
                tmp -= tmp2;
                res = res+c;
            }
            tmp2 = tmp2>>1;
            c = c>>1;    
        }
        return (int) (sign*res);
	}

}
