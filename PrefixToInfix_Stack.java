import java.util.Stack;

public class Solution {
    public static String prefixToInfixConversion(String exp) {
       int n= exp.length();
       Stack<String> val = new Stack<>();
       for(int i=n-1;i>=0;i--){
           char ch =exp.charAt(i);
           int ascii =(int) ch;
           if(ascii !=42 && ascii !=43 && ascii !=45 && ascii !=47){
               String s =""+ch;
               val.push(s);

           }else{
               String v1=val.pop();
               String v2 =val.pop();
               char op=ch;

               String str ="("+v1+op+v2+")";
               val.push(str);
           }


       }

       return val.peek();
    }
}
