import java.util.Stack;

public class Postfix {
        public static void main(String[] args) {
        String postfix = "953+4*6/-";
        int n = postfix.length();
        Stack<Integer> val = new Stack<>(); // stack to store the number
       for(int i=0;i<n;i++){
        char ch =postfix.charAt(i);
        int ascii =(int)ch;
        if(ascii>=48 && ascii<=57){
            val.push(ascii-48);
        }else{
              int v2=val.pop();
             int v1=val.pop();
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
