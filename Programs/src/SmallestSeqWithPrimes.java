/**
 * Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.
 *Input Format
 * First argument is an integer A.
 * Second argument is an integer B.
 * Third argument is an integer C.
 * Fourth argument is an integer D.
 * Output Format
 * Return an integer array of size D, denoting the first D integers described above.
 * NOTE: The sequence should be sorted in ascending order
 * Example Input 1: A = 2, B = 3, C = 5, D = 5
 * Input 2: A = 3, B = 2, C = 7, D = 3
 *Example Output 1:[2, 3, 4, 5, 6]
 * Output 2: [2, 3, 4]
 *
 */
import java.util.PriorityQueue;

public class SmallestSeqWithPrimes {
  public static void main(String[] args) {
      int A=2, B=3, C=7, D=3;
      int[] result = solve(A,B,C,D);
      for(int i: result){
        System.out.print(i+" ");
      }
  }

  public static int[] solve(int A, int B, int C, int D) {
    int[] resArr = new int[D];
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    pQueue.add(A);
    pQueue.add(B);
    pQueue.add(C);
    int count = 0;
    while(count < D){
      int val = pQueue.peek();
      //Generating multiples of Nos Already Sorted
      pQueue.add(val*A);
      pQueue.add(val*B);
      pQueue.add(val*C);
      resArr[count] = pQueue.poll();
      //Removing copies of Same Values from PQueue
      while(pQueue.peek() == val){
        pQueue.poll();
      }
      count++;
    }

    return resArr;
  }
}
