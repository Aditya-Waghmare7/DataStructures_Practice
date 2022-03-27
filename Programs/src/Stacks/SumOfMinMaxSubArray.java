package Stacks;

public class SumOfMinMaxSubArray {
  public static void main(String[] args) {
    int[] arr = {};
    int B = 0;

  }

  public static int solve(int[] A, int B){
    //Sliding Window Approach
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i=0; i<B; i++){
      max = Math.max(max,A[i]);
      min = Math.min(min, A[i]);
    }
    int ans = max-min;
    for(int j=B; j<A.length-B; j++){

    }
    return ans;
  }


}
