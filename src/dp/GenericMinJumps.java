package dp;

public class GenericMinJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int steps(int startCity, int endCity, int step){
		if ((startCity) > (endCity))  
			return Integer.MAX_VALUE;
	    if (startCity == endCity)     
	    	return step;
	    int pos = steps(startCity+step+1, step+1, endCity);
	    int neg = steps(startCity-step-1, step+1, endCity);
	 
	    return Math.min(pos, neg);
	}

    static int find_minimum_direct_trains(int startCity, int endCity, int[] range) {
        if(range.length == 0)
	       return 0;
        int min_train = 0;
        int cur_train_forward = 0;
        int cur_train_backward = 0;
        int last_train = 0;
        for(int i=startCity;i<= cur_train_forward && i<endCity;i++){
            if(i > last_train){
                min_train++;
                last_train = cur_train_forward;
            }
            cur_train_forward = Math.max(cur_train_forward, i+range[i]);
        }
        for(int i=startCity;i<= cur_train_backward && i>endCity;i--){
            if(i > last_train){
                min_train++;
                last_train = cur_train_backward;
            }
            cur_train_backward = Math.max(cur_train_backward, i+range[i]);
        }
        int cur_train = Math.min(cur_train_backward, cur_train_forward);
        if(cur_train < range.length - 1)
            return 0;
        return min_train;
    }
	}

