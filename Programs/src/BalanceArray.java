import java.util.ArrayList;

public class BalanceArray {
  public static void main(String[] args) {
    int[] arr = {5, 5, 2, 5, 8};
    int result = solve(arr);
    System.out.println("Result: "+ result);
  }

  public static int solve(int[] A) {
    int ans = 0;
    int n = A.length;
    //Compute LeftSum & RightSum Array
    int[] oddSumArr = new int[A.length];
    int[] evenSumArr = new int[A.length];
    int oddSum = 0, evenSum = 0;
    for(int i=0; i<A.length; i++){
      if(i%2 == 0){
        evenSum += A[i];
      }
      else{
        oddSum += A[i];
      }
      oddSumArr[i] = oddSum;
      evenSumArr[i] = evenSum;
    }

    for(int j=1; j<A.length;j++){
      int sumEven = evenSumArr[j-1]+ oddSumArr[n-1]-oddSumArr[j];
      int sumOdd = oddSumArr[j-1]+ evenSumArr[n-1]-evenSumArr[j];
      if(sumEven == sumOdd){
        ans++;
      }

    }

    if(evenSumArr[n-1]-oddSumArr[n-1]-A[0] == 0){
      ans++;
    }
    return ans;
  }
}
