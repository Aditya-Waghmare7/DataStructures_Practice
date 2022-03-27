package BinarySearch;

public class SpecialInteger {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,100};
    int result = solve(arr,10);
    System.out.println("Result : " + result);
  }

  public static int solve(int[] A, int B){
    int min = A.length;
    int n = A.length;

    int curSum = 0;
    int start=0, end=0;
    if(n==1){
      return A[0];
    }

    while(end<n){
      curSum += A[end];
      while (curSum > B && start<=end){
        min = Math.min(min, end-start);
//        if(start == end){
//          min += 1;
//        }
        curSum -= A[start];
        start++;
      }
      end++;
    }


    return min;
  }
}
