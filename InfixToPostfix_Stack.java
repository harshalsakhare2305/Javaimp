import java.util.Stack;

public class InfixToPostfix {
     public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        System.out.println(infix);
        int n = infix.length();
        Stack<String> val = new Stack<>(); // stack to store the number
        Stack<Character> op = new Stack<>(); // stack to store the operator
        String v1, v2;
     

        for (int i = 0; i < n; i++) {
            char ch = infix.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                String s =""+ch;
                val.push(s);
            } else if (op.size() == 0 || ch =='(' || op.peek() =='(') {
                op.push(ch);
            }else if(ch==')'){
               //work 
               while(op.peek()!='('){
                    v2 = val.pop();
                    v1 = val.pop();
                    char opr =op.pop();
                     String str =v1+v2+opr;
                     val.push(str);

               }
               op.pop();  // humne '(' hata diya

            }  else {
                // work

                if (  ch == '+' || ch == '-') {
                    // work
                     v2 = val.pop();
                    v1 = val.pop();
                     char opr =op.pop();
                     String str =v1+v2+opr;
                     val.push(str);
                   
                    op.push(ch);
                  

                }
                if(   ch == '*' || ch == '/') {

                  if(op.peek()=='*'||op.peek() =='/'){
                   
                      v2 = val.pop();
                    v1 = val.pop();
                     char opr =op.pop();
                     String str =v1+v2+opr;
                     val.push(str);
                   
                    
                    op.push(ch);

                  }
                  else{
                    op.push(ch);
                  }
                }

            }
        }

        while (val.size() > 1 && op.size()>0) {
              v2 = val.pop();
                    v1 = val.pop();
                     char opr =op.pop();
                     String str =v1+v2+opr;
                     val.push(str);
                   
                  
        }

        System.out.println(val.peek());
    }
}
