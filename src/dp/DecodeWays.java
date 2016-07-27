package dp;

public class DecodeWays {

	public static void main(String[] args) {
		String a = "12";
		System.out.println(numDecodings(a));
	}
	public static int numDecodings(String a) {
		if(a == null || a.length() == 0 || a.equals('0'))
			return 0;
		int[] t = new int[a.length() +1];
		t[0] = 1;
		if(isValid(a.substring(0,1)))
			t[1] = 1;
		else t[1] = 0;
		//System.out.println(t[0]);
		//System.out.println(t[1]);
		for(int i = 2; i<a.length(); i++){
			if(isValid(a.substring(i-1, i)))
				t[i] += t[i-1];
			if(isValid(a.substring(i-2, i)))
				t[i] += t[i-2];
		}
		return t[a.length()];
	}
	public static boolean isValid(String s){
		//System.out.println(s);
		if(s.charAt(0) == '0')
			return false;
		int val = Integer.parseInt(s);
		return val >= 1 && val <= 26;
	}
}
