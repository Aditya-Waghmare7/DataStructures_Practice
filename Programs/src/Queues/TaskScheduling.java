package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {
  public static void main(String[] args) {
    int[] arr1 = {2, 3, 1, 5, 4};
    int[] arr2 = {1, 3, 5, 4, 2};
    System.out.println("Answer: "+solve(arr1,arr2));

  }

  public static int solve(int[] A, int[] B) {
    int ans = 0;
    Queue<Integer> q= new LinkedList<>();
    for(int i=0; i<A.length; i++){
      q.add(A[i]);
    }
    for(int j=0; j<A.length; j++){
      while(B[j] != q.peek()){
        int temp = q.peek();
        q.poll();
        ans++;
        q.add(temp);
      }
      ans++;
      q.poll();
    }
    return ans;
  }
}
