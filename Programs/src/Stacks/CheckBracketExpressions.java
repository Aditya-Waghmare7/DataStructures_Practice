package Stacks;

import java.util.Stack;

public class CheckBracketExpressions {
  public static void main(String[] args) {
    String s1 = "-(a+b+c)";
    String s2 = "-a-b-c";
    int result = solve(s1,s2);
    System.out.println("Result: "+ result);
  }

  public static int solve(String A, String B) {
    int[] arr1 = evaluate(A);
    int[] arr2 = evaluate(B);
    for(int i=0; i<26; i++){
      if(arr1[i] != arr2[i]){
        return 0;
      }
    }
    return 1;
  }

  public static int[] evaluate(String s){
    Stack<Boolean> stack = new Stack<>();
    stack.push(true);
    int[] arr = new int[26];
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == '+' || s.charAt(i) == '-'){
        if(s.charAt(i) == '+'){
          stack.push(true);
        }
        else{
          stack.push(false);
        }
        continue;
      }
      if(s.charAt(i) == '('){
        if(i>0 && s.charAt(i - 1) == '+'){
          stack.push(stack.peek());
        }
        else{
          stack.push(!stack.peek());
        }
      }
      else if(s.charAt(i) == ')'){
        stack.pop();
      }
      else{
        if(stack.peek()){
          arr[s.charAt(i)-'a'] = adjSign(s.charAt(i-1));
        }
        else{
          arr[s.charAt(i)-'a'] = reverse(adjSign(s.charAt(i-1)));
        }
      }
    }
    return arr;
  }

  public static int adjSign(char c){
    if(c == '+'){
      return 1;
    }
    else{
      return 0;
    }
  }

  public static int reverse(int i){
    if(i == 1){
      return 0;
    }
    return 1;
  }
}
