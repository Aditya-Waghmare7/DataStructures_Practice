package Stacks;

import java.util.Stack;

public class BalancedParenthesis {

  public static void main(String[] args) {
      String str = "{([]}";
      int result = solve(str);
      System.out.print("Result -->" + result);
  }

  public static int solve(String A) {

    Stack<Character> stack = new Stack();
    for(char c: A.toCharArray()){
      if(c == '{' || c== '(' || c == '['){
        stack.push(c);
      }
      else if(c == '}' || c== ')' || c == ']'){
       if(stack.isEmpty()){
         return 0;
       }
       else if(c == '}' && stack.peek() == '{'){
         stack.pop();
       }
       else if(c == ')' && stack.peek() == '('){
         stack.pop();
       }
       else if(c == ']' && stack.peek() == '['){
         stack.pop();
       }
      }
    }
    if(stack.isEmpty()){
      return 1;
    }
    return 0;
  }
}
