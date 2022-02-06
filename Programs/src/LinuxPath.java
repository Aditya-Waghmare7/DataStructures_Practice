import java.util.Stack;

public class LinuxPath {

    public static void main(String[] args){
        String input = "/a//b/c/../../d";
        String input1 = "/../../";
        String input3 = "a//b";
        String input4 = "/a/./b/../../c/";

        String result = getLinuxPath(input4);
        System.out.println("Result--> "+ result);
    }


    // /a/b/c/../d
    public static String getLinuxPath(String s1){
        String[] sArr = s1.split("/");
        StringBuffer sb = new StringBuffer();
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        for(String s: sArr){
            //eDGE Case
            if(!s.isBlank()){
                if(s.equalsIgnoreCase("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if(s.equalsIgnoreCase(".")){
                    continue;
                }
                else{
                    stack.push(s);
                }
            }
        }

        //Reversing the Stack
        //sb.append("/");
        while(!stack.isEmpty()){
            String s2 = stack.pop();
            stack1.push(s2);
        }
        while(!stack1.isEmpty()) {
            sb.append("/");
            sb.append(stack1.pop());

        }
        String rs =  sb.toString();
        if(rs.isBlank()){
            return "/";
        }
        return rs;
    }
}
