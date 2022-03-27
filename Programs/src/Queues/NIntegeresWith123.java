package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NIntegeresWith123 {
  public static void main(String[] args) {
    int[] result = solve(10);

    List<Integer> resList = solve1(10);
    for(int i:resList){
      System.out.print(i+" ");
    }
  }

  public static int[] solve(int A) {
    int[] resArr = new int[A];
    int count = 0;
    int resCount = 0;
    Queue<Integer> queue = new LinkedList<>();
    while(count <= A){
      if(queue.isEmpty()){
        queue.add(1);
        queue.add(2);
        queue.add(3);
        count += 3;
      }
      else{
        int val = queue.peek();
        queue.add(val*10 +1);
        queue.add(val*10 +2);
        queue.add(val*10 +3);
        count += 3;
        resArr[resCount] = queue.poll();
        resCount++;
      }
    }

    while(!queue.isEmpty() && resCount<A){
      resArr[resCount] = queue.poll();
      resCount++;
    }
    return resArr;
  }

  //Optimized Approach (Single loop)
  public static ArrayList<Integer> solve1(int A) {
    Queue<Integer> q = new LinkedList <Integer> ();
    ArrayList <Integer> ans = new ArrayList < > ();
    q.add(1);
    q.add(2);
    q.add(3);
    int cnt=3;
    while (ans.size() < A) {
      int x = q.peek();
      ans.add(x);
      q.remove();
      if(cnt>=A)continue;
      q.add(10 * x + 1);
      q.add(10 * x + 2);
      q.add(10 * x + 3);
      cnt+=3;
    }
    return ans;
  }
}
