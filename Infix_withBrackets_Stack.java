import java.util.Stack;

public class Infix {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        int n = str.length();
        Stack<Integer> val = new Stack<>(); // stack to store the number
        Stack<Character> op = new Stack<>(); // stack to store the operator
        int v1, v2;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            } else if (op.size() == 0 || ch =='(' || op.peek() =='(') {
                op.push(ch);
            }else if(ch==')'){
               //work 
               while(op.peek()!='('){
                 v2 = val.pop();
                    v1 = val.pop();
                    if (op.peek() == '+') {
                        val.push(v1 + v2);
                    }

                    if (op.peek() == '-') {
                        val.push(v1 - v2);
                    }

                    if (op.peek() == '*') {
                        val.push(v1 * v2);
                    }

                    if (op.peek() == '/') {

                        val.push(v1 / v2);
                    }

                    op.pop();
               }
               op.pop();  // humne '(' hata diya

            }  else {
                // work

                if (  ch == '+' || ch == '-') {
                    // work

                    v2 = val.pop();
                    v1 = val.pop();
                    if (op.peek() == '+') {
                        val.push(v1 + v2);
                    }

                    if (op.peek() == '-') {
                        val.push(v1 - v2);
                    }

                    if (op.peek() == '*') {
                        val.push(v1 * v2);
                    }

                    if (op.peek() == '/') {

                        val.push(v1 / v2);
                    }

                    op.pop();

                    op.push(ch);
                  

                }
                if(   ch == '*' || ch == '/') {

                  if(op.peek()=='*'||op.peek() =='/'){
                     v2 = val.pop();
                   v1 = val.pop();

                    if (op.peek() == '*') {
                        val.push(v1 * v2);
                    }

                    if (op.peek() == '/') {

                        val.push(v1 / v2);
                    }

                    if (!op.isEmpty()) {
                        op.pop();
                    }
                    op.push(ch);

                  }
                  else{
                    op.push(ch);
                  }
                }

            }
        }

        while (val.size() > 1 && op.size()>0) {
            if (!val.isEmpty()) {
                v2 = val.pop();
                v1 = val.pop();
                if (op.peek() == '+')
                    val.push(v1 + v2);
                if (op.peek() == '-')
                    val.push(v1 - v2);
                if (op.peek() == '*')
                    val.push(v1 * v2);
                if (op.peek() == '/')
                    val.push(v1 / v2);

                if (!op.isEmpty()) {
                    op.pop();
                }
            }

        }

        System.out.println(val.peek());
    }
}
