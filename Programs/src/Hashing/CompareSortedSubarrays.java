package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CompareSortedSubarrays {
  public static void main(String[] args) {
    int[] A = {1, 7, 11, 8, 11, 7, 1};
    int[][] B = new int[1][4];
    B[0][0] = 0;
    B[0][1] = 2;
    B[0][2] = 4;
    B[0][3] = 6;
    int[] res = solve(A,B);
    for(int i: res){
      System.out.print(i+" ");
    }
  }

  public static int[] solve(int[] A, int[][] B) {
    int[] resArr = new int[B.length];
    Map<Integer,Integer> map = new HashMap<>();
    int[] hashArr = new int[A.length];
    for(int i=0; i<A.length ; i++){
      if(map.containsKey(A[i])){
        hashArr[i] = map.get(A[i]);
      }
      else{
        int hashValue = hashCode(A[i]);
        map.put(A[i],hashValue);
        hashArr[i]= hashValue;
      }
    }
    int[] prefixArr = new int[A.length];
    int prefix = hashArr[0];
    prefixArr[0] = hashArr[0];
    for(int j=1; j<A.length; j++){
      prefix += hashArr[j];
      prefixArr[j] = prefix;
    }

    for(int k=0; k<B.length; k++){
      int l1= B[k][0];
      int r1 = B[k][1];
      int l2 = B[k][2];
      int r2 = B[k][3];

      if(prefixArr[r1] == prefixArr[r2]-prefixArr[l2-1]){
        resArr[k] = 1;
      }
      else{
        resArr[k] = 0;
      }
    }

    return resArr;
  }

  public static int hashCode(int n){
    //Returned hash code value for this object
   // int hashValue = Integer.valueOf(n).hashCode();
    int hashValue =  n;
    System.out.println("Hash code Value for"+n +" is :" + hashValue);
    return hashValue;
  }
}
