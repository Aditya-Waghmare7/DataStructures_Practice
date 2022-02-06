import java.util.*;

public class GroupShiftedString {

    //Input --> str[] = {"acd", "dfg", "wyz", "yab", "mop","bdfh", "a", "x", "moqs"};
    //Output -->  a x
    //         acd dfg wyz yab mop
    //         bdfh moqs

    private static int ALPHA = 26;
    public static void main(String[] args) {
        String[] sArr = {"acd", "dfg", "wyz", "yab", "mop","bdfh", "a", "x", "moqs"};
        List<List<String>> resultList = getGroupShiftedString(sArr);
        for(List<String> s: resultList){
            for(String s1: s){
                System.out.print(s +" ");
            }
            System.out.println("");
        }
    }

    public static List<List<String>> getGroupShiftedString(String[] sArr){
        List<List<String>> sList = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s: sArr){
            String diffStr = getDiffString(s);
            if(map.containsKey(diffStr)){
                List<String> arrList = map.get(diffStr);
                arrList.add(s);
                map.put(diffStr,arrList);
            }
            else{
                List<String> arrList = new ArrayList<>();
                arrList.add(s);
                map.put(diffStr,arrList);
            }
        }
       //Iterate over map values and add to resultant list
        map.forEach((key,val) -> sList.add(map.get(key)));
        return sList;
    }

    public static String getDiffString(String str){
        String shift = "";
        for(int i=1; i<str.length(); i++){
            int diff = str.charAt(i)-str.charAt(i-1);
            if(diff < 0){
                diff += ALPHA;
            }
            shift += (diff +'a');
        }
        return shift;
    }

}
