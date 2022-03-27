package Maths;

public class ModSum {
  public static void main(String[] args) {
    int[] arr = {17, 100, 11};
    int result = solve(arr);
    System.out.println("Result --> "+ result);
  }

  public static int solve(int[] A) {
    int ans = 0;
    int mod = 1000000007;
    int[] count = new int[1001];
    for(int i: A){
      count[i] = count[i]+1;
    }
    for(int i=1; i<=1000; i++){
      for(int j=1; j<=1000; j++){
        int val = i%j;
        int temp = count[i] * count[j] * val;
        ans = ((ans%mod) + (temp%mod))%mod;
      }
    }
    return ans;
  }
}
