package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumber {
  public static void main(String[] args) {
    String perfectNo = solve(5);
    System.out.print("Perfect No: "+ perfectNo);
  }
  
  public static String solve(int A){
    String resString = "";
    String[] strArr = new String[A];
    Queue<String> queue = new LinkedList<>();
    int count = 2;
    int resCount = 0;
    queue.add("1");
    queue.add("2");
    while(count <= A && !queue.isEmpty()){
      String strVal = queue.poll();
      String resVal = reverse(strVal);
      //Compute next two vals
      String s1 = Integer.parseInt(strVal)*10 +1+"";
      String s2 = Integer.parseInt(strVal)*10 +2+"";
      queue.add(s1);
      queue.add(s2);
      strArr[resCount] = resVal;
      resCount ++;
      count += 2;
    }

    //Getting reqValue from Queue
    while(!queue.isEmpty() && resCount<A){
      String s1 = queue.poll();
      String resStr = reverse(s1);
      strArr[resCount] = resStr;
      resCount++;
    }

    return strArr[A-1];
  }

  public static String reverse(String s){
    StringBuilder sb = new StringBuilder();
    char[] charArr = s.toCharArray();
    for(int i=charArr.length-1; i>=0; i--){
      sb.append(charArr[i]);
    }
    return s+sb.toString();
  }
}
