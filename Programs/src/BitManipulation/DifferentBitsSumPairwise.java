package BitManipulation;

public class DifferentBitsSumPairwise {
  public static void main(String[] args) {
    int[] arr = {1, 3, 5};
    int ans = cntBits(arr);
    System.out.println("Ans: "+ ans);
  }

  public static int cntBits(int[] A) {
    long mod = 1000000007;
    long ans = 0;
    int count_1;
    long temp = (int) (Math.floor(Math.log(Integer.MAX_VALUE))+1);
    for(int i=0; i<32; i++){
      long countSetBit=0;
      long countUnsetSetBit=0;
      temp = 1 << i;
      for(int j=0; j<A.length; j++){
        if((A[j]&temp) > 0){
          countSetBit++;
        }
        else{
          countUnsetSetBit++;
        }
      }
//      if(countSetBit == 0 || countUnsetSetBit == 0){
//
//        if(countUnsetSetBit == 0)
//          countUnsetSetBit = 1;
//        else
//          countSetBit = 1;
//      }

      ans = ans%mod+ ((countSetBit%mod)*(countUnsetSetBit%mod)*2)%mod;
      ans %= mod;
    }
    return (int)ans;
  }
}
