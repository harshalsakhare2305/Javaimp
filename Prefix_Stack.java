import java.util.Stack;

public class Prefix {
      public static void main(String[] args) {
        String postfix = "-9/*+5346";
        int n = postfix.length();
        Stack<Integer> val = new Stack<>(); // stack to store the number
       for(int i=n-1;i>=0;i--){
        char ch =postfix.charAt(i);
        int ascii =(int)ch;
        if(ascii>=48 && ascii<=57){
            val.push(ascii-48);
        }else{
              int v1=val.pop();
             int v2=val.pop();
           if(ch=='+'){
            val.push(v1+v2);
           }
           if(ch=='-'){
            val.push(v1-v2);
           }
           if(ch=='*'){
            val.push(v1*v2);
           }
           if(ch=='/'){
            val.push(v1/v2);
           }
             
        }
       }

       System.out.println(val.peek());
}
}
