package Queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatCharacter {
  public static void main(String[] args) {
      String str = "abadbc";
      String result = solve(str);
      System.out.println("Result: " + result);
  }

  public static String solve(String A) {
    StringBuffer sb = new StringBuffer();
    Map<Character,Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();
    for(char c: A.toCharArray()){
        if(map.containsKey(c)){
          map.put(c,map.get(c)+1);
        }
        else{
          map.put(c,1);
        }
        queue.add(c);
        while (!queue.isEmpty() && map.get(queue.peek())>1){
          queue.poll();
        }
        if(!queue.isEmpty()){
          sb.append(queue.peek());
        }
        else{
          sb.append("#");
        }
    }
    return sb.toString();
  }
}
