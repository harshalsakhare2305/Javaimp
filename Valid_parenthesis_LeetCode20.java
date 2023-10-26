import java.util.*;
class Solution {
    public boolean isValid(String s) {
         int n =s.length();
         if(n==1){
            return false;
        }
        Stack<Character> st =new Stack<>();
       
        
        for(int i=0;i<n;i++){
            char curr =s.charAt(i);
            if(curr =='('){
              st.push(')');
            } else if(curr =='['){
              st.push(']');
            } else if(curr =='{'){
              st.push('}');
            }else if(st.size() ==0 || st.pop()!=curr){
                return false;
            }
        }
        return st.isEmpty();
    }
}
