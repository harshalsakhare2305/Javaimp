import java.util.Stack;
public class Solution {
    public static String postfixToPrefix(String exp) {
         int n=exp.length();
        Stack<String> val =new Stack<>();
        for(int i=0;i<n;i++){
            char ch =exp.charAt(i);
            int ascii =(int)ch;
            if(ascii!=42 && ascii!=43 && ascii!=45 && ascii!=47){ // ch is not operator
                String t =""+ch;
                val.push(t);
            }else{
                String v2=val.pop();
                String v1= val.pop();
                String str =ch+v1+v2;
                val.push(str);

            }
        }

        return val.peek();
    }
}
