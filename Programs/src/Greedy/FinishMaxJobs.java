package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FinishMaxJobs {

  static class Duration{
    public Duration(int start, int end){
      this.start = start;
      this.end = end;
    }

    public int start;
    public int end;

  }

  public static void main(String[] args) {
    int[] startArr = {1, 5, 7, 1};
    int[] endArr = {7, 8, 8, 8};
    int result = solve(startArr, endArr);
    System.out.print("Result: "+ result);
  }

  public static int solve(int[] A, int[] B) {
    int res = 1;
    //Sort both Arrays based on B's index
    //Combining both Arrays
    Duration[] durrArr = new Duration[A.length];
    for(int i=0; i<A.length; i++){
      durrArr[i] = new Duration(A[i],B[i]);
    }

    Arrays.sort(durrArr, new Comparator<Duration>() {
      @Override
      public int compare(Duration o1, Duration o2) {
        return Integer.compare(o1.end,o2.end);
      }
    });

    //Start with start index and check for further combinations possible
    int end = durrArr[0].end;
    for(int j=1; j<durrArr.length; j++){
      if(durrArr[j].start >= end){
        res++;
        end = durrArr[j].end;
      }
    }

    return res;
  }


}
