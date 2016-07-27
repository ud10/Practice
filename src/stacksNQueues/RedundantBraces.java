package stacksNQueues;
import java.util.*;
public class RedundantBraces {
	/*
	 * Write a program to validate if the input string has redundant braces? Return 0/1 
	 */
	public static void main(String[] args) {
		String x = "((a+b))";
		System.out.println(braces(x));
	}
	public static int braces(String a) {
	    if(a==null || a.length() == 0){
	        return 0;
	    }
	    Stack<Character> st = new Stack<Character>();
        int i = 0;
        while(i<a.length()){
            char c = a.charAt(i);
            if(c == '(' || c =='+' || c == '*' || c == '/' || c =='-') 
                st.push(c);
            else if(c == ')'){
                if(st.peek() == '(') return 1;
                else{
                    while(!st.isEmpty() && st.peek()!= '(') 
                        st.pop();
                    st.pop();
                }
            }
            i++;
        }
        return 0;
	}

}
