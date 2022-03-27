import java.util.Arrays;

public class MaxDiffSubset {
  public static void main(String[] args) {
      int[] arr = {70, 21, 7, 64, 44, 79, 50, 89, 68, 23, 20, 50, 65, 64, 48, 3, 46, 87};
      int result = solve(arr,16);
      System.out.println("Result--> "+ result);
  }

  public static int solve(int[] A, int B) {
    //Arrays.sort(A);
    int sum1= 0, sum2=0;
    //Less Sum
    for(int i=0; i<A.length; i++){
      if(i < B){
        sum1 -= A[i];
      }
      else{
        sum1 += A[i];
      }
    }
    for(int j=A.length-1; j>=0; j--){
      if(j >= B){
        sum2 -= A[j];
      }
      else{
        sum2 += A[j];
      }
    }
    int res= Math.max(Math.abs(sum1),Math.abs(sum2));
    return res;
  }
}

