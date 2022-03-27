package Maths;

public class PairSumDivisible {
  public static void main(String[] args) {
    int[] arr = {93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49};
    int[] arr1 = {1, 2, 3, 4, 5};
    int val = 37;
    int result = solve(arr,val);
    System.out.println("Result: " + result);
  }

  public static int solve(int[] A, int B) {
    int n = A.length;
    int[] count = new int[B];
    int mod = 1000000007;
    for(int i=0; i<n; i++){
      count[A[i]%B]++;
    }
    int ans = (count[0]*(count[0]-1))/2;
    int i=1, j=B-1;
    while(i <= j){
      ans = ans%mod;
      if( i == j ){
        ans += Math.abs((count[i]*(count[j]-1))/2);
        //ans = ans%mod;
      }
      else{
        ans += count[i]*count[j];
        //ans = ans%mod;
      }
      i++;
      j--;
    }
    return ans;
  }
}
