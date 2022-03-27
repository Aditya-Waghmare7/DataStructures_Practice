package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContinuousSeriesOf1s {
  public static void main(String[] args) {
      Integer[] arr = {1,1,0,1,1,0,0,1,1,1};
      List<Integer> result = maxone(Arrays.asList(arr),1);
      for(int i:result){
        System.out.print(i+" ");
      }
  }

  public static List<Integer> maxone(List<Integer> A, int B) {
    List<Integer> resList = new ArrayList<>();
    int i=0, j=0, n= A.size();
    int count = B;
    int start=0, length=0, max_length = Integer.MIN_VALUE;
    while(i<n && j<n){
      if(A.get(i) == 0 && count == 0){
        if(i==j) j++;
        i++;
      }
      while(j<n && (A.get(j)==1 || count>0)){
        if(A.get(j) == 0){
          count--;
        }
        j++;
      }
      length = j-i;
      if(max_length<length){
        start = i;
        max_length = length;
      }

      //Moving to next starting point leaving one zero and therefore incrementing count by 1
      while (i< n && A.get(i) ==1)
        i++;
      i++;
      count++;
    }
    for (int k=start; k<max_length; k++){
      resList.add(k);
    }
    return resList;
  }
}
