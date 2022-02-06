public class PermutationsOfAinB {
    public static void main(String[] args) {
        String A = "abc";
        String B = "abcbacabc";
        int ans = solve(A,B);
        System.out.println("Answer:: "+ ans);
    }

    public static int solve(String A, String B) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int ans =0;
        for(char c: A.toCharArray()){
            freq1[c-'a'] += 1;
        }
        int n = A.length();
        String s1 = B.substring(0,n);
        for(int i=0; i<s1.length(); i++){
            freq2[s1.charAt(i)-'a'] += 1;
        }
        if(compareArr(freq1,freq2)){
            ans++;
        }
        //Sliding Window Technique
        for(int k=n;k<B.length(); k++){
            freq2[B.charAt(k)-'a'] += 1;
            freq2[B.charAt(k-n)-'a'] -= 1;
            if(compareArr(freq1,freq2)){
                ans++;
            }
        }
        return ans;
    }

    public static boolean compareArr(int[] arr1, int[]arr2){
        for(int j=0; j<26; j++){
            if(arr1[j] != arr2[j]){
                return false;
            }
        }
        return true;
    }
}
