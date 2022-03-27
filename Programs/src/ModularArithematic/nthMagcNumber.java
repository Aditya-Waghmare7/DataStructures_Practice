package ModularArithematic;

public class nthMagcNumber {
  public static void main(String[] args) {
      int result = solve(5);
      System.out.print("Result: "+result);
  }

  public static int solve(int A){
    int x = 1;
    int ans = 0;
    while(A > 0){
      x = x*5;
      if(A%2 == 1){
        ans += x;
      }
      A /= 2;
    }
    return ans;
  }
}
