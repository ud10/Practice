package string;

public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "147573952589676412928";
		System.out.println(power(a));
	}
	public static int power(String a) {
//	    long x = Long.parseLong(a);
//	    if((x & x-1) == 0 && x != 0)
//	        return 1;
//	    return 0;
		Double x = Double.parseDouble(a);
		if(x <= 0)
			return 0;
		while(x != 1){
//			if((x%10)%2 != 0)
//				return 0;
			x = x/2;
			if(x == 1)
				return 1;
			else return 0; 
				
		}
		return 1;
	}
}
