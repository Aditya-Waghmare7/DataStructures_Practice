package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArray{
  public static void main(String[] args) {
    Integer[] arr = {4, 0, 2, 1, 3};
    List<Integer> list =  Arrays.asList(arr);
    List<Integer> result = arrange(list);
    for (Integer i: result){
      System.out.print(i+" ");
    }
  }

  public static List<Integer> arrange(List<Integer> A) {
    int n = A.size();
    List<Integer> B = new ArrayList<>();
    for(int i=0; i<n; i++){
      int val = A.get(i);
      //val = val*n;
      //val += A.get(A.get(val/n))/n;\
      int new_val = A.get(val);

      B.add(i,new_val);
    }
    return B;
  }
}
