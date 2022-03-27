package ModularArithematic;
/**
 * Given a positive integer A. Return an array of minimum length whose elements represent the powers of 3 and the sum of all the elements is equal to A.
 * Problem Constraints
 * 1 <= A <= 109
 * Input Format
 * Single argument is an integer A.
 * Output Format
 * Return an array of minimum length of powers of 3 whose elements sums to A.

 * Example Input
 * Input 1: 13
 * Input 2: 3
 * Example Output
 * Output 1: [1, 3, 9]
 * Output 2: [3]
 * Example Explanation
 * Explanation 1: 30 = 1, 31 = 3, 32 = 9.
 *  Also, 1 + 3 + 9 = 13. Here A = 13 which can be represented as the sum of 1, 3 and 9.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerOf3 {
  public static void main(String[] args) {
      ArrayList<Integer> result = solve(34);
      for(Integer i: result){
        System.out.print(i+" ");
      }
  }

  public static ArrayList<Integer> solve(int A){
    List<Integer> resList = new ArrayList<>();
    List<Integer> remList = new ArrayList<>();
    int rem = A, quotient = A;
    while(quotient != 0){
      rem = quotient%3;
      remList.add(rem);
      quotient = quotient/3;
    }
    for(int i=0; i<remList.size(); i++){
      if(remList.get(i) == 0){
        continue;
      }
      else if(remList.get(i) == 2){
        resList.add((int)Math.pow(3,i));
        resList.add((int)Math.pow(3,i));
      }
     else
       resList.add((int)Math.pow(3,i));
    }


    return (ArrayList<Integer>) resList;
  }
}
