package DynamicProgramming;

public class LetsParty {
  public static void main(String[] args) {
      int result = solve(3);
      System.out.println("Result ->" +result);
  }

  static int[] dpArr;
  public static int solve(int A) {
    int ans = 0;
    int mod = 10003;
    dpArr = new int[A+1];
    ans = ways(A);
    return ans%mod;
  }

  public static int ways(int n){
    if(n <= 1){
      return 1;
    }
    if(dpArr[n] != 0){
      return dpArr[n];
    }
    int ans = ways(n-1) + (n-1) * ways(n-2);
    dpArr[n] = ans;
    return ans;
  }
}
