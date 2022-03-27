package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrays {

  public static void main(String[] args) {
    int[] arr = {1, 1, 3};
    int ans = solve(arr);
    System.out.println("Answer: "+ ans);
  }

  public static int solve(int[] A) {
    long ans = 0;
    int l=0, r=0;
    Map<Integer,Integer> freqMap = new HashMap<>();
    while(r < A.length && l<=r){
      if(l==r){
        r++;
      }
      if(!freqMap.containsKey(A[l])){
        freqMap.put(A[l],1);
        ans += (r-l+1);
        r++;
      }
      else if(!freqMap.containsKey(A[r])){
        freqMap.put(A[r],1);
        ans += (r-l+1);
        r++;
      }
      else{
        freqMap.put(A[l],freqMap.get(A[l]-1));
        l++;
        ans += r-l+1;
      }
    }
    return (int)ans%(1000000007);
  }

   public static int solve1(int[] A) {
     long ans = 1;
     int l=0, r=0;
     int mod = 1000000007;
     Map<Integer,Integer> freqMap = new HashMap<>();
     freqMap.put(A[l],1);
     while(r < A.length && l<=r){
       if(freqMap.containsKey(A[r])){
         ans += r-l+1;
         r++;
         l++;
       }
       else{
         freqMap.put(A[r],1);
         ans += r-l+1;
         r++;
       }
     }

     return (int)ans%mod;
   }
}
