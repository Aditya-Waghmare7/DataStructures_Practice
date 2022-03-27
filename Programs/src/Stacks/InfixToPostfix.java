package Stacks;

import java.util.Stack;

public class InfixToPostfix {
  public static void main(String[] args) {
    String str = "x^y/(a*z)+b";
    String result = solve(str);
    //xy^az*/b+
    System.out.println("Result: "+ result);
  }

  public static String solve(String A) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for(char c: A.toCharArray()){
      if((int)c >= 97 && (int)c <=122){
        sb.append(c);
      }
      else if(c == '('){
        stack.push(c);
      }
      else if(c == ')'){
        while(!stack.isEmpty() && stack.peek() == '('){
          sb.append(stack.pop());
        }
        //stack.pop();
        sb.append(stack.pop());
        //stack.pop();
      }
      else if(c == '^' || c == '+' || c == '-' || c == '/' || c == '*') {
        if(stack.isEmpty() || stack.peek() == '('){
          stack.push(c);
        }
        else{
          while(!stack.isEmpty() && checkPreference(stack.peek(),c)){
            sb.append(stack.pop());
          }
          stack.push(c);
        }
      }
    }
    while(stack.isEmpty()){
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  private static boolean checkPreference(char c1, char c2){
    switch (c1){
      case ('^'): if(c2 == '^')
                  return true;
      case('/'): if(c2 == '^' || c2 == '*' || c2 == '/')
                  return true;
      case('*'): if(c2 == '^' || c2 == '*' || c2 == '/')
                   return true;
      case('+'): if(c2 == '+' || c2 =='-')
                    return true;
      case('-'): if(c2 == '+' || c2 =='-')
                     return true;
    }
    return false;
  }
}
