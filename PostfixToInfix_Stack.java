public static String postToInfix(String postfix) {
        int n= postfix.length();
        Stack<String> val =new Stack<>();
        for(int i=0;i<n;i++){
            char ch =postfix.charAt(i);
            int ascii =(int)ch;
            if(ascii !=42 && ascii !=43 && ascii !=45 && ascii!=47 ){ //ch is not the operator
                String s ="" +ch;
                val.push(s);
            }else{
               String v2=val.pop();
             String v1=val.pop();
             char op =ch;
                String str ="("+v1+op+v2+")";
                val.push(str);
            }
        }
        String ans =val.peek();
     return ans ;
