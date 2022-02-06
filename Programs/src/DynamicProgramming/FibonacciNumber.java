package DynamicProgramming;

import java.util.Scanner;

public class FibonacciNumber {
  public static void main(String[] args) {
    Scanner sr = new Scanner(System.in);
    Integer n = Integer.parseInt(sr.nextLine());
    Integer ans = fibo(n);
    System.out.print(ans);

  }

  public static Integer fibo(Integer n){
    if(n == 0){
      return 0;
    }
    else if(n == 1){
      return 1;
    }
    else{
      return fibo(n-1)+ fibo(n-2);
    }
  }
}
