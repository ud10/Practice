package stacksNQueues;
import java.util.*;
public class evalRPN {
	public static void main(String args[]){
		ArrayList<String> a = new ArrayList<String>();
		//a.add("2");a.add("1");a.add("+");a.add("2");a.add("*");
		a.add("2");a.add("2");a.add("/");
		Stack<String> s = new Stack<String>();
        for(int i=0;i<a.size();i++){
            String cur = a.get(i);
            if(cur != "+" && cur != "-" && cur != "*" && cur != "/"){
                s.push(cur);
            }
            else{
                int x = Integer.parseInt(s.pop());
                int y = Integer.parseInt(s.pop());
                int z = 0;
                switch(cur){
                    case "+":
                        z = y+x; break;  
                    case "-":
                        z = y-x; break;  
                    case "*":
                        z = y*x; break;
                    case "/":
                        z = y/x; break;
                    default: break;
                }
                System.out.println("Z is: "+z);
                s.push(Integer.toString(z));
            }
        }
        System.out.println(Integer.parseInt(s.pop()));
	}
}
