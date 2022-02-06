package Stacks;

import java.util.Stack;

public class NearestSmallerElement {
  public static void main(String[] args) {
    int[] arr = {34, 35, 27, 42, 5, 28, 39, 20, 28};
    int[] result = prevSmaller(arr);
    System.out.print("Result: "+ result);
  }

  public static int[] prevSmaller(int[] A) {
    int[] resultArr = new int[A.length];
    if(A.length == 0){
      return resultArr;
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(A[0]);
    resultArr[0] = -1;
    for(int i=1; i< A.length; i++){
      int x = stack.peek();
      if(x < A[i]){
        resultArr[i] = x;
      }
      else{
        resultArr[i] = -1;
        stack.pop();
        stack.push(A[i]);
      }
    }

    return resultArr;
  }
}
