package Stacks;

import java.util.Stack;

public class RedundantBraces {
  public static void main(String[] args) {
      String s = "(a+(a+b))";
      int ans = braces(s);
      System.out.print("Answer:: "+ans);
  }

  public static int braces(String A) {
      int result = 1;
      char[] charArr = A.toCharArray();

      Stack<Character> stack = new Stack<>();
      for(char c: charArr){
        if( c == '('){
          stack.push(c);
        }
        if(c == '+' || c=='-' || c=='*'|| c=='/' ){
          stack.push(c);
        }
        if(c == ')'){
          char c1 = stack.peek();
          if(c1 == '+' || c1=='-' || c1=='*'|| c1=='/'){
            stack.pop();
            stack.pop();
          }
          else{
            return 0;
          }
        }

    }

    return result;
  }
}
