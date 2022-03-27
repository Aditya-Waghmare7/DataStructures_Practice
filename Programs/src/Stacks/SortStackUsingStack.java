package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortStackUsingStack {
  public static void main(String[] args) {
    int[] arr = {66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12 };
    int[] result = solve(arr);
    for(int i: result){
      System.out.print(i+" ");
    }
  }

  public static int[] solve(int[] A) {
    int[] res = new int[A.length];
    int n = A.length;
    List<Integer> list = new ArrayList<>();
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    for(int i: A){
      stack1.push(i);
    }
    while(!stack1.isEmpty()){
      int temp = stack1.pop();
      if(stack2.isEmpty()){
        stack2.push(temp);
      }
      else{
        while(!stack2.isEmpty() && stack2.peek() > temp){
          stack1.push(stack2.pop());
        }
        stack2.push(temp);
      }
    }
    while(!stack2.isEmpty()){
      list.add(stack2.pop());
    }
    for(int j=0; j<n; j++){
      res[n-j-1] = list.get(j);
    }
    return res;
  }
}
