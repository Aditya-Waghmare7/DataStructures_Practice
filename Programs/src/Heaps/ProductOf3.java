package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class ProductOf3 {

    public static void main(String[] args) {
        int[] arr ={10, 2, 13, 4};
        int[] result = solve(arr);
    }

    public static int[] solve(int[] A) {
        int[] result = new int[A.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<A.length; i++){
           if(count < 2){
               pq.add(A[i]);
               result[i] = -1;
           }
           else{
               pq.add(A[i]);
               int a = pq.poll();
               int b = pq.poll();
               int c = pq.poll();
               int product = a*b*c;
               result[i] = product;
               pq.add(a);
               pq.add(b);
               pq.add(c);
           }
            count++;

        }
        return result;
    }
}
