package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Seats {
  public static void main(String[] args) {
    String str = "....x..xx...x..";

    int ans = seats(str);
    System.out.println("Answer -> "+ ans);
  }

  public static int seats(String A) {
    int n = A.length();
    int res = 0;
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<n; i++){
      if(A.charAt(i) == 'x'){
        list.add(i);
      }
    }
    int m = list.size();
    int mid = m/2;
    int left = mid-1, right = mid+1, k=1;
    while(left >= 0){
      res += list.get(mid)-k-list.get(left);
      left--;
      k++;
    }
    k = 1;
    while(right < m){
      res += list.get(right)-k-list.get(mid);
      right++;
      k++;
    }

    return res;
  }

}
