package Stacks;

import java.util.Stack;

public class ReverseElementsOfQueue {

  public static void main(String[] args) {
    int[] arr = { 43, 35, 25, 5, 34, 5, 8, 7};
    int[] result = solve(arr,6);
    for(int k: result){
      System.out.print(k+" ");
    }

  }

  public static int[] solve(int[] A, int B) {
    Stack<Integer> stack = new Stack<>();
    int[] resArr = new int[A.length];
    for(int i=0; i<B; i++){
      stack.add(A[i]);
    }
    int count = 0;
    while(!stack.isEmpty()){
      resArr[count] = stack.pop();
      count++;
    }
    for(int j=B; j<A.length; j++){
      resArr[count] = A[j];
      count++;
    }
    return resArr;
  }
}
