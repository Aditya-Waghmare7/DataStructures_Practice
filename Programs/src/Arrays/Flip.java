package Arrays;

public class Flip {
  public static void main(String[] args) {
    String str = "111";
    int[] result = flip(str);
    for(int i: result){
      System.out.print(i+" ");
    }
  }

  public static int[] flip(String A) {
    int n = A.length();
    int[] arr = new int[n];
    char[] cArr = A.toCharArray();
    for(int i=0; i<n; i++){
      if(cArr[i] == '1'){
        arr[i] = -1;
      }
      else
        arr[i] = 1;
    }
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    int best_till_now = 0, best_ending_here = 0, l=0;
    for(int i=0; i<n; i++){
      if(best_ending_here + arr[i] < 0){
        l = i+1;
        best_ending_here = 0;
      }
      else
        best_ending_here += arr[i];
      if(best_ending_here > best_till_now){
        best_till_now = best_ending_here;
        first = l;
        second = i;
      }
    }
    if(first == Integer.MAX_VALUE){
      return new int[]{};
    }
    int[] result = new int[2];
    result[0] = first+1;
    result[1] = second+1;

    return result;
  }
}
