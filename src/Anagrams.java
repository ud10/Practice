import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
	/*
	 * FormZero(maybe)
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            String s1 = S.split(" ")[0];
            String s2 = S.split(" ")[1];
           
            HashMap<Character, Integer> hm = new  HashMap<Character, Integer>();
            for(int j =0;j<s1.length();j++){
            	char c = s1.charAt(j);
            	if(!hm.containsKey(c)){
            		hm.put(c, 1);
            	}else{
            		int count = hm.get(c);
            		hm.put(c, count+1);
            	}
            }
            for(int j=0;j<s2.length();j++){
            	char q = s2.charAt(j);
            	if(hm.containsKey(q)){
            		int occ = hm.get(q);
            		hm.put(q, occ-1);
            	}
            }
            Iterator<Entry<Character, Integer>> it = hm.entrySet().iterator();
            int flag = 0;
            while (it.hasNext()) {
                @SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry)it.next();
                int val =  (int) pair.getValue();
                if(val != 0){
            		System.out.println("NO");
            		flag = 1;break;
            	}
                it.remove();
            }
            if(flag!=1)
            	System.out.println("YES");
        }
	}

}
