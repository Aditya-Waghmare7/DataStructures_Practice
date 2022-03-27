package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack<highestFreq> {
  public static void main(String[] args) {
      int[][] arr ={{1,5},
                    {1,7},
                    {1,5},
                    {1,7},
                    {1,4},
                    {1,5},
                    {2,0},
                    {2,0},
                    {2,0},
                    {2,0}};

      int[] resArr = solve(arr);
      for(int i:resArr){
        System.out.print(i+" ");
      }
  }

  public static int[] solve(int[][] A){
    int[] resArr = new int[A.length];
    for(int i=0; i<A.length; i++){
      int operation = A[i][0];
      int val = A[i][1];
      if(operation == 1){
        push(val);
        resArr[i] = -1;
      }
      else{
        int ret = pop();
        resArr[i] = ret;
      }
    }

    return resArr;
  }

  public static Map<Integer,Integer> freq= new HashMap<>();
  public static Map<Integer, Stack<Integer>> stackOfFreq = new HashMap<>();

  public static Integer highestFreq = 0;

  static void push(int x){
    int f = 0;
    if(freq.containsKey(x)){
      f = freq.get(x);
      f++;
      freq.put(x,f);
    }
    else{
      f = 1;
      freq.put(x,1);
    }
    if(f > highestFreq){
      highestFreq = f;
    }
    if(stackOfFreq.containsKey(f)){
      Stack<Integer> stack = stackOfFreq.get(f);
      stack.push(x);
      stackOfFreq.put(f,stack);
    }
    else{
      Stack<Integer> stack = new Stack<>();
      stack.push(x);
      stackOfFreq.put(f,stack);
    }
  }

  static int pop(){
    int retVal = -1;
   Stack<Integer> stack = stackOfFreq.get(highestFreq);
   if(!stack.isEmpty())
   {
     retVal = stack.pop();
     stackOfFreq.put(highestFreq,stack);
     freq.put(retVal,freq.get(retVal)-1);
   }

  if(stackOfFreq.get(highestFreq).isEmpty()){
    highestFreq--;
  }
  return retVal;
  }

}
