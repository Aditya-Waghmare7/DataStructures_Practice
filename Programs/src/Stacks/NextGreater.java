package Stacks;

import java.util.*;

public class NextGreater {
  public static void main(String[] args) {
    int[] arr = {8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34 };
    int[] result = nextGreater(arr);
    for(int k: result){
      System.out.print(k+" ");
    }
  }

  public static int[] nextGreater(int[] A) {
    int[] resArr = new int[A.length];
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Queue<Integer>> map = new HashMap<>();
    stack.push(A[0]);
    for(int i=1;i<A.length; i++){
      if(A[i] > stack.peek()){
        while(!stack.isEmpty() && A[i] > stack.peek()){
          int val = stack.pop();
          if(map.containsKey(val)){
            Queue<Integer> queue = map.get(val);
            queue.add(Integer.valueOf(A[i]));
          }
          else{
            Queue<Integer> newQueue = new LinkedList<>();
            newQueue.add(Integer.valueOf(A[i]));
            map.put(val,newQueue);
          }
        }
        stack.push(A[i]);
      }
      else{
        stack.push(A[i]);
      }
    }
    for(int j=0; j<A.length; j++){
      if(map.containsKey(A[j])){
        if(map.get(A[j]).size() > 0){
          resArr[j] = map.get(A[j]).poll();
        }
        else
          resArr[j] = -1;
      }
      else{
        resArr[j] = -1;
      }
    }

    return resArr;
  }
}